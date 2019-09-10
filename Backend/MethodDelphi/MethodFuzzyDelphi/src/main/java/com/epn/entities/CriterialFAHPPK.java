/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.entities;

import java.io.Serializable;
import java.util.Objects;
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
public class CriterialFAHPPK implements Serializable {
    
    @Basic(optional = false)
    @Column(name = "codeCriteria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeCriteria;

    public CriterialFAHPPK() {
    }

    public CriterialFAHPPK(Long codeCriteria) {
        this.codeCriteria = codeCriteria;
    }

    public Long getCodeCriteria() {
        return codeCriteria;
    }

    public void setCodeCriteria(Long codeCriteria) {
        this.codeCriteria = codeCriteria;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.codeCriteria);
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
        final CriterialFAHPPK other = (CriterialFAHPPK) obj;
        if (!Objects.equals(this.codeCriteria, other.codeCriteria)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CriterialFAHPPK{" + "codeCriteria=" + codeCriteria + '}';
    }
    
}
