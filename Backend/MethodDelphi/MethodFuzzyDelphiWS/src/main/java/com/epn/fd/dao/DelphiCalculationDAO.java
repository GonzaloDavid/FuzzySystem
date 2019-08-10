/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.dtos.QuizValuesContainer;
import com.epn.dtos.Item;
import com.epn.dtos.ItemResponse;
import com.epn.dtos.QuizContainer;
import com.epn.entities.DelphiCalculations;
import com.epn.entities.DelphiCalculationsPK;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ka
 */
@Stateless
public class DelphiCalculationDAO extends GenericDAO<DelphiCalculations> {

    @Inject()
    QuizValuesDAO quizValuesDAO;
    @Inject()
    QuizDAO quizDAO;
    @Inject()
    ItemQuestionDAO itemQuestionDAO;
    @Inject()
    QuestionDAO questionDAO;

    public DelphiCalculationDAO() {
        super(DelphiCalculations.class);
    }

    public Item runFDM(Long codeQuiz, Long roundNumber, Long codeQuestions) {

        float threshold = quizDAO.getQuizbycode(codeQuiz).get(0).getDiffuseDelphiDiscriminator().floatValue();

        Long codeQuizItem = (long) 11;

        ArrayList<ItemResponse> itemResponsesList = new ArrayList();

        quizValuesDAO.getQuizValuesListBy(codeQuiz, codeQuestions, roundNumber, codeQuizItem).forEach(quizValues -> {
            Long codePerson = quizValues.getQuizvaluesPK().getCodePerson();
            Long codeQuestion = quizValues.getQuizvaluesPK().getCodeQuestions();
            Double minValue = Double.parseDouble(quizValues.getMinimumValue());
            Double aveValue = Double.parseDouble(quizValues.getAverageValue());
            Double maxValue = Double.parseDouble(quizValues.getMaximunValue());
            itemResponsesList.add(new ItemResponse(roundNumber, codeQuiz, codeQuestion, codePerson, codeQuizItem, minValue, aveValue, maxValue));
        });

        Item item = new Item(roundNumber, codeQuiz, codeQuestions, codeQuizItem, threshold, itemResponsesList);
        item.runFuzzyDelphiMethod();
        item.determinateConsensusByItemResponses();

        return item;

    }

}
