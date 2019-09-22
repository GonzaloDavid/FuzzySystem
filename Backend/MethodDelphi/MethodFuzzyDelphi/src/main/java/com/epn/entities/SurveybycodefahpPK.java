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
public class SurveybycodefahpPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "codefahp")
    private long codefahp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codeQuiz")
    private long codeQuiz;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codeQuestions")
    private long codeQuestions;

    public SurveybycodefahpPK() {
    }

    public SurveybycodefahpPK(long codefahp, long codeQuiz, long codeQuestions) {
        this.codefahp = codefahp;
        this.codeQuiz = codeQuiz;
        this.codeQuestions = codeQuestions;
    }

    public long getCodefahp() {
        return codefahp;
    }

    public void setCodefahp(long codefahp) {
        this.codefahp = codefahp;
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
        hash += (int) codefahp;
        hash += (int) codeQuiz;
        hash += (int) codeQuestions;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SurveybycodefahpPK)) {
            return false;
        }
        SurveybycodefahpPK other = (SurveybycodefahpPK) object;
        if (this.codefahp != other.codefahp) {
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
        return "com.epn.entities.SurveybycodefahpPK[ codefahp=" + codefahp + ", codeQuiz=" + codeQuiz + ", codeQuestions=" + codeQuestions + " ]";
    }
    
}
