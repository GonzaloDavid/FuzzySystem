/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.dtos.ItemQuestionContainer;
import com.epn.dtos.ListAndCountContainer;
import com.epn.dtos.QuestionContainer;
import com.epn.dtos.QuizContainer;
import com.epn.dtos.QuizContainerList;
import com.epn.dtos.QuizSave;
import com.epn.entities.FilterTypes;
import com.epn.entities.Questions;
import com.epn.entities.Quiz;
import com.epn.entities.SearchObject;
import com.epn.mapper.QuizMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
public class QuizDAO extends GenericDAO<Quiz> {

    @Inject()
    QuestionDAO questionDAO;
    @Inject()
    ItemQuestionDAO itemQuestionDAO;

    private final QuizMapper quizMapper = Mappers.getMapper(QuizMapper.class);

    public QuizDAO() {
        super(Quiz.class);
    }

    public List<QuizContainer> getQuizbycode(Long codeQuiz) {
        SearchObject search = new SearchObject("codeQuiz");
        search.addParameter("codeQuiz", FilterTypes.EQUAL, codeQuiz);

        List<Quiz> resultList = search(search);
        List<QuizContainer> containers = quizMapper.sourceListToDestination(resultList);
        return containers;
    }

    public Quiz saveQuiz(QuizContainer quizcontainer) {
        Quiz quiz = new Quiz();
        if (quizcontainer.getCodeQuiz() != null) {
            quiz.setCodeQuiz(quizcontainer.getCodeQuiz());
        }
        quiz.setNameQuiz(quizcontainer.getNameQuiz());
        quiz.setDescription(quizcontainer.getDescription());
        quiz.setShortNameQuiz(quizcontainer.getShortNameQuiz());
        quiz.setStatusCat(quizcontainer.getStatusCat());
        quiz.setStatus(quizcontainer.getStatus());
        //  quiz.setUserCreate(quizcontainer.getUserCreate());
        //quiz.setUserLastModify(quizcontainer.getUserLastModify());
        update(quiz);
        em.flush();
        questionDAO.saveQuestion(quizcontainer, quiz);
        return quiz;
    }

    public String getSurveys(Integer from, Integer to) throws JsonProcessingException {

        SearchObject searchObject = new SearchObject("codeQuiz");
        // search.addParameter("codeQuiz", FilterTypes.EQUAL, codeQuiz); para filtrar u ordenar con like,order,equal

        long count = search(searchObject).size();
        searchObject.setFrom(from);
        searchObject.setTo(to);
        List<Quiz> resultList = search(searchObject);
        List<QuizContainerList> containers = quizMapper.sourceListToDestinationList(resultList);

        ListAndCountContainer surveysListAndCount = new ListAndCountContainer(count, containers);
        
        ObjectMapper mapper = new ObjectMapper();
        String response = mapper.writeValueAsString(surveysListAndCount);
        return response;
    }
}
