/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.dtos.QuizValuesContainer;
import com.epn.dtos.Item;
import com.epn.dtos.QuizContainer;
import com.epn.dtos.Survey;
import com.epn.entities.DelphiCalculations;
import com.epn.entities.SearchObject;
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

    public DelphiCalculationDAO() {
        super(DelphiCalculations.class);
    }

    private List<Item> getItemsByQuizAndRound(Long codeQuiz, Long roundNumber) {

        List<Item> listItems = new ArrayList();

        List<QuizValuesContainer> quizvaluebyquiz = quizValuesDAO.getquizvalues(codeQuiz, null, null, null, roundNumber);

        quizvaluebyquiz.forEach(itemValues -> {
            Integer idExpert = (int) itemValues.getQuizvaluesPK().getCodePerson();
            Integer idItem = (int) itemValues.getQuizvaluesPK().getCodeQuizItem();
            Double lowerValue = Double.parseDouble(itemValues.getMinimumValue());
            Double middleValue = Double.parseDouble(itemValues.getAverageValue());
            Double upperValue = Double.parseDouble(itemValues.getMaximunValue());

            listItems.add(new Item(idExpert, idItem, lowerValue, middleValue, upperValue));
        });

        return listItems;
    }

    public Survey getSurveyByFuzzyDelphiMethod(Long codeQuiz, Long roundNumber) {

        int determinante = 0;

        List<QuizContainer> quizList = quizDAO.getQuizbycode(codeQuiz);

        for (QuizContainer quiz : quizList) {
            if (quiz.getQuizPK().getCodeQuiz() == codeQuiz) {
                determinante = quiz.getDiffuseDelphiDiscriminator().intValue();
                break;
            }
        }

        ArrayList<Integer> idItemsList = new ArrayList();

        itemQuestionDAO.getItemByCodeQuiz(codeQuiz).forEach(item -> {
            idItemsList.add((int) item.getQuestionItemPK().getCodeQuizItem());
        });

        ArrayList<Item> listItems = (ArrayList<Item>) getItemsByQuizAndRound(codeQuiz, roundNumber);
        Survey survey = new Survey(listItems, determinante);

        survey.calculateTriangularFuzzyNumbers(idItemsList);
        survey.setValoresMenorMedioItems();
        survey.calculateConsensusItems();

        return survey;
    }

}
