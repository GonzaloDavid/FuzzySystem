/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

import com.epn.entities.QuestionsPK;
import java.util.List;

/**
 *
 * @author david
 */
public class QuestionContainer {

    private QuestionsPK questionsPK;
    private String question;
    private String description;
    private String statusCat;
    private String status;
    private String maximumParameterSetting;
    private String minimumParameterSetting;
    private String jumpNext;
    private Long userCreate;
    private Long userLastModify;
    private List<ItemQuestionContainer> questionItemList;

    public QuestionContainer() {
    }

    public QuestionContainer(QuestionsPK questionsPK, String question, String description, String statusCat, String status, String maximumParameterSetting, String minimumParameterSetting, String jumpNext, Long userCreate, Long userLastModify, List<ItemQuestionContainer> questionItemList) {
        this.questionsPK = questionsPK;
        this.question = question;
        this.description = description;
        this.statusCat = statusCat;
        this.status = status;
        this.maximumParameterSetting = maximumParameterSetting;
        this.minimumParameterSetting = minimumParameterSetting;
        this.jumpNext = jumpNext;
        this.userCreate = userCreate;
        this.userLastModify = userLastModify;
        this.questionItemList = questionItemList;
    }

    public QuestionsPK getQuestionsPK() {
        return questionsPK;
    }

    public void setQuestionsPK(QuestionsPK questionsPK) {
        this.questionsPK = questionsPK;
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

    public String getMaximumParameterSetting() {
        return maximumParameterSetting;
    }

    public void setMaximumParameterSetting(String maximumParameterSetting) {
        this.maximumParameterSetting = maximumParameterSetting;
    }

    public String getMinimumParameterSetting() {
        return minimumParameterSetting;
    }

    public void setMinimumParameterSetting(String minimumParameterSetting) {
        this.minimumParameterSetting = minimumParameterSetting;
    }

    public String getJumpNext() {
        return jumpNext;
    }

    public void setJumpNext(String jumpNext) {
        this.jumpNext = jumpNext;
    }
    

}
