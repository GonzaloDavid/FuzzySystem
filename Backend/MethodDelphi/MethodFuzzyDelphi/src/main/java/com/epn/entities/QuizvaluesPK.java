/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ka
 */
@Embeddable
public class QuizvaluesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "roundNumber")
    private long roundNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codePerson")
    private long codePerson;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codeQuiz")
    private long codeQuiz;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codeQuestions")
    private long codeQuestions;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codeQuizItem")
    private long codeQuizItem;

    public QuizvaluesPK() {
    }

    public QuizvaluesPK(long roundNumber, long codePerson, long codeQuiz, long codeQuestions, long codeQuizItem) {
        this.roundNumber = roundNumber;
        this.codePerson = codePerson;
        this.codeQuiz = codeQuiz;
        this.codeQuestions = codeQuestions;
        this.codeQuizItem = codeQuizItem;
    }

    public long getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(long roundNumber) {
        this.roundNumber = roundNumber;
    }

    public long getCodePerson() {
        return codePerson;
    }

    public void setCodePerson(long codePerson) {
        this.codePerson = codePerson;
    }

    public long getCodeQuiz() {
        return codeQuiz;
    }

    public void setCodeQuiz(long codeQuiz) {
        this.codeQuiz = codeQuiz;
    }

    public long getCodeQuestions() {
        return codeQuestions;
    }

    public void setCodeQuestions(long codeQuestions) {
        this.codeQuestions = codeQuestions;
    }

    public long getCodeQuizItem() {
        return codeQuizItem;
    }

    public void setCodeQuizItem(long codeQuizItem) {
        this.codeQuizItem = codeQuizItem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) roundNumber;
        hash += (int) codePerson;
        hash += (int) codeQuiz;
        hash += (int) codeQuestions;
        hash += (int) codeQuizItem;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuizvaluesPK)) {
            return false;
        }
        QuizvaluesPK other = (QuizvaluesPK) object;
        if (this.roundNumber != other.roundNumber) {
            return false;
        }
        if (this.codePerson != other.codePerson) {
            return false;
        }
        if (this.codeQuiz != other.codeQuiz) {
            return false;
        }
        if (this.codeQuestions != other.codeQuestions) {
            return false;
        }
        if (this.codeQuizItem != other.codeQuizItem) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.entities.QuizvaluesPK[ roundNumber=" + roundNumber + ", codePerson=" + codePerson + ", codeQuiz=" + codeQuiz + ", codeQuestions=" + codeQuestions + ", codeQuizItem=" + codeQuizItem + " ]";
    }
    
}
