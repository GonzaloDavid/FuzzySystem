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
public class CriteriaMatrixAverageValuePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "codefahp")
    private long codefahp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codeCriteria")
    private long codeCriteria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codeCriteriaCouple")
    private long codeCriteriaCouple;

    public CriteriaMatrixAverageValuePK() {
    }

    public CriteriaMatrixAverageValuePK(long codefahp, long codeCriteria, long codeCriteriaCouple) {
        this.codefahp = codefahp;
        this.codeCriteria = codeCriteria;
        this.codeCriteriaCouple = codeCriteriaCouple;
    }

    public long getCodefahp() {
        return codefahp;
    }

    public void setCodefahp(long codefahp) {
        this.codefahp = codefahp;
    }

    public long getCodeCriteria() {
        return codeCriteria;
    }

    public void setCodeCriteria(long codeCriteria) {
        this.codeCriteria = codeCriteria;
    }

    public long getCodeCriteriaCouple() {
        return codeCriteriaCouple;
    }

    public void setCodeCriteriaCouple(long codeCriteriaCouple) {
        this.codeCriteriaCouple = codeCriteriaCouple;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codefahp;
        hash += (int) codeCriteria;
        hash += (int) codeCriteriaCouple;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CriteriaMatrixAverageValuePK)) {
            return false;
        }
        CriteriaMatrixAverageValuePK other = (CriteriaMatrixAverageValuePK) object;
        if (this.codefahp != other.codefahp) {
            return false;
        }
        if (this.codeCriteria != other.codeCriteria) {
            return false;
        }
        if (this.codeCriteriaCouple != other.codeCriteriaCouple) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.entities.CriteriaMatrixAverageValuePK[ codefahp=" + codefahp + ", codeCriteria=" + codeCriteria + ", codeCriteriaCouple=" + codeCriteriaCouple + " ]";
    }
    
}
