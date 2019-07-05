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
public class ItemQuestionContainer {

    private Long codeQuiz;
    private Long codeQuestions;
    private Long codeQuizItem;
    private String itemLabel;
    private String maximunValue;
    private String minimumValue;
    private String averageValue;
    private long userCreate;
    private long userLastModify;

    public ItemQuestionContainer() {
    }

    public ItemQuestionContainer(Long codeQuiz, Long codeQuestions, Long codeQuizItem, String itemLabel, String maximunValue, String minimumValue, String averageValue, long userCreate, long userLastModify) {
        this.codeQuiz = codeQuiz;
        this.codeQuestions = codeQuestions;
        this.codeQuizItem = codeQuizItem;
        this.itemLabel = itemLabel;
        this.maximunValue = maximunValue;
        this.minimumValue = minimumValue;
        this.averageValue = averageValue;
        this.userCreate = userCreate;
        this.userLastModify = userLastModify;
    }

    public Long getCodeQuizItem() {
        return codeQuizItem;
    }

    public void setCodeQuizItem(Long codeQuizItem) {
        this.codeQuizItem = codeQuizItem;
    }

    public String getItemLabel() {
        return itemLabel;
    }

    public void setItemLabel(String itemLabel) {
        this.itemLabel = itemLabel;
    }

    public String getMaximunValue() {
        return maximunValue;
    }

    public void setMaximunValue(String maximunValue) {
        this.maximunValue = maximunValue;
    }

    public String getMinimumValue() {
        return minimumValue;
    }

    public void setMinimumValue(String minimumValue) {
        this.minimumValue = minimumValue;
    }

    public String getAverageValue() {
        return averageValue;
    }

    public void setAverageValue(String averageValue) {
        this.averageValue = averageValue;
    }

    public long getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(long userCreate) {
        this.userCreate = userCreate;
    }

    public long getUserLastModify() {
        return userLastModify;
    }

    public void setUserLastModify(long userLastModify) {
        this.userLastModify = userLastModify;
    }

    public Long getCodeQuiz() {
        return codeQuiz;
    }

    public void setCodeQuiz(Long codeQuiz) {
        this.codeQuiz = codeQuiz;
    }

    public Long getCodeQuestions() {
        return codeQuestions;
    }

    public void setCodeQuestions(Long codeQuestions) {
        this.codeQuestions = codeQuestions;
    }

   
}
