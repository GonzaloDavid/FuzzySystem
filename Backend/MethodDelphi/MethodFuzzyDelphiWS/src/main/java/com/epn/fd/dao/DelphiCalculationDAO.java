/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.dtos.DelphiCalculationsContainer;
import com.epn.dtos.Item;
import com.epn.dtos.ItemResponse;
import com.epn.dtos.ListAndCountContainer;
import com.epn.dtos.PersonContainer;
import com.epn.dtos.QuestionContainer;
import com.epn.entities.DelphiCalculations;
import com.epn.entities.DelphiCalculationsPK;
import com.epn.entities.FilterTypes;
import com.epn.entities.Person;
import com.epn.entities.Quizvalues;
import com.epn.entities.QuizvaluesPK;
import com.epn.entities.SearchObject;
import com.epn.mapper.DelphiCalculationsMapper;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.mapstruct.factory.Mappers;

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
    private final DelphiCalculationsMapper calculationsMapper = Mappers.getMapper(DelphiCalculationsMapper.class);

    public DelphiCalculationDAO() {
        super(DelphiCalculations.class);
    }

    public List<DelphiCalculations> saveDelphiCalculations(Long codeQuiz, Long roundNumber, Long codeQuestions) {

        List<DelphiCalculations> delphiCalculationsList = new ArrayList();
        List<Item> listItemResults = runFuzzyDelphiByQuestion(codeQuiz, roundNumber, codeQuestions);

        listItemResults.forEach(item -> {
            DelphiCalculationsPK delphiCalculationsPK = new DelphiCalculationsPK(item.getCodeQuiz(),
                    item.getCodeQuestion(), item.getCodeItem(), item.getRoundNumber());
            BigDecimal lowerValue = new BigDecimal(item.getLowerValue());
            BigDecimal mediaValue = new BigDecimal(item.getMediaValue());
            BigDecimal upperValue = new BigDecimal(item.getUpperValue());
            BigDecimal defuzzificationValue = new BigDecimal(item.getDefuzzificationValue());
            BigDecimal threshold = new BigDecimal(item.getThreshold());
            BigDecimal lowerAverage = new BigDecimal(item.getLowerAverage());
            BigDecimal mediaAverage = new BigDecimal(item.getMediaAverage());
            BigDecimal upperAverage = new BigDecimal(item.getUpperAverage());
            Integer validated = item.getValidate();

            DelphiCalculations calculations = new DelphiCalculations(delphiCalculationsPK, lowerValue, mediaValue,
                    upperValue, defuzzificationValue, threshold, lowerAverage, mediaAverage, upperAverage, validated);

            calculations.setStatusResultCat1("STATUSRESULTCAT");
            if (validated == 1) {
                calculations.setStatusResult("approved");
            } else {
                calculations.setStatusResult("rejected");
            }
            calculations.setUserCreate(BigInteger.ONE);
            calculations.setUserLastModify(BigInteger.ONE);
            delphiCalculationsList.add(calculations);

            // Save concensus each item
            quizValuesDAO.saveQuizValuesResultConsensus(item);
        });
        updateList(delphiCalculationsList);
        return delphiCalculationsList;
    }

    public List<Item> runFuzzyDelphiByQuestion(Long codeQuiz, Long roundNumber, Long codeQuestions) {
        // QuestionItem sacar la lista de codigosQuizItems por codeQuestions y
        // codeQuiz...

        List<Item> itemList = new ArrayList();

        List<QuestionContainer> questionContainer = questionDAO.getQuestionByCodeQuizAndCodeQuestions(codeQuiz,
                codeQuestions);

        questionContainer.forEach(question -> {
            float threshold = question.getDiffuseDelphiDiscriminatorbyQuestion().floatValue();

            question.getQuestionItemList().forEach(itemQuestion -> {
                Long codeQuizItem = itemQuestion.getQuestionItemPK().getCodeQuiz();
                Long codeQuestionsItem = itemQuestion.getQuestionItemPK().getCodeQuestions();
                Long codeItem = itemQuestion.getQuestionItemPK().getCodeQuizItem();

                Item item = this.runFuzzyDelphiByItem(roundNumber, codeQuizItem, codeQuestionsItem, codeItem,
                        threshold);
                if (!item.getItemResponseList().isEmpty()) {
                    itemList.add(item);
                }
            });

        });

        return itemList;
    }

    public Item runFuzzyDelphiByItem(Long roundNumber, Long codeQuiz, Long codeQuestions, Long codeQuizItem,
            float threshold) {

        ArrayList<ItemResponse> itemResponsesList = getItemResponseListBy(roundNumber, codeQuiz, codeQuestions,
                codeQuizItem);

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

    public ArrayList<ItemResponse> getItemResponseListBy(Long roundNumber, Long codeQuiz, Long codeQuestions,
            Long codeQuizItem) {
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
            itemResponsesList.add(new ItemResponse(roundNumberFound, codeQuizFound, codeQuestionsFound, codePersonFound,
                    codeQuizItemFound, minValue, aveValue, maxValue));
        });

        return itemResponsesList;
    }

    public List<DelphiCalculationsContainer> getdelphicalculationbycodequiz(Long codequiz, Long roundNumber) {
        SearchObject search = new SearchObject("delphiCalculationsPK");
        search.addParameter("delphiCalculationsPK.codeQuiz", FilterTypes.EQUAL, codequiz);
        search.addParameter("delphiCalculationsPK.roundNumber", FilterTypes.EQUAL, roundNumber);
        search.asc();
        List<DelphiCalculations> resultList = search(search);
        List<DelphiCalculationsContainer> containers = calculationsMapper.sourceListToDestination(resultList);
        return containers;
    }

    public List<DelphiCalculationsContainer> getDelphiCalculations(Long codeQuiz, Long codeQuestions, Long codeQuizItem,
            Long roundNumber) {
        SearchObject search = new SearchObject("delphiCalculationsPK");
        search.addParameter("delphiCalculationsPK.roundNumber", FilterTypes.EQUAL, roundNumber);
        search.addParameter("delphiCalculationsPK.codeQuiz", FilterTypes.EQUAL, codeQuiz);
        search.addParameter("delphiCalculationsPK.codeQuestions", FilterTypes.EQUAL, codeQuestions);
        search.addParameter("delphiCalculationsPK.codeQuizItem", FilterTypes.EQUAL, codeQuizItem);

        List<DelphiCalculations> resultList = search(search);
        List<DelphiCalculationsContainer> containers = calculationsMapper.sourceListToDestination(resultList);
        return containers;
    }

}
