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
 * @author david
 */
@Embeddable
public class ItemCommentPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "codeQuizItem")
    private long codeQuizItem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codeQuestions")
    private long codeQuestions;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codeQuiz")
    private long codeQuiz;
    @Basic(optional = false)
    @NotNull
    @Column(name = "roundNumber")
    private long roundNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codePerson")
    private long codePerson;

    public ItemCommentPK() {
    }

    public ItemCommentPK(long codeQuizItem, long codeQuestions, long codeQuiz, long roundNumber, long codePerson) {
        this.codeQuizItem = codeQuizItem;
        this.codeQuestions = codeQuestions;
        this.codeQuiz = codeQuiz;
        this.roundNumber = roundNumber;
        this.codePerson = codePerson;
    }

    public long getCodeQuizItem() {
        return codeQuizItem;
    }

    public void setCodeQuizItem(long codeQuizItem) {
        this.codeQuizItem = codeQuizItem;
    }

    public long getCodeQuestions() {
        return codeQuestions;
    }

    public void setCodeQuestions(long codeQuestions) {
        this.codeQuestions = codeQuestions;
    }

    public long getCodeQuiz() {
        return codeQuiz;
    }

    public void setCodeQuiz(long codeQuiz) {
        this.codeQuiz = codeQuiz;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codeQuizItem;
        hash += (int) codeQuestions;
        hash += (int) codeQuiz;
        hash += (int) roundNumber;
        hash += (int) codePerson;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemCommentPK)) {
            return false;
        }
        ItemCommentPK other = (ItemCommentPK) object;
        if (this.codeQuizItem != other.codeQuizItem) {
            return false;
        }
        if (this.codeQuestions != other.codeQuestions) {
            return false;
        }
        if (this.codeQuiz != other.codeQuiz) {
            return false;
        }
        if (this.roundNumber != other.roundNumber) {
            return false;
        }
        if (this.codePerson != other.codePerson) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.entities.ItemCommentPK[ codeQuizItem=" + codeQuizItem + ", codeQuestions=" + codeQuestions + ", codeQuiz=" + codeQuiz + ", roundNumber=" + roundNumber + ", codePerson=" + codePerson + " ]";
    }
    
}
