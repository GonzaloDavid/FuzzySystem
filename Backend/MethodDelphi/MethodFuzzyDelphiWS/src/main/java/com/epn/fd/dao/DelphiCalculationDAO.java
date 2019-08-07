/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.dtos.QuizValuesContainer;
import com.epn.dtos.Item;
import com.epn.entities.DelphiCalculations;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
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

    public DelphiCalculationDAO() {
        super(DelphiCalculations.class);
    }

    public List<Item> getItemsByQuizAndRound(Long codeQuiz, Long roundNumber) {

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

}
