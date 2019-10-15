/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@Table(name = "criteriaMatrixAverageValue")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CriteriaMatrixAverageValue.findAll", query = "SELECT c FROM CriteriaMatrixAverageValue c"),
    @NamedQuery(name = "CriteriaMatrixAverageValue.findByCodefahp", query = "SELECT c FROM CriteriaMatrixAverageValue c WHERE c.criteriaMatrixAverageValuePK.codefahp = :codefahp"),
    @NamedQuery(name = "CriteriaMatrixAverageValue.findByCodeCriteria", query = "SELECT c FROM CriteriaMatrixAverageValue c WHERE c.criteriaMatrixAverageValuePK.codeCriteria = :codeCriteria"),
    @NamedQuery(name = "CriteriaMatrixAverageValue.findByCodeCriteriaCouple", query = "SELECT c FROM CriteriaMatrixAverageValue c WHERE c.criteriaMatrixAverageValuePK.codeCriteriaCouple = :codeCriteriaCouple"),
    @NamedQuery(name = "CriteriaMatrixAverageValue.findByValuecriteriaFAHP", query = "SELECT c FROM CriteriaMatrixAverageValue c WHERE c.valuecriteriaFAHP = :valuecriteriaFAHP")})
public class CriteriaMatrixAverageValue implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CriteriaMatrixAverageValuePK criteriaMatrixAverageValuePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "valuecriteriaFAHP")
    private String valuecriteriaFAHP;
    @JoinColumn(name = "codefahp", referencedColumnName = "codefahp", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Fahp fahp;
    @JoinColumn(name = "valuecriteriaFAHPCat", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private Catalogue valuecriteriaFAHPCat;
    @JoinColumn(name = "codeCriteria", referencedColumnName = "codeCriteria", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Criteria criteria;

    public CriteriaMatrixAverageValue() {
    }

    public CriteriaMatrixAverageValue(CriteriaMatrixAverageValuePK criteriaMatrixAverageValuePK) {
        this.criteriaMatrixAverageValuePK = criteriaMatrixAverageValuePK;
    }

    public CriteriaMatrixAverageValue(CriteriaMatrixAverageValuePK criteriaMatrixAverageValuePK, String valuecriteriaFAHP) {
        this.criteriaMatrixAverageValuePK = criteriaMatrixAverageValuePK;
        this.valuecriteriaFAHP = valuecriteriaFAHP;
    }

    public CriteriaMatrixAverageValue(long codefahp, long codeCriteria, long codeCriteriaCouple) {
        this.criteriaMatrixAverageValuePK = new CriteriaMatrixAverageValuePK(codefahp, codeCriteria, codeCriteriaCouple);
    }

    public CriteriaMatrixAverageValuePK getCriteriaMatrixAverageValuePK() {
        return criteriaMatrixAverageValuePK;
    }

    public void setCriteriaMatrixAverageValuePK(CriteriaMatrixAverageValuePK criteriaMatrixAverageValuePK) {
        this.criteriaMatrixAverageValuePK = criteriaMatrixAverageValuePK;
    }

    public String getValuecriteriaFAHP() {
        return valuecriteriaFAHP;
    }

    public void setValuecriteriaFAHP(String valuecriteriaFAHP) {
        this.valuecriteriaFAHP = valuecriteriaFAHP;
    }

    public Fahp getFahp() {
        return fahp;
    }

    public void setFahp(Fahp fahp) {
        this.fahp = fahp;
    }

    public Catalogue getValuecriteriaFAHPCat() {
        return valuecriteriaFAHPCat;
    }

    public void setValuecriteriaFAHPCat(Catalogue valuecriteriaFAHPCat) {
        this.valuecriteriaFAHPCat = valuecriteriaFAHPCat;
    }

    public Criteria getCriteria() {
        return criteria;
    }

    public void setCriteria(Criteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (criteriaMatrixAverageValuePK != null ? criteriaMatrixAverageValuePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CriteriaMatrixAverageValue)) {
            return false;
        }
        CriteriaMatrixAverageValue other = (CriteriaMatrixAverageValue) object;
        if ((this.criteriaMatrixAverageValuePK == null && other.criteriaMatrixAverageValuePK != null) || (this.criteriaMatrixAverageValuePK != null && !this.criteriaMatrixAverageValuePK.equals(other.criteriaMatrixAverageValuePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.entities.CriteriaMatrixAverageValue[ criteriaMatrixAverageValuePK=" + criteriaMatrixAverageValuePK + " ]";
    }
    
}
