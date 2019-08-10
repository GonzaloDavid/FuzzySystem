/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.dtos.ItemQuestionContainer;
import com.epn.dtos.QuizSave;
import com.epn.entities.FilterTypes;
import com.epn.entities.QuestionItem;
import com.epn.entities.QuestionItemPK;
import com.epn.entities.Questions;
import com.epn.entities.SearchObject;
import com.epn.exception.AppException;
import com.epn.mapper.ItemQuestionMapper;
import java.util.List;
import javax.ejb.Stateless;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author david
 */
@Stateless
public class ItemQuestionDAO extends GenericDAO<QuestionItem> {

    private final ItemQuestionMapper questionMapper = Mappers.getMapper(ItemQuestionMapper.class);

    public ItemQuestionDAO() {
        super(QuestionItem.class);
    }

    public List<ItemQuestionContainer> getItembycodeQuestion(Long codeQuestion) {
        SearchObject search = new SearchObject("questionItemPK");
        search.addParameter("questionItemPK.codeQuestions", FilterTypes.EQUAL, codeQuestion);

        List<QuestionItem> resultList = search(search);
        List<ItemQuestionContainer> containers = questionMapper.sourceListToDestination(resultList);
        return containers;
    }
    
    public List<ItemQuestionContainer> getItemByCodeQuiz(Long codeQuiz) {
        SearchObject search = new SearchObject("questionItemPK");
        search.addParameter("questionItemPK.codeQuiz", FilterTypes.EQUAL, codeQuiz);

        List<QuestionItem> resultList = search(search);
        List<ItemQuestionContainer> containers = questionMapper.sourceListToDestination(resultList);
        return containers;
    }

    public List<QuestionItem> saveItem(Questions questions, List<QuestionItem> questionItemList) {
        questionItemList.forEach(item -> {
            QuestionItemPK questionItemPK = new QuestionItemPK();
            questionItemPK.setCodeQuizItem(item.getQuestionItemPK().getCodeQuizItem());
            questionItemPK.setCodeQuestions(questions.getQuestionsPK().getCodeQuestions());
            questionItemPK.setCodeQuiz(questions.getQuestionsPK().getCodeQuiz());
            item.setQuestionItemPK(questionItemPK);
        });
        try {
            updateList(questionItemList);
        } catch (Exception ex) {
            throw new AppException(ex.toString(), "NO SE GUARDO ITEMS");
        }
        return questionItemList;
    }

    public void deleteItem(QuizSave quizContainer) {
        quizContainer.getQuestionItemdeleted().forEach(elementremove -> {
            if (elementremove.getQuestionItemPK().getCodeQuizItem() != 0) {
                QuestionItem foundelement = find(elementremove.getQuestionItemPK());
                if (foundelement != null) {
                    try {
                        remove(foundelement);
                    } catch (Exception e) {
                        throw new AppException(e.toString(), "NO PUDO ELIMINAR LOS ITEMS");
                    }
                }
            }
        });
    }

}
