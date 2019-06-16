/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

/**
 *
 * @author david
 */
public class QuizContainer {

    private Long codeQuiz;
    private String nameQuiz;
    private String shortNameQuiz;
    private String description;
    private String status;
    private String statusCat;
 //   private List<Questions> questionlist;
//    private List<QuestionItem> questionItemList;
    private Long userCreate;
    private Long userLastModify;

    public QuizContainer() {
    }

    public QuizContainer(Long codeQuiz, String nameQuiz, String shortNameQuiz, String description, String status, String statusCat, Long userCreate, Long userLastModify) {
        this.codeQuiz = codeQuiz;
        this.nameQuiz = nameQuiz;
        this.shortNameQuiz = shortNameQuiz;
        this.description = description;
        this.status = status;
        this.statusCat = statusCat;
//        this.questionlist = questionlist;
     //   this.questionItemList = questionItemList;
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
/*
    public List<Questions> getQuestionlist() {
        return questionlist;
    }

    public void setQuestionlist(List<Questions> questionlist) {
        this.questionlist = questionlist;
    }*/
/*
    public List<QuestionItem> getQuestionItemList() {
        return questionItemList;
    }

    public void setQuestionItemList(List<QuestionItem> questionItemList) {
        this.questionItemList = questionItemList;
    }

 */

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
