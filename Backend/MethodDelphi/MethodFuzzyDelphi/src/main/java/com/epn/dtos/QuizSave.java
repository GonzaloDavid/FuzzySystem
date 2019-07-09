/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

import com.epn.entities.QuestionItem;
import com.epn.entities.Questions;
import java.util.List;

/**
 *
 * @author david
 */
public class QuizSave {

    private Long codeQuiz;
    private String nameQuiz;
    private String shortNameQuiz;
    private String description;
    private String status;
    private String statusCat;
    private List<QuestionContainer> questionsList;
    private List<Questions> questiondeleted;
    private List<QuestionItem> questionItemdeleted;
    private Long userCreate;
    private Long userLastModify;

    public QuizSave() {
    }

    public QuizSave(Long codeQuiz, String nameQuiz, String shortNameQuiz, String description, String status, String statusCat, List<QuestionContainer> questionsList, List<Questions> questiondeleted, List<QuestionItem> questionItemdeleted, Long userCreate, Long userLastModify) {
        this.codeQuiz = codeQuiz;
        this.nameQuiz = nameQuiz;
        this.shortNameQuiz = shortNameQuiz;
        this.description = description;
        this.status = status;
        this.statusCat = statusCat;
        this.questionsList = questionsList;
        this.questiondeleted = questiondeleted;
        this.questionItemdeleted = questionItemdeleted;
        this.userCreate = userCreate;
        this.userLastModify = userLastModify;
    }

    public Long getCodeQuiz() {
        return codeQuiz;
    }

    public void setCodeQuiz(Long codeQuiz) {
        this.codeQuiz = codeQuiz;
    }

    public String getNameQuiz() {
        return nameQuiz;
    }

    public void setNameQuiz(String nameQuiz) {
        this.nameQuiz = nameQuiz;
    }

    public String getShortNameQuiz() {
        return shortNameQuiz;
    }

    public void setShortNameQuiz(String shortNameQuiz) {
        this.shortNameQuiz = shortNameQuiz;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusCat() {
        return statusCat;
    }

    public void setStatusCat(String statusCat) {
        this.statusCat = statusCat;
    }

    public List<QuestionContainer> getQuestionsList() {
        return questionsList;
    }

    public void setQuestionsList(List<QuestionContainer> questionsList) {
        this.questionsList = questionsList;
    }

    public List<Questions> getQuestiondeleted() {
        return questiondeleted;
    }

    public void setQuestiondeleted(List<Questions> questiondeleted) {
        this.questiondeleted = questiondeleted;
    }

    public List<QuestionItem> getQuestionItemdeleted() {
        return questionItemdeleted;
    }

    public void setQuestionItemdeleted(List<QuestionItem> questionItemdeleted) {
        this.questionItemdeleted = questionItemdeleted;
    }

    public Long getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(Long userCreate) {
        this.userCreate = userCreate;
    }

    public Long getUserLastModify() {
        return userLastModify;
    }

    public void setUserLastModify(Long userLastModify) {
        this.userLastModify = userLastModify;
    }
}
