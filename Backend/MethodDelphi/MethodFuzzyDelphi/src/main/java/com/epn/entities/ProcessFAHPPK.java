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
public class ProcessFAHPPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "codeCriteria")
    private long codeCriteria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codeQuiz")
    private long codeQuiz;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codeQuestions")
    private long codeQuestions;

    public ProcessFAHPPK() {
    }

    public ProcessFAHPPK(long codeCriteria, long codeQuiz, long codeQuestions) {
        this.codeCriteria = codeCriteria;
        this.codeQuiz = codeQuiz;
        this.codeQuestions = codeQuestions;
    }

    public long getCodeCriteria() {
        return codeCriteria;
    }

    public void setCodeCriteria(long codeCriteria) {
        this.codeCriteria = codeCriteria;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codeCriteria;
        hash += (int) codeQuiz;
        hash += (int) codeQuestions;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcessFAHPPK)) {
            return false;
        }
        ProcessFAHPPK other = (ProcessFAHPPK) object;
        if (this.codeCriteria != other.codeCriteria) {
            return false;
        }
        if (this.codeQuiz != other.codeQuiz) {
            return false;
        }
        if (this.codeQuestions != other.codeQuestions) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.entities.ProcessFAHPPK[ codeCriteria=" + codeCriteria + ", codeQuiz=" + codeQuiz + ", codeQuestions=" + codeQuestions + " ]";
    }
    
}
