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

//    public List<Item> runFuzzyDelphiByQuestion(Long codeQuiz, Long roundNumber, Long codeQuestions){
//        
//    }
//    
    public Item runFuzzyDelphiByItem(Long roundNumber, Long codeQuiz, Long codeQuestions, Long codeQuizItem, float threshold) {

        ArrayList<ItemResponse> itemResponsesList = new ArrayList();

        quizValuesDAO.getQuizValuesListBy(roundNumber, codeQuiz, codeQuestions, codeQuizItem).forEach(quizValues -> {
            Long roundNumberFound = quizValues.getQuizvaluesPK().getRoundNumber();
            Long codeQuizFound = quizValues.getQuizvaluesPK().getCodeQuiz();
            Long codeQuestionsFound = quizValues.getQuizvaluesPK().getCodeQuestions();
            Long codePersonFound = quizValues.getQuizvaluesPK().getCodePerson();
            Long codeQuizItemFound = quizValues.getQuizvaluesPK().getCodeQuizItem();
            Double minValue = Double.parseDouble(quizValues.getMinimumValue());
            Double aveValue = Double.parseDouble(quizValues.getAverageValue());
            Double maxValue = Double.parseDouble(quizValues.getMaximunValue());
            itemResponsesList.add(new ItemResponse(roundNumberFound, codeQuizFound, codeQuestionsFound, codePersonFound, codeQuizItemFound, minValue, aveValue, maxValue));
        });

        Item item = new Item(roundNumber, codeQuiz, codeQuestions, codeQuizItem, threshold, itemResponsesList);
        item.runFuzzyDelphiMethod();
        item.determinateConsensusByItemResponses();

        return item;
    }

}
