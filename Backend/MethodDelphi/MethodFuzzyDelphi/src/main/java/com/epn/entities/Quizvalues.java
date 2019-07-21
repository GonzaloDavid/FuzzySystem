/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@Table(name = "Quizvalues")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Quizvalues.findAll", query = "SELECT q FROM Quizvalues q"),
    @NamedQuery(name = "Quizvalues.findByRoundNumber", query = "SELECT q FROM Quizvalues q WHERE q.quizvaluesPK.roundNumber = :roundNumber"),
    @NamedQuery(name = "Quizvalues.findByCodePerson", query = "SELECT q FROM Quizvalues q WHERE q.quizvaluesPK.codePerson = :codePerson"),
    @NamedQuery(name = "Quizvalues.findByCodeQuiz", query = "SELECT q FROM Quizvalues q WHERE q.quizvaluesPK.codeQuiz = :codeQuiz"),
    @NamedQuery(name = "Quizvalues.findByCodeQuestions", query = "SELECT q FROM Quizvalues q WHERE q.quizvaluesPK.codeQuestions = :codeQuestions"),
    @NamedQuery(name = "Quizvalues.findByCodeQuizItem", query = "SELECT q FROM Quizvalues q WHERE q.quizvaluesPK.codeQuizItem = :codeQuizItem"),
    @NamedQuery(name = "Quizvalues.findByMinimumValue", query = "SELECT q FROM Quizvalues q WHERE q.minimumValue = :minimumValue"),
    @NamedQuery(name = "Quizvalues.findByAverageValue", query = "SELECT q FROM Quizvalues q WHERE q.averageValue = :averageValue"),
    @NamedQuery(name = "Quizvalues.findByMaximunValue", query = "SELECT q FROM Quizvalues q WHERE q.maximunValue = :maximunValue")})
    public class Quizvalues implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected QuizvaluesPK quizvaluesPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "minimumValue")
    private String minimumValue;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "averageValue")
    private String averageValue;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "maximunValue")
    private String maximunValue;
    @JoinColumn(name = "codePerson", referencedColumnName = "codePerson", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Person person;
    @JoinColumns({
        @JoinColumn(name = "codeQuizItem", referencedColumnName = "codeQuizItem", insertable = false, updatable = false),
        @JoinColumn(name = "codeQuestions", referencedColumnName = "codeQuestions", insertable = false, updatable = false),
        @JoinColumn(name = "codeQuiz", referencedColumnName = "codeQuiz", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private QuestionItem questionItem;
    @JoinColumns({
        @JoinColumn(name = "codeQuestions", referencedColumnName = "codeQuestions", insertable = false, updatable = false),
        @JoinColumn(name = "codeQuiz", referencedColumnName = "codeQuiz", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Questions questions;
    @JoinColumn(name = "codeQuiz", referencedColumnName = "codeQuiz", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Quiz quiz;

    public Quizvalues() {
    }

    public Quizvalues(QuizvaluesPK quizvaluesPK) {
        this.quizvaluesPK = quizvaluesPK;
    }

    public Quizvalues(QuizvaluesPK quizvaluesPK, String minimumValue, String averageValue, String maximunValue) {
        this.quizvaluesPK = quizvaluesPK;
        this.minimumValue = minimumValue;
        this.averageValue = averageValue;
        this.maximunValue = maximunValue;
    }

    public Quizvalues(long roundNumber, long codePerson, long codeQuiz, long codeQuestions, long codeQuizItem) {
        this.quizvaluesPK = new QuizvaluesPK(roundNumber, codePerson, codeQuiz, codeQuestions, codeQuizItem);
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public QuestionItem getQuestionItem() {
        return questionItem;
    }

    public void setQuestionItem(QuestionItem questionItem) {
        this.questionItem = questionItem;
    }

    public Questions getQuestions() {
        return questions;
    }

    public void setQuestions(Questions questions) {
        this.questions = questions;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (quizvaluesPK != null ? quizvaluesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quizvalues)) {
            return false;
        }
        Quizvalues other = (Quizvalues) object;
        if ((this.quizvaluesPK == null && other.quizvaluesPK != null) || (this.quizvaluesPK != null && !this.quizvaluesPK.equals(other.quizvaluesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.entities.Quizvalues[ quizvaluesPK=" + quizvaluesPK + " ]";
    }
    
}
