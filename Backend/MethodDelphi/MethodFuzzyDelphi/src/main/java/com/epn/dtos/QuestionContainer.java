/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;
import com.epn.entities.Quiz;
import java.util.List;

/**
 *
 * @author david
 */
public class QuestionContainer {

    private Long codeQuestions;
    private Long codeQuiz;
    private String question;
    private String description;
    private String statusCat;
    private String status;
    private Long userCreate;
    private Long userLastModify;
    private List<ItemQuestionContainer> questionItemList;

    public QuestionContainer() {
    }

    public QuestionContainer(Long codeQuestions, Long codeQuiz, String question, String description, String statusCat, String status, Long userCreate, Long userLastModify, List<ItemQuestionContainer> questionItemList) {
        this.codeQuestions = codeQuestions;
        this.codeQuiz = codeQuiz;
        this.question = question;
        this.description = description;
        this.statusCat = statusCat;
        this.status = status;
        this.userCreate = userCreate;
        this.userLastModify = userLastModify;
        this.questionItemList = questionItemList;
    }

    public Long getCodeQuestions() {
        return codeQuestions;
    }

    public void setCodeQuestions(Long codeQuestions) {
        this.codeQuestions = codeQuestions;
    }

    public Long getCodeQuiz() {
        return codeQuiz;
    }

    public void setCodeQuiz(Long codeQuiz) {
        this.codeQuiz = codeQuiz;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatusCat() {
        return statusCat;
    }

    public void setStatusCat(String statusCat) {
        this.statusCat = statusCat;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public List<ItemQuestionContainer> getQuestionItemList() {
        return questionItemList;
    }

    public void setQuestionItemList(List<ItemQuestionContainer> questionItemList) {
        this.questionItemList = questionItemList;
    }

}
