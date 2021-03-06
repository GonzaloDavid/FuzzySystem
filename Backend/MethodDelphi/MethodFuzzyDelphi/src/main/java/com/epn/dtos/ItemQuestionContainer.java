/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

import com.epn.entities.QuestionItemPK;

/**
 *
 * @author david
 */
public class ItemQuestionContainer {

    private QuestionItemPK questionItemPK;
    private String itemLabel;
    private String classification;
    private String maximunValue;
    private String minimumValue;
    private String averageValue;
    private String itemdescription;
    private String itemobservation;
    private String statusCat;
    private String status;
    private String imageUrl;
    private long numberofcomments;

    private long userCreate;
    private long userLastModify;

    public ItemQuestionContainer() {
    }

    public ItemQuestionContainer(QuestionItemPK questionItemPK) {
        this.questionItemPK = questionItemPK;
    }

    public ItemQuestionContainer(QuestionItemPK questionItemPK, String itemLabel, String classification, String maximunValue, String minimumValue, String averageValue, long userCreate, long userLastModify) {
        this.questionItemPK = questionItemPK;
        this.itemLabel = itemLabel;
        this.classification = classification;
        this.maximunValue = maximunValue;
        this.minimumValue = minimumValue;
        this.averageValue = averageValue;
        this.userCreate = userCreate;
        this.userLastModify = userLastModify;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
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

    public QuestionItemPK getQuestionItemPK() {
        return questionItemPK;
    }

    public void setQuestionItemPK(QuestionItemPK questionItemPK) {
        this.questionItemPK = questionItemPK;
    }

    public String getItemdescription() {
        return itemdescription;
    }

    public void setItemdescription(String itemdescription) {
        this.itemdescription = itemdescription;
    }

    public String getItemobservation() {
        return itemobservation;
    }

    public void setItemobservation(String itemobservation) {
        this.itemobservation = itemobservation;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public long getNumberofcomments() {
        return numberofcomments;
    }

    public void setNumberofcomments(long numberofcomments) {
        this.numberofcomments = numberofcomments;
    }
    
}
