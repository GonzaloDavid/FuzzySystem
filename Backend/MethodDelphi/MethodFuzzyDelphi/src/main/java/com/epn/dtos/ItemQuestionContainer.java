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

    private Long codeQuizItem;
    private String itemLabel;
    private String maximunValue;
    private String minimumValue;
    private String averageValue;
    private String maximumParameterSetting;
    private String minimumParameterSetting;
    private String jumpNext;
    private long userCreate;
    private long userLastModify;

    public ItemQuestionContainer() {
    }

    public ItemQuestionContainer(Long codeQuizItem, String itemLabel, String maximunValue, String minimumValue, String averageValue, String maximumParameterSetting, String minimumParameterSetting, String jumpNext, long userCreate, long userLastModify) {
        this.codeQuizItem = codeQuizItem;
        this.itemLabel = itemLabel;
        this.maximunValue = maximunValue;
        this.minimumValue = minimumValue;
        this.averageValue = averageValue;
        this.maximumParameterSetting = maximumParameterSetting;
        this.minimumParameterSetting = minimumParameterSetting;
        this.jumpNext = jumpNext;
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
    
}
