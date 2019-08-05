/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

import com.epn.entities.QuizvaluesPK;

/**
 *
 * @author david
 */
public class QuizValuesContainer {
    private QuizvaluesPK quizvaluesPK;
    private String minimumValue;
    private String averageValue;
    private String maximunValue;
    private String quizObservation;
    private String questionObservation;

    public QuizValuesContainer() {
    }

    public QuizValuesContainer(QuizvaluesPK quizvaluesPK, String minimumValue, String averageValue, String maximunValue, String quizObservation, String questionObservation) {
        this.quizvaluesPK = quizvaluesPK;
        this.minimumValue = minimumValue;
        this.averageValue = averageValue;
        this.maximunValue = maximunValue;
        this.quizObservation = quizObservation;
        this.questionObservation = questionObservation;
    }

    public QuizvaluesPK getQuizvaluesPK() {
        return quizvaluesPK;
    }

    public void setQuizvaluesPK(QuizvaluesPK quizvaluesPK) {
        this.quizvaluesPK = quizvaluesPK;
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

    public String getMaximunValue() {
        return maximunValue;
    }

    public void setMaximunValue(String maximunValue) {
        this.maximunValue = maximunValue;
    }

    public String getQuizObservation() {
        return quizObservation;
    }

    public void setQuizObservation(String quizObservation) {
        this.quizObservation = quizObservation;
    }

    public String getQuestionObservation() {
        return questionObservation;
    }

    public void setQuestionObservation(String questionObservation) {
        this.questionObservation = questionObservation;
    }
    
    
}
