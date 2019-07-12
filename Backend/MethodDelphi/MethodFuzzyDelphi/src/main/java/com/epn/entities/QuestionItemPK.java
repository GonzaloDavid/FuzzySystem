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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author david
 */
@Embeddable
public class QuestionItemPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "codeQuizItem")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codeQuizItem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codeQuestions")
    private long codeQuestions;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codeQuiz")
    private long codeQuiz;

    public QuestionItemPK() {
    }

    public QuestionItemPK(long codeQuizItem, long codeQuestions, long codeQuiz) {
        this.codeQuizItem = codeQuizItem;
        this.codeQuestions = codeQuestions;
        this.codeQuiz = codeQuiz;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codeQuizItem;
        hash += (int) codeQuestions;
        hash += (int) codeQuiz;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuestionItemPK)) {
            return false;
        }
        QuestionItemPK other = (QuestionItemPK) object;
        if (this.codeQuizItem != other.codeQuizItem) {
            return false;
        }
        if (this.codeQuestions != other.codeQuestions) {
            return false;
        }
        if (this.codeQuiz != other.codeQuiz) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.entities.QuestionItemPK[ codeQuizItem=" + codeQuizItem + ", codeQuestions=" + codeQuestions + ", codeQuiz=" + codeQuiz + " ]";
    }
    
}
