/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.dtos.QuestionContainer;
import com.epn.dtos.QuizContainer;
import com.epn.dtos.QuizSave;
import com.epn.entities.FilterTypes;
import com.epn.entities.QuestionItem;
import com.epn.entities.Questions;
import com.epn.entities.QuestionsPK;
import com.epn.entities.Quiz;
import com.epn.entities.SearchObject;
import com.epn.exception.AppException;
import com.epn.mapper.QuestionMapper;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author david
 */
@Stateless
public class QuestionDAO extends GenericDAO<Questions> {

    @Inject()
    ItemQuestionDAO itemQuestionDAO;
    private final QuestionMapper questionMapper = Mappers.getMapper(QuestionMapper.class);

    public QuestionDAO() {
        super(Questions.class);
    }

    public List<QuestionContainer> getQuestionbycodequiz(Long codeQuiz) {
        SearchObject search = new SearchObject("questionsPK");
        search.addParameter("questionsPK.codeQuiz", FilterTypes.EQUAL, codeQuiz);

        List<Questions> resultList = search(search);
        List<QuestionContainer> containers = questionMapper.sourceListToDestination(resultList);
        return containers;
    }

    public List<QuestionContainer> getQuestionByCodeQuizAndCodeQuestions(Long codeQuiz, Long codeQuestions) {
        SearchObject search = new SearchObject("questionsPK");
        search.addParameter("questionsPK.codeQuiz", FilterTypes.EQUAL, codeQuiz);
        search.addParameter("questionsPK.codeQuestions", FilterTypes.EQUAL, codeQuestions);

        List<Questions> resultList = search(search);
        List<QuestionContainer> containers = questionMapper.sourceListToDestination(resultList);
        return containers;
    }

    public void deleteQuestion(QuizSave quizContainer) {
        quizContainer.getQuestiondeleted().forEach(elementremove -> {
            if (elementremove.getQuestionsPK().getCodeQuestions() != 0) {
                Questions foundelement = find(elementremove.getQuestionsPK());
                if (foundelement != null) {
                    try {
                        remove(foundelement);
                    } catch (Exception e) {
                        throw new AppException(e.toString(), "NO PUDO ELIMINAR LAS PREGUNTAS");
                    }
                }
            }

        });
    }

    public List<Questions> saveQuestion(QuizSave quizContainer, Quiz quiz) {
        List<Questions> questionsaved = new ArrayList();
        quizContainer.getQuiz().getQuestionsList().forEach(question -> {

            QuestionsPK questionsPK = new QuestionsPK();
            questionsPK.setCodeQuestions(question.getQuestionsPK().getCodeQuestions());
            questionsPK.setCodeQuiz(quiz.getQuizPK().getCodeQuiz());
            Questions questionstemp = new Questions(questionsPK);
            questionstemp.setDescription(question.getDescription());
            questionstemp.setStatus(question.getStatus());
            questionstemp.setStatusCat(question.getStatusCat());
            questionstemp.setQuestion(question.getQuestion());
            questionstemp.setDiffuseDelphiDiscriminatorbyQuestion(question.getDiffuseDelphiDiscriminatorbyQuestion());
            questionstemp.setMinimumParameterSetting(question.getMinimumParameterSetting());
            questionstemp.setMaximumParameterSetting(question.getMaximumParameterSetting());
            questionstemp.setJumpNext(question.getJumpNext());
            
                update(questionstemp);
                List<QuestionItem> questionItemListsaved = itemQuestionDAO.saveItem(questionstemp, question.getQuestionItemList());
                questionstemp.setQuestionItemList(questionItemListsaved);
                questionsaved.add(questionstemp);
            
        });
        return questionsaved;
    }
}
