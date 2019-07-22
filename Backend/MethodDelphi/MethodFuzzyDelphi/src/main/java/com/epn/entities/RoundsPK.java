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
public class RoundsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "roundNumber")
    private long roundNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codeQuiz")
    private long codeQuiz;

    public RoundsPK() {
    }

    public RoundsPK(long roundNumber, long codeQuiz) {
        this.roundNumber = roundNumber;
        this.codeQuiz = codeQuiz;
    }

    public long getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(long roundNumber) {
        this.roundNumber = roundNumber;
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
        hash += (int) roundNumber;
        hash += (int) codeQuiz;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoundsPK)) {
            return false;
        }
        RoundsPK other = (RoundsPK) object;
        if (this.roundNumber != other.roundNumber) {
            return false;
        }
        if (this.codeQuiz != other.codeQuiz) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.entities.RoundsPK[ roundNumber=" + roundNumber + ", codeQuiz=" + codeQuiz + " ]";
    }
    
}
