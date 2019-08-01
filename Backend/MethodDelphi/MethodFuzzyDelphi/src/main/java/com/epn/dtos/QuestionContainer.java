/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

import com.epn.entities.QuestionsPK;
import java.math.BigDecimal;
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
    private Long maximumParameterSetting;
    private Long minimumParameterSetting;
    private Long jumpNext;
    private String questionObservation;
    private Long userCreate;
    private Long userLastModify;
    private BigDecimal diffuseDelphiDiscriminator;
    private List<ItemQuestionContainer> questionItemList;

    public QuestionContainer() {
    }

    public QuestionContainer(QuestionsPK questionsPK, String question, String description, String statusCat, String status, Long maximumParameterSetting, Long minimumParameterSetting, Long jumpNext, Long userCreate, Long userLastModify, List<ItemQuestionContainer> questionItemList) {
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

    public Long getMaximumParameterSetting() {
        return maximumParameterSetting;
    }

    public void setMaximumParameterSetting(Long maximumParameterSetting) {
        this.maximumParameterSetting = maximumParameterSetting;
    }

    public Long getMinimumParameterSetting() {
        return minimumParameterSetting;
    }

    public void setMinimumParameterSetting(Long minimumParameterSetting) {
        this.minimumParameterSetting = minimumParameterSetting;
    }

    public Long getJumpNext() {
        return jumpNext;
    }

    public void setJumpNext(Long jumpNext) {
        this.jumpNext = jumpNext;
    }

    public String getQuestionObservation() {
        return questionObservation;
    }

    public void setQuestionObservation(String questionObservation) {
        this.questionObservation = questionObservation;
    }

    public BigDecimal getDiffuseDelphiDiscriminator() {
        return diffuseDelphiDiscriminator;
    }

    public void setDiffuseDelphiDiscriminator(BigDecimal diffuseDelphiDiscriminator) {
        this.diffuseDelphiDiscriminator = diffuseDelphiDiscriminator;
    }      

}
