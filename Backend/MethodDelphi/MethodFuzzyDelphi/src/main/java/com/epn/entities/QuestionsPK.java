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
public class QuestionsPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "codeQuestions")
    private long codeQuestions;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codeQuiz")
    private long codeQuiz;

    public QuestionsPK() {
    }

    public QuestionsPK(long codeQuestions, long codeQuiz) {
        this.codeQuestions = codeQuestions;
        this.codeQuiz = codeQuiz;
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
        hash += (int) codeQuestions;
        hash += (int) codeQuiz;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuestionsPK)) {
            return false;
        }
        QuestionsPK other = (QuestionsPK) object;
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
        return "com.epn.entities.QuestionsPK[ codeQuestions=" + codeQuestions + ", codeQuiz=" + codeQuiz + " ]";
    }
    
}
