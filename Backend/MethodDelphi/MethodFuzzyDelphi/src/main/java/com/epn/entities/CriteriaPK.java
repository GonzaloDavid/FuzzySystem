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
public class CriteriaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "codeCriteria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codeCriteria;

    public CriteriaPK() {
    }

    public CriteriaPK(long codeCriteria) {
        this.codeCriteria = codeCriteria;
    }

    public long getCodeCriteria() {
        return codeCriteria;
    }

    public void setCodeCriteria(long codeCriteria) {
        this.codeCriteria = codeCriteria;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (int) (this.codeCriteria ^ (this.codeCriteria >>> 32));
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
        final CriteriaPK other = (CriteriaPK) obj;
        if (this.codeCriteria != other.codeCriteria) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CriteriaPK{" + "codeCriteria=" + codeCriteria + '}';
    }

}
