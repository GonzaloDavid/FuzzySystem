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
public class CriteriabycodefahpPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "codefahp")
    private long codefahp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codeCriteria")
    private long codeCriteria;

    public CriteriabycodefahpPK() {
    }

    public CriteriabycodefahpPK(long codefahp, long codeCriteria) {
        this.codefahp = codefahp;
        this.codeCriteria = codeCriteria;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codefahp;
        hash += (int) codeCriteria;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CriteriabycodefahpPK)) {
            return false;
        }
        CriteriabycodefahpPK other = (CriteriabycodefahpPK) object;
        if (this.codefahp != other.codefahp) {
            return false;
        }
        if (this.codeCriteria != other.codeCriteria) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.entities.CriteriabycodefahpPK[ codefahp=" + codefahp + ", codeCriteria=" + codeCriteria + " ]";
    }
    
}
