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

/**
 *
 * @author david
 */
@Embeddable
public class FahpPK implements Serializable {
    
    @Basic(optional = false)
    @Column(name = "codefahp")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codefahp;

    public FahpPK() {
    }

    public FahpPK(long codefahp) {
        this.codefahp = codefahp;
    }

    public long getCodefahp() {
        return codefahp;
    }

    public void setCodefahp(long codefahp) {
        this.codefahp = codefahp;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (int) (this.codefahp ^ (this.codefahp >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FahpPK other = (FahpPK) obj;
        if (this.codefahp != other.codefahp) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FahpPK{" + "codefahp=" + codefahp + '}';
    }
    
}
