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
import com.epn.entities.Questions;
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
        SearchObject search = new SearchObject("codeQuestions");
        search.addParameter("codeQuiz", FilterTypes.EQUAL, codeQuiz);

        List<Questions> resultList = search(search);
        List<QuestionContainer> containers = questionMapper.sourceListToDestination(resultList);
        return containers;
    }

    public void deleteQuestion(QuizSave quizContainer) {
        quizContainer.getQuestiondeleted().forEach(elementremove -> {
            try {
                Questions foundelement = new Questions();
                if (elementremove.getQuestionsPK().getCodeQuestions() != 0) {
                    foundelement = find(elementremove.getQuestionsPK().getCodeQuestions());
                    if (foundelement != null) {
                        remove(foundelement);
                    }
                }
            } catch (Exception e) {
                throw new AppException(e.toString(), "NO PUDO ELIMINAR LAS PREGUNTAS");
            }

        });
    }

    public void saveQuestion(QuizSave quizContainer, Quiz quiz) {

        quizContainer.getQuestionsList().forEach(question -> {
            try {
                Questions questionstemp = new Questions();
                questionstemp.getQuestionsPK().setCodeQuestions(question.getQuestionsPK().getCodeQuestions());
                questionstemp.setDescription(question.getDescription());
                questionstemp.setStatus(question.getStatus());
                questionstemp.setStatusCat(question.getStatusCat());
                questionstemp.setQuestion(question.getQuestion());
                questionstemp.setMinimumParameterSetting(question.getMinimumParameterSetting());
                questionstemp.setMaximumParameterSetting(question.getMaximumParameterSetting());
                questionstemp.setJumpNext(question.getJumpNext());
                questionstemp.setQuiz(quiz);
                update(questionstemp);
                try {
                    itemQuestionDAO.saveItem(questionstemp, question.getQuestionItemList());
                } catch (Exception ex) {
                     throw new AppException(ex.toString(), "NO SE GUARDO ITEMS DE PREGUNTAS");
                }
            } catch (Exception e) {
                throw new AppException(e.toString(), "NO SE GUARDO PREGUNTAS");
            }

        });

    }
}
