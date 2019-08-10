/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author ka
 */
public class Item {

    private Long roundNumber;
    private Long codeQuiz;
    private Long codeQuestion;
    private Long codeItem;

    private float threshold; // Umbral, Indice de convergencia o determinante...

    ArrayList<ItemResponse> itemResponseList; // Lista de respuestas!!! ...

    private Double lowerValue;
    private Double middleValue;
    private Double upperValue;
    private Double defuzzificationValue; // crispNumberSj

    private int validate; // Validar 0 o 1, false or true, rechazar o aceptar, eliminar o seleccionar.

    // Constantes ==========================
    protected static String MIN = "minimo";
    protected static String MED = "medio";
    protected static String MAX = "maximo";

    // Constructores ===========================================================
    public Item() {

    }

    public Item(Long roundNumber, Long codeQuiz, Long codeQuestion, Long codeItem, float threshold,
            ArrayList<ItemResponse> itemResponseList) {
        this.roundNumber = roundNumber;
        this.codeQuiz = codeQuiz;
        this.codeQuestion = codeQuestion;
        this.codeItem = codeItem;
        this.threshold = threshold;
        this.itemResponseList = itemResponseList;
    }

    // Methods ================================
    public void runFuzzyDelphiMethod() {

        ArrayList<Double> minValueList = new ArrayList();
        ArrayList<Double> aveValueList = new ArrayList();
        ArrayList<Double> maxValueList = new ArrayList();

        for (ItemResponse itemResponse : this.itemResponseList) {
            minValueList.add(itemResponse.getMinValue());
            aveValueList.add(itemResponse.getAveValue());
            maxValueList.add(itemResponse.getMaxValue());
        }

        if (!minValueList.isEmpty() && !aveValueList.isEmpty() && !maxValueList.isEmpty()) {

            // TriangularFuzzyNumber =======
            this.lowerValue = Collections.min(minValueList);
            this.middleValue = calculateMiddleValue(aveValueList);
            this.upperValue = Collections.max(maxValueList);

            this.defuzzificationValue = (this.lowerValue + this.middleValue + this.upperValue) / 3;

            this.validate = (this.defuzzificationValue >= this.threshold) ? 1 : 0;
        }
    }

    public void determinateConsensusByItemResponses() {
        if (this.lowerValue != null && this.middleValue != null) {
            this.itemResponseList.forEach(itemResponse -> {
                itemResponse.calculateConsensus(this.lowerValue, this.middleValue);
            });
        }
    }

    protected Double calculateMiddleValue(ArrayList<Double> averageValues) {
        int total = averageValues.isEmpty() ? 1 : averageValues.size();
        double producto = 1.0;

        for (Double med : averageValues) {
            producto = producto * med;
        }

        return Math.pow(producto, (1.0 / total));
    }

    // Getters and Setters ===================================
    public Long getRoundNumber() {
        return this.roundNumber;
    }

    public void setRoundNumber(Long roundNumber) {
        this.roundNumber = roundNumber;
    }

    public Long getCodeQuiz() {
        return this.codeQuiz;
    }

    public void setCodeQuiz(Long codeQuiz) {
        this.codeQuiz = codeQuiz;
    }

    public Long getCodeQuestion() {
        return this.codeQuestion;
    }

    public void setCodeQuestion(Long codeQuestion) {
        this.codeQuestion = codeQuestion;
    }

    public Long getCodeItem() {
        return this.codeItem;
    }

    public void setCodeItem(Long codeItem) {
        this.codeItem = codeItem;
    }

    public float getThreshold() {
        return this.threshold;
    }

    public void setThreshold(float threshold) {
        this.threshold = threshold;
    }

    public ArrayList<ItemResponse> getItemResponseList() {
        return this.itemResponseList;
    }

    public void setItemResponseList(ArrayList<ItemResponse> itemResponseList) {
        this.itemResponseList = itemResponseList;
    }

    public Double getLowerValue() {
        return this.lowerValue;
    }

    public void setLowerValue(Double lowerValue) {
        this.lowerValue = lowerValue;
    }

    public Double getMiddleValue() {
        return this.middleValue;
    }

    public void setMiddleValue(Double middleValue) {
        this.middleValue = middleValue;
    }

    public Double getUpperValue() {
        return this.upperValue;
    }

    public void setUpperValue(Double upperValue) {
        this.upperValue = upperValue;
    }

    public Double getDefuzzificationValue() {
        return this.defuzzificationValue;
    }

    public void setDefuzzificationValue(Double defuzzificationValue) {
        this.defuzzificationValue = defuzzificationValue;
    }

    public int getValidate() {
        return this.validate;
    }

    public void setValidate(int validate) {
        this.validate = validate;
    }

    @Override
    public String toString() {
        return "{" + " numberRound='" + getRoundNumber() + "'" + ", codeQuiz='" + getCodeQuiz() + "'"
                + ", codeQuestion='" + getCodeQuestion() + "'" + ", codeItem='" + getCodeItem() + "'" + ", threshold='"
                + getThreshold() + "'" + ", itemResponseList='" + getItemResponseList() + "'" + ", lowerValue='"
                + getLowerValue() + "'" + ", middleValue='" + getMiddleValue() + "'" + ", upperValue='"
                + getUpperValue() + "'" + ", defuzzificationValue='" + getDefuzzificationValue() + "'" + ", validate='"
                + getValidate() + "'" + "}";
    }

}
