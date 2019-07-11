/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.dtos.EmailContainer;
import com.epn.dtos.ListAndCountContainer;

import com.epn.dtos.QuizContainer;
import com.epn.dtos.QuizContainerList;
import com.epn.dtos.QuizSave;
import com.epn.entities.FilterTypes;
import com.epn.entities.Quiz;
import com.epn.entities.SearchObject;
import com.epn.exception.AppException;
import com.epn.mapper.QuizMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    @Inject
    Mail mail;

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

    public Quiz saveQuiz(QuizSave quizcontainer) {
        Quiz quiz = new Quiz();
        if (quizcontainer.getCodeQuiz() != null) {
            quiz.setCodeQuiz(quizcontainer.getCodeQuiz());
        } else {
            quiz.setCodeQuiz(new Long(0));
        }
        quiz.setNameQuiz(quizcontainer.getNameQuiz());
        quiz.setDescription(quizcontainer.getDescription());
        quiz.setShortNameQuiz(quizcontainer.getShortNameQuiz());
        quiz.setStatusCat(quizcontainer.getStatusCat());
        quiz.setStatus(quizcontainer.getStatus());
        //quiz.setUserCreate(quizcontainer.getUserCreate());
        //quiz.setUserLastModify(quizcontainer.getUserLastModify());
        //update(quiz);
        update(quiz);
        //flush();
        questionDAO.deleteQuestion(quizcontainer);
        itemQuestionDAO.deleteItem(quizcontainer);
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

    public void deletequiz(Quiz quiz) {

        Quiz foundelement = new Quiz();
        foundelement = find(quiz.getCodeQuiz());
        try {
            if (foundelement != null) {
                remove(foundelement);
            }
        } catch (Exception e) {
            throw new AppException(e.toString(), "NO SE ELIMINO CORRECTAMENTE");
        }

    }

    public void sendquiz(EmailContainer emailcontainer) {
        List<QuizContainer> quiz = getQuizbycode(emailcontainer.getQuiz().getCodeQuiz());
        emailcontainer.getPersons().forEach(person -> {
            try {
                String msg = "Saludos Estimad@ " + person.getName() + " ha sido seleccionado para participar en una encuesta acerca de " + quiz.get(0).getDescription();
                String footer = "\nPor favor de click en el siguiente enlace para continuar ...";
                String body = msg + "\n" + footer;
                mail.sendEmail(person.getEmail(), quiz.get(0).getNameQuiz(), body);
            } catch (Exception e) {
                throw new AppException(e.toString(), "NO SE ENVIO EMAIL");
            }

        });

    }
}
