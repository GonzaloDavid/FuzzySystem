/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

import com.epn.entities.DelphiCalculationsPK;
import java.math.BigDecimal;

/**
 *
 * @author david
 */
public class DelphiCalculationsContainer {
    protected DelphiCalculationsPK delphiCalculationsPK;
    private BigDecimal lowerValue;
    private BigDecimal mediaValue;
    private BigDecimal upperValue;
    private BigDecimal defuzzificationValue;
    private BigDecimal threshold;
    private BigDecimal lowerAverage;
    private BigDecimal mediaAverage;
    private BigDecimal upperAverage;
    private int validated;
    private int consensus;
    private String statusResultCat1;
    private String statusResult;
    private String namestatusresultcat;
    private String quizlabel;
    private String questionlabel;
    private String itemquestionlabel;

    public DelphiCalculationsContainer() {
    }

    
    public DelphiCalculationsContainer(DelphiCalculationsPK delphiCalculationsPK, BigDecimal lowerValue, BigDecimal mediaValue, BigDecimal upperValue, BigDecimal defuzzificationValue, BigDecimal threshold, BigDecimal lowerAverage, BigDecimal mediaAverage, BigDecimal upperAverage, int validated,int consensus, String statusResultCat1, String statusResult) {
        this.delphiCalculationsPK = delphiCalculationsPK;
        this.lowerValue = lowerValue;
        this.mediaValue = mediaValue;
        this.upperValue = upperValue;
        this.defuzzificationValue = defuzzificationValue;
        this.threshold = threshold;
        this.lowerAverage = lowerAverage;
        this.mediaAverage = mediaAverage;
        this.upperAverage = upperAverage;
        this.validated = validated;
        this.consensus = consensus;
        this.statusResultCat1 = statusResultCat1;
        this.statusResult = statusResult;
    }

    public DelphiCalculationsPK getDelphiCalculationsPK() {
        return delphiCalculationsPK;
    }

    public void setDelphiCalculationsPK(DelphiCalculationsPK delphiCalculationsPK) {
        this.delphiCalculationsPK = delphiCalculationsPK;
    }

    public BigDecimal getLowerValue() {
        return lowerValue;
    }

    public void setLowerValue(BigDecimal lowerValue) {
        this.lowerValue = lowerValue;
    }

    public BigDecimal getMediaValue() {
        return mediaValue;
    }

    public void setMediaValue(BigDecimal mediaValue) {
        this.mediaValue = mediaValue;
    }

    public int getConsensus() {
        return consensus;
    }

    public void setConsensus(int consensus) {
        this.consensus = consensus;
    }

    public BigDecimal getUpperValue() {
        return upperValue;
    }

    public void setUpperValue(BigDecimal upperValue) {
        this.upperValue = upperValue;
    }

    public BigDecimal getDefuzzificationValue() {
        return defuzzificationValue;
    }

    public void setDefuzzificationValue(BigDecimal defuzzificationValue) {
        this.defuzzificationValue = defuzzificationValue;
    }

    public BigDecimal getThreshold() {
        return threshold;
    }

    public void setThreshold(BigDecimal threshold) {
        this.threshold = threshold;
    }

    public BigDecimal getLowerAverage() {
        return lowerAverage;
    }

    public void setLowerAverage(BigDecimal lowerAverage) {
        this.lowerAverage = lowerAverage;
    }

    public BigDecimal getMediaAverage() {
        return mediaAverage;
    }

    public void setMediaAverage(BigDecimal mediaAverage) {
        this.mediaAverage = mediaAverage;
    }

    public BigDecimal getUpperAverage() {
        return upperAverage;
    }

    public void setUpperAverage(BigDecimal upperAverage) {
        this.upperAverage = upperAverage;
    }

    public int getValidated() {
        return validated;
    }

    public void setValidated(int validated) {
        this.validated = validated;
    }

    public String getStatusResultCat1() {
        return statusResultCat1;
    }

    public void setStatusResultCat1(String statusResultCat1) {
        this.statusResultCat1 = statusResultCat1;
    }

    public String getStatusResult() {
        return statusResult;
    }

    public void setStatusResult(String statusResult) {
        this.statusResult = statusResult;
    }

    public String getNamestatusresultcat() {
        return namestatusresultcat;
    }

    public void setNamestatusresultcat(String namestatusresultcat) {
        this.namestatusresultcat = namestatusresultcat;
    }

    public String getQuizlabel() {
        return quizlabel;
    }

    public void setQuizlabel(String quizlabel) {
        this.quizlabel = quizlabel;
    }

    public String getQuestionlabel() {
        return questionlabel;
    }

    public void setQuestionlabel(String questionlabel) {
        this.questionlabel = questionlabel;
    }

    public String getItemquestionlabel() {
        return itemquestionlabel;
    }

    public void setItemquestionlabel(String itemquestionlabel) {
        this.itemquestionlabel = itemquestionlabel;
    }
    
}
