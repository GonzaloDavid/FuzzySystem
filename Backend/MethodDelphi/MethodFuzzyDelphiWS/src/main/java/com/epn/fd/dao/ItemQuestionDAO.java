/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.dtos.ItemQuestionContainer;
import com.epn.entities.FilterTypes;
import com.epn.entities.QuestionItem;
import com.epn.entities.SearchObject;
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
        search.addParameter("codeQuestions", FilterTypes.EQUAL, codeQuestion);

        List<QuestionItem> resultList = search(search);
        List<ItemQuestionContainer> containers = questionMapper.sourceListToDestination(resultList);
        return containers;
    }

}
