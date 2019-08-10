/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

/**
 *
 * @author ka
 */
public class Item {

    private Long roundNumber; // ronda del item
    private Long codeQuiz; // codigo de encuesta
    private Long codeQuestions; // codigo de pregunta
    private Integer idExperto; // id del criterio
    private Integer idItem; // id del criterio

    private Double min; // mij
    private Double med; // lij
    private Double max; // uij
    // Validacion de Items o Criterios´
    private Double lowerValue; // Lj
    private Double middleValue; // Mj
    private Double rangoG; // G(=Uij - Lj)
    private Integer estadoRangoG; // Verdadero o Falso 1 o 0;
    private Double rangoC; // valorAbsoluto(Mj-mij)
    private Integer consensoGC; // Verdadero o Falso 1 o 0;

    // Constructores ===========================================================
    public Item(Integer idExperto, Integer idItem, Double min, Double med, Double max) {
        this.idExperto = idExperto;
        this.idItem = idItem;
        this.min = min;
        this.med = med;
        this.max = max;
    }

    public Item(Long roundNumber, Long codeQuiz, Long codeQuestions, Integer idExperto, Integer idItem, Double min, Double med, Double max) {
        this.roundNumber = roundNumber;
        this.codeQuiz = codeQuiz;
        this.codeQuestions = codeQuestions;
        this.idExperto = idExperto;
        this.idItem = idItem;
        this.min = min;
        this.med = med;
        this.max = max;
    }

    public void calculateConsensus() {

        if (this.middleValue != null && this.lowerValue != null) {
            this.rangoG = this.max - this.min;
            this.estadoRangoG = (this.rangoG > 0) ? 1 : 0;
            this.rangoC = Math.abs((this.med - this.middleValue));
            this.consensoGC = (this.rangoG > this.rangoC) ? 1 : 0;
        }
    }

    public Long getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(Long roundNumber) {
        this.roundNumber = roundNumber;
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

    public Integer getIdExperto() {
        return idExperto;
    }

    public void setIdExperto(Integer idExperto) {
        this.idExperto = idExperto;
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getMed() {
        return med;
    }

    public void setMed(Double med) {
        this.med = med;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public Double getLowerValue() {
        return lowerValue;
    }

    public void setLowerValue(Double lowerValue) {
        this.lowerValue = lowerValue;
    }

    public Double getMiddleValue() {
        return middleValue;
    }

    public void setMiddleValue(Double middleValue) {
        this.middleValue = middleValue;
    }

    public Double getRangoG() {
        return rangoG;
    }

    public void setRangoG(Double rangoG) {
        this.rangoG = rangoG;
    }

    public Integer getEstadoRangoG() {
        return estadoRangoG;
    }

    public void setEstadoRangoG(Integer estadoRangoG) {
        this.estadoRangoG = estadoRangoG;
    }

    public Double getRangoC() {
        return rangoC;
    }

    public void setRangoC(Double rangoC) {
        this.rangoC = rangoC;
    }

    public Integer getConsensoGC() {
        return consensoGC;
    }

    public void setConsensoGC(Integer consensoGC) {
        this.consensoGC = consensoGC;
    }

    @Override
    public String toString() {
        return "Item{" + "roundNumber=" + roundNumber + ", codeQuiz=" + codeQuiz + ", codeQuestions=" + codeQuestions + ", idExperto=" + idExperto + ", idItem=" + idItem + ", min=" + min + ", med=" + med + ", max=" + max + ", lowerValue=" + lowerValue + ", middleValue=" + middleValue + ", rangoG=" + rangoG + ", estadoRangoG=" + estadoRangoG + ", rangoC=" + rangoC + ", consensoGC=" + consensoGC + '}';
    }

}
