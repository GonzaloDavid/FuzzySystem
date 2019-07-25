/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

import com.epn.entities.QuizPK;

/**
 *
 * @author ka
 */
public class QuizContainerList {

       private QuizPK quizPK;
    private String nameQuiz;
    private String shortNameQuiz;
    private String description;
    private String status;
    private String statusCat;
    private Long userCreate;
    private Long userLastModify;

    public QuizContainerList() {
    }

    public QuizPK getQuizPK() {
        return quizPK;
    }

    public void setQuizPK(QuizPK quizPK) {
        this.quizPK = quizPK;
    }

    public QuizContainerList(QuizPK quizPK, String nameQuiz, String shortNameQuiz, String description, String status, String statusCat, Long userCreate, Long userLastModify) {
        this.quizPK = quizPK;
        this.nameQuiz = nameQuiz;
        this.shortNameQuiz = shortNameQuiz;
        this.description = description;
        this.status = status;
        this.statusCat = statusCat;
        this.userCreate = userCreate;
        this.userLastModify = userLastModify;
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
