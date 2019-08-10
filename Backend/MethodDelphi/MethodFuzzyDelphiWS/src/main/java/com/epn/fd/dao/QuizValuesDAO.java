/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.dtos.QuizContainer;
import com.epn.dtos.QuizValuesContainer;
import com.epn.entities.FilterTypes;
import com.epn.entities.Quizvalues;
import com.epn.entities.QuizvaluesPK;
import com.epn.entities.SearchObject;
import com.epn.exception.AppException;
import com.epn.mapper.QuizvaluesMapper;
import java.util.List;
import javax.ejb.Stateless;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author david
 */
@Stateless
public class QuizValuesDAO extends GenericDAO<Quizvalues> {

    private final QuizvaluesMapper quizvaluesMapper = Mappers.getMapper(QuizvaluesMapper.class);

    public QuizValuesDAO() {
        super(Quizvalues.class);
    }

    public void savequizvalues(QuizContainer quiz, Long codePerson, Long roundnumber) {

        quiz.getQuestionsList().forEach(question -> {
            question.getQuestionItemList().forEach(item -> {
                QuizvaluesPK quizvaluesPK = new QuizvaluesPK();
                quizvaluesPK.setRoundNumber(roundnumber);
                quizvaluesPK.setCodeQuiz(item.getQuestionItemPK().getCodeQuiz());
                quizvaluesPK.setCodeQuestions(item.getQuestionItemPK().getCodeQuestions());
                quizvaluesPK.setCodeQuizItem(item.getQuestionItemPK().getCodeQuizItem());
                quizvaluesPK.setCodePerson(codePerson);
                Quizvalues quizvalues = new Quizvalues(quizvaluesPK);
                quizvalues.setMinimumValue(item.getMinimumValue());
                quizvalues.setAverageValue(item.getAverageValue());
                quizvalues.setMaximunValue(item.getMaximunValue());
                quizvalues.setQuizObservation(quiz.getQuizObservation());
                quizvalues.setQuestionObservation(question.getQuestionObservation());

                if (quiz.isUpdatevalues() == true) {
                    update(quizvalues);
                } else {
                    try {
                        em.persist(quizvalues);
                    } catch (Exception e) {
                        throw new AppException(e.toString(), "ENCUESTA YA INGRESADA");
                    }
                }
            });
        });

    }

    public List<QuizValuesContainer> getquizvalues(Long codeQuiz, Long codeQuestions, Long codeQuizItem, Long codePerson,
            Long roundNumber) {
        SearchObject search = new SearchObject("quizvaluesPK");
        search.addParameter("quizvaluesPK.roundNumber", FilterTypes.EQUAL, roundNumber);
        search.addParameter("quizvaluesPK.codePerson", FilterTypes.EQUAL, codePerson);
        search.addParameter("quizvaluesPK.codeQuiz", FilterTypes.EQUAL, codeQuiz);
        search.addParameter("quizvaluesPK.codeQuestions", FilterTypes.EQUAL, codeQuestions);
        search.addParameter("quizvaluesPK.codeQuizItem", FilterTypes.EQUAL, codeQuizItem);

        List<Quizvalues> resultList = search(search);
        List<QuizValuesContainer> containers = quizvaluesMapper.sourceListToDestination(resultList);
        return containers;
    }

    public List<QuizValuesContainer> getQuizValuesListBy(Long codeQuiz, Long codeQuestions, Long roundNumber, Long codeQuizItem) {
        SearchObject search = new SearchObject("quizvaluesPK");
        search.addParameter("quizvaluesPK.roundNumber", FilterTypes.EQUAL, roundNumber);
        search.addParameter("quizvaluesPK.codeQuiz", FilterTypes.EQUAL, codeQuiz);
        search.addParameter("quizvaluesPK.codeQuestions", FilterTypes.EQUAL, codeQuestions);
        search.addParameter("quizvaluesPK.codeQuizItem", FilterTypes.EQUAL, codeQuizItem);

        List<Quizvalues> resultList = search(search);
        List<QuizValuesContainer> containers = quizvaluesMapper.sourceListToDestination(resultList);
        return containers;
    }
}
