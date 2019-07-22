/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.dtos.QuizContainer;
import com.epn.dtos.QuizSave;
import com.epn.entities.Quizvalues;
import com.epn.entities.QuizvaluesPK;
import com.epn.exception.AppException;
import javax.ejb.Stateless;

/**
 *
 * @author david
 */
@Stateless
public class QuizValuesDAO extends GenericDAO<Quizvalues> {

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
                try {
                    em.persist(quizvalues);
                } catch (Exception e) {
                    throw new AppException(e.toString(), "ENCUESTA YA INGRESADA");
                }
            });
        });

    }

}
