/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author david
 */
public class AttributeProcessContainer {

    private List<Double> triangularNumber = new ArrayList();
    private List<Double> triangularNumberNormalized = new ArrayList();
    private Long codefahp;
    private Long codeQuiz;
    private Long codecriteria;
    private Long codeQuestion;
    private Long codeItem;
    double defusification;
    double weigth;

    public AttributeProcessContainer() {
    }

    public AttributeProcessContainer(Long codefahp, Long codecriteria, Long codeQuestion, Long codeItem, double defusification, double weigth) {
        this.codefahp = codefahp;
        this.codecriteria = codecriteria;
        this.codeQuestion = codeQuestion;
        this.codeItem = codeItem;
        this.defusification = defusification;
        this.weigth = weigth;
    }

    public List<Double> getTriangularNumber() {
        return triangularNumber;
    }

    public void setTriangularNumber(List<Double> triangularNumber) {
        this.triangularNumber = triangularNumber;
    }

    public List<Double> getTriangularNumberNormalized() {
        return triangularNumberNormalized;
    }

    public void setTriangularNumberNormalized(List<Double> triangularNumberNormalized) {
        this.triangularNumberNormalized = triangularNumberNormalized;
    }

    public Long getCodefahp() {
        return codefahp;
    }

    public void setCodefahp(Long codefahp) {
        this.codefahp = codefahp;
    }

    public Long getCodecriteria() {
        return codecriteria;
    }

    public void setCodecriteria(Long codecriteria) {
        this.codecriteria = codecriteria;
    }

    public Long getCodeQuestion() {
        return codeQuestion;
    }

    public void setCodeQuestion(Long codeQuestion) {
        this.codeQuestion = codeQuestion;
    }

    public Long getCodeItem() {
        return codeItem;
    }

    public void setCodeItem(Long codeItem) {
        this.codeItem = codeItem;
    }

    public double getDefusification() {
        return defusification;
    }

    public void setDefusification(double defusification) {
        this.defusification = defusification;
    }

    public double getWeigth() {
        return weigth;
    }

    public void setWeigth(double weigth) {
        this.weigth = weigth;
    }

    public Long getCodeQuiz() {
        return codeQuiz;
    }

    public void setCodeQuiz(Long codeQuiz) {
        this.codeQuiz = codeQuiz;
    }

}
