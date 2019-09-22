/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@Table(name = "criteriaMatrixValue")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CriteriaMatrixValue.findAll", query = "SELECT c FROM CriteriaMatrixValue c"),
    @NamedQuery(name = "CriteriaMatrixValue.findByCodefahp", query = "SELECT c FROM CriteriaMatrixValue c WHERE c.criteriaMatrixValuePK.codefahp = :codefahp"),
    @NamedQuery(name = "CriteriaMatrixValue.findByCodePerson", query = "SELECT c FROM CriteriaMatrixValue c WHERE c.criteriaMatrixValuePK.codePerson = :codePerson"),
    @NamedQuery(name = "CriteriaMatrixValue.findByCodeCriteria", query = "SELECT c FROM CriteriaMatrixValue c WHERE c.criteriaMatrixValuePK.codeCriteria = :codeCriteria"),
    @NamedQuery(name = "CriteriaMatrixValue.findByCodeCriteriaCouple", query = "SELECT c FROM CriteriaMatrixValue c WHERE c.criteriaMatrixValuePK.codeCriteriaCouple = :codeCriteriaCouple"),
    @NamedQuery(name = "CriteriaMatrixValue.findByDateCreate", query = "SELECT c FROM CriteriaMatrixValue c WHERE c.dateCreate = :dateCreate"),
    @NamedQuery(name = "CriteriaMatrixValue.findByDateLastModify", query = "SELECT c FROM CriteriaMatrixValue c WHERE c.dateLastModify = :dateLastModify"),
    @NamedQuery(name = "CriteriaMatrixValue.findByUserCreate", query = "SELECT c FROM CriteriaMatrixValue c WHERE c.userCreate = :userCreate"),
    @NamedQuery(name = "CriteriaMatrixValue.findByUserLastModify", query = "SELECT c FROM CriteriaMatrixValue c WHERE c.userLastModify = :userLastModify")})
public class CriteriaMatrixValue implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CriteriaMatrixValuePK criteriaMatrixValuePK;
    @Basic(optional = false)
    @Column(name = "dateCreate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;
    @Basic(optional = false)
    @Column(name = "dateLastModify")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateLastModify;
    @Basic(optional = false)
    @Column(name = "userCreate")
    private long userCreate;
    @Basic(optional = false)
    @Column(name = "userLastModify")
    private long userLastModify;
    @JoinColumn(name = "codefahp", referencedColumnName = "codefahp", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Fahp fahp;
    @JoinColumn(name = "codePerson", referencedColumnName = "codePerson", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Person person;
    @JoinColumn(name = "valuecriteriaFAHPCat", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private Catalogue valuecriteriaFAHPCat;
    @JoinColumns({
        @JoinColumn(name = "valuecriteriaFAHPCat", referencedColumnName = "codeCatalogue"),
        @JoinColumn(name = "valuecriteriaFAHP", referencedColumnName = "codeItem")})
    @ManyToOne(optional = false)
    private Catalogueitem catalogueitem;
    @JoinColumn(name = "codeCriteria", referencedColumnName = "codeCriteria", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Criteria criteria;

    public CriteriaMatrixValue() {
    }

    public CriteriaMatrixValue(CriteriaMatrixValuePK criteriaMatrixValuePK) {
        this.criteriaMatrixValuePK = criteriaMatrixValuePK;
    }

    public CriteriaMatrixValue(CriteriaMatrixValuePK criteriaMatrixValuePK, Date dateCreate, Date dateLastModify, long userCreate, long userLastModify) {
        this.criteriaMatrixValuePK = criteriaMatrixValuePK;
        this.dateCreate = dateCreate;
        this.dateLastModify = dateLastModify;
        this.userCreate = userCreate;
        this.userLastModify = userLastModify;
    }

    public CriteriaMatrixValue(long codefahp, long codePerson, long codeCriteria, long codeCriteriaCouple) {
        this.criteriaMatrixValuePK = new CriteriaMatrixValuePK(codefahp, codePerson, codeCriteria, codeCriteriaCouple);
    }

    public CriteriaMatrixValuePK getCriteriaMatrixValuePK() {
        return criteriaMatrixValuePK;
    }

    public void setCriteriaMatrixValuePK(CriteriaMatrixValuePK criteriaMatrixValuePK) {
        this.criteriaMatrixValuePK = criteriaMatrixValuePK;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateLastModify() {
        return dateLastModify;
    }

    public void setDateLastModify(Date dateLastModify) {
        this.dateLastModify = dateLastModify;
    }

    public long getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(long userCreate) {
        this.userCreate = userCreate;
    }

    public long getUserLastModify() {
        return userLastModify;
    }

    public void setUserLastModify(long userLastModify) {
        this.userLastModify = userLastModify;
    }

    public Fahp getFahp() {
        return fahp;
    }

    public void setFahp(Fahp fahp) {
        this.fahp = fahp;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Catalogue getValuecriteriaFAHPCat() {
        return valuecriteriaFAHPCat;
    }

    public void setValuecriteriaFAHPCat(Catalogue valuecriteriaFAHPCat) {
        this.valuecriteriaFAHPCat = valuecriteriaFAHPCat;
    }

    public Catalogueitem getCatalogueitem() {
        return catalogueitem;
    }

    public void setCatalogueitem(Catalogueitem catalogueitem) {
        this.catalogueitem = catalogueitem;
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
        hash += (criteriaMatrixValuePK != null ? criteriaMatrixValuePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CriteriaMatrixValue)) {
            return false;
        }
        CriteriaMatrixValue other = (CriteriaMatrixValue) object;
        if ((this.criteriaMatrixValuePK == null && other.criteriaMatrixValuePK != null) || (this.criteriaMatrixValuePK != null && !this.criteriaMatrixValuePK.equals(other.criteriaMatrixValuePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.entities.CriteriaMatrixValue[ criteriaMatrixValuePK=" + criteriaMatrixValuePK + " ]";
    }
    
}
