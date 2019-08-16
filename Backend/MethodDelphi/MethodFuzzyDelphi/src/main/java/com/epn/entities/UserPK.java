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
public class UserPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "codeuser")
    private long codeuser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codeperson")
    private long codeperson;

    public UserPK() {
    }

    public UserPK(long codeuser, long codeperson) {
        this.codeuser = codeuser;
        this.codeperson = codeperson;
    }

    public long getCodeuser() {
        return codeuser;
    }

    public void setCodeuser(long codeuser) {
        this.codeuser = codeuser;
    }

    public long getCodeperson() {
        return codeperson;
    }

    public void setCodeperson(long codeperson) {
        this.codeperson = codeperson;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codeuser;
        hash += (int) codeperson;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserPK)) {
            return false;
        }
        UserPK other = (UserPK) object;
        if (this.codeuser != other.codeuser) {
            return false;
        }
        if (this.codeperson != other.codeperson) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.entities.UserPK[ codeuser=" + codeuser + ", codeperson=" + codeperson + " ]";
    }
    
}
