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
        SearchObject search = new SearchObject("codeQuizItem");
        search.addParameter("codeQuestions.codeQuestions", FilterTypes.EQUAL, codeQuestion);

        List<QuestionItem> resultList = search(search);
        List<ItemQuestionContainer> containers = questionMapper.sourceListToDestination(resultList);
        return containers;
    }

    public void saveItem(Questions questions, List<ItemQuestionContainer> questionItemList) {
        questionItemList.forEach(item -> {
                QuestionItem questionItem = new QuestionItem();
                if (item.getQuestionItemPK().getCodeQuizItem() != 0) {
                    questionItem.getQuestionItemPK().setCodeQuizItem(item.getQuestionItemPK().getCodeQuizItem());
                }
                questionItem.setQuestions(questions);
                questionItem.setItemLabel(item.getItemLabel());
                update(questionItem);
        });
    }

    public void deleteItem(QuizSave quizContainer) {
        quizContainer.getQuestionItemdeleted().forEach(elementremove -> {
            QuestionItem foundelement = new QuestionItem();
            try {
                if (elementremove.getQuestionItemPK().getCodeQuizItem()!= 0) {
                    foundelement = find(elementremove.getQuestionItemPK().getCodeQuizItem());
                    if (foundelement != null) {
                        remove(foundelement);
                    }
                }
            } catch (Exception e) {
                throw new AppException(e.toString(), "NO PUDO ELIMINAR LOS ITEMS");
            }
        });
    }

}
