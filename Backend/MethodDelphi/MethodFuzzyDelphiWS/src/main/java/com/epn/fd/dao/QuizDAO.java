/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.dtos.ItemQuestionContainer;
import com.epn.dtos.QuestionContainer;
import com.epn.dtos.QuizContainer;
import com.epn.entities.FilterTypes;
import com.epn.entities.Quiz;
import com.epn.entities.SearchObject;
import com.epn.mapper.QuizMapper;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author david
 */
@Stateless
public class QuizDAO extends GenericDAO<Quiz> {

    @Inject()
    QuestionDAO questionDAO;
    @Inject()
    ItemQuestionDAO itemQuestionDAO;

    private final QuizMapper quizMapper = Mappers.getMapper(QuizMapper.class);

    public QuizDAO() {
        super(Quiz.class);
    }

    public List<QuizContainer> getQuizbycode(Long codeQuiz) {
        SearchObject search = new SearchObject("codeQuiz");
        search.addParameter("codeQuiz", FilterTypes.EQUAL, codeQuiz);

        List<Quiz> resultList = search(search);
        List<QuizContainer> containers = quizMapper.sourceListToDestination(resultList);
        List<QuestionContainer> questioncontainer = questionDAO.getQuestionbycodequiz(codeQuiz);
        containers.get(0).setQuestionlist(questioncontainer);
        List<ItemQuestionContainer> itemQuestionContainersaux = new ArrayList();
        questioncontainer.forEach(item -> {
            List<ItemQuestionContainer> itemQuestionContainers = itemQuestionDAO.getItembycodeQuestion(item.getCodeQuestions());
            itemQuestionContainers.forEach(itemaux->{
                
                itemQuestionContainersaux.add(itemaux);
            });
        });
        containers.get(0).setQuestionItemList(itemQuestionContainersaux);
        return containers;
    }
    public void saveQuiz(QuizContainer quizcontainer)
    {
       // update(instance);
    }
}
