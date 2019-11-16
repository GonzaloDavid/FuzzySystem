/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.dtos.ItemCommentContainer;
import com.epn.entities.FilterTypes;
import com.epn.entities.ItemComment;
import com.epn.entities.SearchObject;
import com.epn.mapper.ItemCommentMapper;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
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

    public List<ItemCommentContainer> getcommentbyquiz(Long codeQuiz, Long codeQuestion, Long codeItem, Long roundNumber, Long codePerson) {
        SearchObject search = new SearchObject("itemCommentPK");
        search.addParameter("itemCommentPK.codeQuizItem", FilterTypes.EQUAL, codeItem);
        search.addParameter("itemCommentPK.codeQuestions", FilterTypes.EQUAL, codeQuestion);
        search.addParameter("itemCommentPK.codeQuiz", FilterTypes.EQUAL, codeQuiz);
        search.addParameter("itemCommentPK.roundNumber", FilterTypes.EQUAL, roundNumber);
        search.addParameter("itemCommentPK.codePerson", FilterTypes.EQUAL, codePerson);

        List<ItemComment> resultList = search(search);
        List<ItemCommentContainer> containers = commentMapper.sourceListToDestination(resultList);
        return containers;
    }

    public long getnumberofcoment(Long codeQuiz, Long codeQuestion, Long codeItem, Long roundNumber, Long codePerson) {
        long numberofcomentbyperson = 0;

        String sqlnumberComment = "SELECT COUNT(i) from ItemComment i "
                + "where i.itemCommentPK.codeQuiz=" + codeQuiz
                + " AND i.itemCommentPK.codeQuestions=" + codeQuestion
                + " AND i.itemCommentPK.codeQuizItem=" + codeItem;
        if (roundNumber != null) {
            sqlnumberComment += " AND  i.itemCommentPK.roundNumber=" + roundNumber;
        }
        if (codePerson != null) {
            sqlnumberComment += " AND i.itemCommentPK.codePerson=" + codePerson;
        }

        Query queryAvailable = this.em.createQuery(sqlnumberComment);
        List<Long> resultavailable = queryAvailable.getResultList();
        numberofcomentbyperson = resultavailable.get(0);

        return numberofcomentbyperson;
    }

    public void saveItemComment(ItemComment itemComment) {
        update(itemComment);
    }
}
