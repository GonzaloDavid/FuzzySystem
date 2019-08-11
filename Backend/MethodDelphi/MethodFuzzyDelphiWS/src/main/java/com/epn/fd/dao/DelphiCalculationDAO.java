/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.dtos.Item;
import com.epn.dtos.ItemResponse;
import com.epn.dtos.QuestionContainer;
import com.epn.entities.DelphiCalculations;
import com.epn.entities.DelphiCalculationsPK;
import com.epn.exception.AppException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
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

    public List<DelphiCalculations> saveDelphiCalculations(Long codeQuiz, Long roundNumber, Long codeQuestions) {

        List<DelphiCalculations> delphiCalculationsesList = new ArrayList();
        List<Item> listItemResults = runFuzzyDelphiByQuestion(codeQuiz, roundNumber, codeQuestions);

        listItemResults.forEach(item -> {
            DelphiCalculationsPK delphiCalculationsPK = new DelphiCalculationsPK();
            delphiCalculationsPK.setCodeQuiz(item.getCodeQuiz());
            delphiCalculationsPK.setCodeQuestions(item.getCodeQuestion());
            delphiCalculationsPK.setCodeQuizItem(item.getCodeItem());
            delphiCalculationsPK.setRoundNumber(item.getRoundNumber());
            BigDecimal lowerValue = new BigDecimal(item.getLowerValue());
            BigDecimal mediaValue = new BigDecimal(item.getMediaValue());
            BigDecimal upperValue = new BigDecimal(item.getUpperValue());
            BigDecimal defuzzificationValue = new BigDecimal(item.getDefuzzificationValue());
            BigDecimal threshold = new BigDecimal(item.getThreshold());
            BigDecimal lowerAverage = new BigDecimal(item.getLowerAverage());
            BigDecimal mediaAverage = new BigDecimal(item.getMediaAverage());
            BigDecimal upperAverage = new BigDecimal(item.getUpperAverage());
            Integer validated = item.getValidate();
            DelphiCalculations calculations = new DelphiCalculations(delphiCalculationsPK);
              /* lowerValue, mediaValue,
                    upperValue, defuzzificationValue,
                    threshold, lowerAverage,
                    mediaAverage, upperAverage,
                    validated*/
            calculations.setLowerValue(lowerValue);
            calculations.setMediaValue(mediaValue);
            calculations.setUpperAverage(upperAverage);
            calculations.setDefuzzificationValue(defuzzificationValue);
            calculations.setThreshold(threshold);
            calculations.setLowerAverage(lowerAverage);
            calculations.setMediaAverage(mediaAverage);
            calculations.setUpperAverage(upperAverage);
            calculations.setValidated(0);
            calculations.setStatusResultCat1("STATUSRESULTCAT");
            calculations.setStatusResult("approved");
            calculations.setUserCreate(BigInteger.ONE);
            calculations.setUserLastModify(BigInteger.ONE);
            calculations.setDateCreate(new Date());
            calculations.setDateLastModify(new Date());
            update(calculations);

            //  delphiCalculationsesList.add();
        }
        );

        //     updateList(delphiCalculationsesList);
        return delphiCalculationsesList;
    }

    public List<Item> runFuzzyDelphiByQuestion(Long codeQuiz, Long roundNumber, Long codeQuestions) {
        // QuestionItem sacar la lista de codigosQuizItems por codeQuestions y codeQuiz...

        List<Item> itemList = new ArrayList();

        List<QuestionContainer> questionContainer = questionDAO.getQuestionByCodeQuizAndCodeQuestions(codeQuiz, codeQuestions);

        questionContainer.forEach(question -> {
            float threshold = question.getDiffuseDelphiDiscriminatorbyQuestion().floatValue();

            question.getQuestionItemList().forEach(itemQuestion -> {
                Long codeQuizItem = itemQuestion.getQuestionItemPK().getCodeQuiz();
                Long codeQuestionsItem = itemQuestion.getQuestionItemPK().getCodeQuestions();
                Long codeItem = itemQuestion.getQuestionItemPK().getCodeQuizItem();

                Item item = this.runFuzzyDelphiByItem(roundNumber, codeQuizItem, codeQuestionsItem, codeItem, threshold);
                if (!item.getItemResponseList().isEmpty()) {
                    itemList.add(item);
                }
            });

        });

        return itemList;
    }

    public Item runFuzzyDelphiByItem(Long roundNumber, Long codeQuiz, Long codeQuestions, Long codeQuizItem, float threshold) {

        ArrayList<ItemResponse> itemResponsesList = getItemResponseListBy(roundNumber, codeQuiz, codeQuestions, codeQuizItem);

        for (ItemResponse itemResponse : itemResponsesList) {
            roundNumber = itemResponse.getRoundNumber();
            codeQuiz = itemResponse.getCodeQuiz();
            codeQuestions = itemResponse.getCodeQuestion();
            codeQuizItem = itemResponse.getCodeItem();
            break;
        }

        Item item = new Item(roundNumber, codeQuiz, codeQuestions, codeQuizItem, threshold, itemResponsesList);
        if (!itemResponsesList.isEmpty()) {
            item.runFuzzyDelphiMethod();
            item.determinateConsensusByItemResponses();
        }

        return item;
    }

    public ArrayList<ItemResponse> getItemResponseListBy(Long roundNumber, Long codeQuiz, Long codeQuestions, Long codeQuizItem) {
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

        return itemResponsesList;
    }

}
