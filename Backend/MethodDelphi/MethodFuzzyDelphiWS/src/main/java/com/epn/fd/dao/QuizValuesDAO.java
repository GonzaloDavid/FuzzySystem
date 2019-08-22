/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.dtos.Item;
import com.epn.dtos.ItemResponse;
import com.epn.dtos.QuizContainer;
import com.epn.dtos.QuizValuesContainer;
import com.epn.entities.FilterTypes;
import com.epn.entities.Quizvalues;
import com.epn.entities.QuizvaluesPK;
import com.epn.entities.SearchObject;
import com.epn.exception.AppException;
import com.epn.mapper.QuizvaluesMapper;
import java.util.ArrayList;
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

    public void saveQuizValuesResultConsensus(Item itemResult) {

        List<ItemResponse> itemListResponses = itemResult.getItemResponseList();
        List<Quizvalues> quizValuesList = new ArrayList<>();

        itemListResponses.forEach(item -> {
            QuizvaluesPK quizvaluesPK = new QuizvaluesPK(
                    item.getRoundNumber(), item.getCodePerson(),
                    item.getCodeQuiz(), item.getCodeQuestion(), item.getCodeItem()
            );

            Quizvalues quizvalues = new Quizvalues(
                    quizvaluesPK,
                    item.getMinValue().toString(),
                    item.getAveValue().toString(),
                    item.getMaxValue().toString(),
                    item.getRangeG(),
                    item.getStatusRangeG(),
                    item.getRangeC(),
                    item.getDistanceGtoC(),
                    item.getValidate(),
                    0,
                    0
            );
            quizValuesList.add(quizvalues);
        });
        updateList(quizValuesList);
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

    public List<QuizValuesContainer> getQuizValuesListBy(Long roundNumber, Long codeQuiz, Long codeQuestions, Long codeQuizItem) {
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
