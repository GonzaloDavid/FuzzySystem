/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.dtos.ItemCommentContainer;
import com.epn.dtos.QuizContainer;
import com.epn.entities.FilterTypes;
import com.epn.entities.ItemComment;
import com.epn.entities.Quiz;
import com.epn.entities.SearchObject;
import com.epn.mapper.ItemCommentMapper;
import java.util.List;
import javax.ejb.Stateless;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author david
 */
@Stateless
public class ItemCommentDAO extends GenericDAO<ItemComment> {

    private final ItemCommentMapper commentMapper = Mappers.getMapper(ItemCommentMapper.class);

    public ItemCommentDAO() {
        super(ItemComment.class);
    }

    public List<ItemCommentContainer> getcommentbyquiz(Long codeQuiz, Long codeQuestion, Long codeItem, Long codePerson) {
        SearchObject search = new SearchObject("itemCommentPK");
        search.addParameter("itemCommentPK.codeQuizItem", FilterTypes.EQUAL, codeItem);
        search.addParameter("itemCommentPK.codeQuestions", FilterTypes.EQUAL, codeQuestion);
        search.addParameter("itemCommentPK.codeQuiz", FilterTypes.EQUAL, codeQuiz);
        search.addParameter("itemCommentPK.codePerson", FilterTypes.EQUAL, codePerson);

        List<ItemComment> resultList = search(search);
        List<ItemCommentContainer> containers = commentMapper.sourceListToDestination(resultList);
        return containers;
    }
    public void saveItemComment(ItemComment itemComment) {
        update(itemComment);
    }
}
