/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.dtos.QuestionContainer;
import com.epn.entities.FilterTypes;
import com.epn.entities.Questions;
import com.epn.entities.SearchObject;
import com.epn.mapper.QuestionMapper;
import java.util.List;
import javax.ejb.Stateless;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author david
 */
@Stateless
public class QuestionDAO extends GenericDAO<Questions> {

    private final QuestionMapper questionMapper = Mappers.getMapper(QuestionMapper.class);
    public QuestionDAO() {
        super(Questions.class);
    }

    public List<QuestionContainer> getQuestionbycodequiz(Long codeQuiz) {
        SearchObject search = new SearchObject("codeQuestions");
        search.addParameter("codeQuiz", FilterTypes.EQUAL, codeQuiz);

        List<Questions> resultList = search(search);
        List<QuestionContainer> containers = questionMapper.sourceListToDestination(resultList);
        return containers;
    }
}
