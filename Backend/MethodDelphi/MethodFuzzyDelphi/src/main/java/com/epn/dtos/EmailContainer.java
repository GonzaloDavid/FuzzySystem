/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

import com.epn.entities.Person;
import com.epn.entities.Quiz;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author david
 */
public class EmailContainer {
    List<Person> persons=new ArrayList();
    Quiz quiz= new Quiz();
    Long roundNumber;

    public EmailContainer() {
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    } 

    public Long getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(Long roundNumber) {
        this.roundNumber = roundNumber;
    }
    
}
