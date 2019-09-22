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
public class SentemailbycodefahpPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "codefahp")
    private long codefahp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codePerson")
    private long codePerson;

    public SentemailbycodefahpPK() {
    }

    public SentemailbycodefahpPK(long codefahp, long codePerson) {
        this.codefahp = codefahp;
        this.codePerson = codePerson;
    }

    public long getCodefahp() {
        return codefahp;
    }

    public void setCodefahp(long codefahp) {
        this.codefahp = codefahp;
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
        hash += (int) codefahp;
        hash += (int) codePerson;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SentemailbycodefahpPK)) {
            return false;
        }
        SentemailbycodefahpPK other = (SentemailbycodefahpPK) object;
        if (this.codefahp != other.codefahp) {
            return false;
        }
        if (this.codePerson != other.codePerson) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.entities.SentemailbycodefahpPK[ codefahp=" + codefahp + ", codePerson=" + codePerson + " ]";
    }
    
}
