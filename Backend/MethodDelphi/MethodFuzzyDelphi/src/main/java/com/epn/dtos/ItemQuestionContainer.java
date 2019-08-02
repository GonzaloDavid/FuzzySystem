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
    private String maximunValue;
    private String minimumValue;
    private String averageValue;
    private String itemdescription;
    private String itemobservation;
    private long userCreate;
    private long userLastModify;

    public ItemQuestionContainer() {
    }

    public ItemQuestionContainer(QuestionItemPK questionItemPK) {
        this.questionItemPK = questionItemPK;
    }

    public ItemQuestionContainer(QuestionItemPK questionItemPK, String itemLabel, String maximunValue, String minimumValue, String averageValue, long userCreate, long userLastModify) {
        this.questionItemPK = questionItemPK;
        this.itemLabel = itemLabel;
        this.maximunValue = maximunValue;
        this.minimumValue = minimumValue;
        this.averageValue = averageValue;
        this.userCreate = userCreate;
        this.userLastModify = userLastModify;
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
    
   
}
