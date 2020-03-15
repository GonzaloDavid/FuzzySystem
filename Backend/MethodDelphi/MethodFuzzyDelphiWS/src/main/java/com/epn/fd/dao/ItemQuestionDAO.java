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
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author david
 */
@Stateless
public class ItemQuestionDAO extends GenericDAO<QuestionItem> {

    @Inject()
    FileService fileService;
    @Inject()
    EnvironmentDAO environmentDAO;
    private final ItemQuestionMapper questionMapper = Mappers.getMapper(ItemQuestionMapper.class);

    public ItemQuestionDAO() {
        super(QuestionItem.class);
    }

    public ItemQuestionContainer getItembycodeItem(Long codeQuiz, Long codeQuestion, Long codeQuizItem) {
        ItemQuestionContainer container = new ItemQuestionContainer();
        SearchObject search = new SearchObject("questionItemPK");
        search.addParameter("questionItemPK.codeQuiz", FilterTypes.EQUAL, codeQuiz);
        search.addParameter("questionItemPK.codeQuestions", FilterTypes.EQUAL, codeQuestion);
        search.addParameter("questionItemPK.codeQuizItem", FilterTypes.EQUAL, codeQuizItem);

        List<QuestionItem> resultList = search(search);
        if (resultList.size() > 0) {
            container = questionMapper.sourceToDestination(resultList.get(0));
        }
        return container;
    }

    public List<ItemQuestionContainer> getItembycodeQuestion(Long codeQuestion) {
        SearchObject search = new SearchObject("questionItemPK");
        search.addParameter("questionItemPK.codeQuestions", FilterTypes.EQUAL, codeQuestion);

        List<QuestionItem> resultList = search(search);
        List<ItemQuestionContainer> containers = questionMapper.sourceListToDestination(resultList);
        return containers;
    }

    public List<ItemQuestionContainer> getItembyCodeQuizAndCodeQuestion(Long codeQuiz, Long codeQuestion) {
        SearchObject search = new SearchObject("questionItemPK");
        search.addParameter("questionItemPK.codeQuiz", FilterTypes.EQUAL, codeQuiz);
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
             String pathImage = environmentDAO.getenvironmentbyuseplace(
                "pathImageItem", "backend").get(0).getUri();
        questionItemList.forEach(item -> {
            String image = item.getImage();
            QuestionItemPK questionItemPK = new QuestionItemPK();
            questionItemPK.setCodeQuizItem(item.getQuestionItemPK().getCodeQuizItem());
            questionItemPK.setCodeQuestions(questions.getQuestionsPK().getCodeQuestions());
            questionItemPK.setCodeQuiz(questions.getQuestionsPK().getCodeQuiz());
            item.setQuestionItemPK(questionItemPK);
            item.setImage(null);
            update(item);
            flush();
            try {
                if (image != null) {
                    String path = fileService.saveFileB64(item.getQuestionItemPK().getCodeQuizItem(), image,pathImage);
                    item.setImageUrl(path);
                    update(item);
                }
            } catch (IOException ex) {
                Logger.getLogger(ItemQuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
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
                        throw new AppException(e.toString(),e.toString(), "mysql_forenkey","PROBLEMA DE DEPENDENCIAS");
                    }
                }
            }
        });
    }

    public String getImage(Long codeQuiz, Long codeQuestion, Long codeQuizItem) {
        ItemQuestionContainer itemquiz = getItembycodeItem(codeQuiz, codeQuestion, codeQuizItem);
        File file = new File(itemquiz.getImageUrl());
        String encodeImage;
        try {
            encodeImage = Base64.getEncoder().withoutPadding().encodeToString(Files.readAllBytes(file.toPath()));
        } catch (IOException e) {
            throw new AppException(e.toString(),e.toString(), "mysql_forenkey","PROBLEMA DE DEPENDENCIAS");
        }
        return encodeImage;
    }

}
