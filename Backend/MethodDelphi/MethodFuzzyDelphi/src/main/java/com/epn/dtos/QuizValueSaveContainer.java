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
public class QuizValueSaveContainer {
    QuizContainer quiz=new QuizContainer();
    Long codeperson;
    Long roundNumber;

    public QuizValueSaveContainer() {
    }

    public QuizValueSaveContainer(Long codeperson, Long roundNumber) {
        this.codeperson = codeperson;
        this.roundNumber = roundNumber;
    }

    public QuizContainer getQuiz() {
        return quiz;
    }

    public void setQuiz(QuizContainer quiz) {
        this.quiz = quiz;
    }

    public Long getCodeperson() {
        return codeperson;
    }

    public void setCodeperson(Long codeperson) {
        this.codeperson = codeperson;
    }

    public Long getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(Long roundNumber) {
        this.roundNumber = roundNumber;
    }
    
    
    
}
