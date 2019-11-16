/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author david
 */
@Entity
@Table(name = "FAHP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fahp.findAll", query = "SELECT f FROM Fahp f"),
    @NamedQuery(name = "Fahp.findByCodefahp", query = "SELECT f FROM Fahp f WHERE f.fahpPK.codefahp = :codefahp"),
    @NamedQuery(name = "Fahp.findByDateCreate", query = "SELECT f FROM Fahp f WHERE f.dateCreate = :dateCreate"),
    @NamedQuery(name = "Fahp.findByDateLastModify", query = "SELECT f FROM Fahp f WHERE f.dateLastModify = :dateLastModify"),
    @NamedQuery(name = "Fahp.findByUserCreate", query = "SELECT f FROM Fahp f WHERE f.userCreate = :userCreate"),
    @NamedQuery(name = "Fahp.findByUserLastModify", query = "SELECT f FROM Fahp f WHERE f.userLastModify = :userLastModify")})
public class Fahp implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FahpPK fahpPK;

    @Column(name = "statusfahpCat")
    private String statusfahpCatt;
    @Column(name = "statusfahp")
    private String statusfahp;
    @Column(name = "valueFAHPCat")
    private String valueFAHPCat;
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
    @JoinColumn(name = "statusfahpCat", referencedColumnName = "code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Catalogue statusfahpCat;
    @JoinColumns({
        @JoinColumn(name = "statusfahpCat", referencedColumnName = "codeCatalogue", insertable = false, updatable = false),
        @JoinColumn(name = "statusfahp", referencedColumnName = "codeItem", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Catalogueitem catalogueitem;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fahp")
    private List<Surveybycodefahp> surveybycodefahpList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fahp")
    private List<Criteriabycodefahp> criteriabycodefahpList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fahp")
    private List<AttributesMatrixValue> attributesMatrixValueList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fahp")
    private List<CriteriaMatrixValue> criteriaMatrixValueList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fahp")
    private List<Sentemailbycodefahp> sentemailbycodefahp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fahp")
    private List<AttributesMatrixAverageValue> attributesMatrixAverageValueList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fahp")
    private List<CriteriaMatrixAverageValue> criteriaMatrixAverageValueList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fahp")
    private List<ProcessFahpconsistencybycriteria> processFahpconsistencybycriteriaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fahp")
    private List<ResultFAHP> resultFAHPList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fahp")
    private List<ProcessFahpatributebycriteria> processFahpatributebycriteriaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fahp")
    private List<ProcessFahpweightbycriteria> processFahpweightbycriteriaList;

    public Fahp() {
    }

    public Fahp(FahpPK fahpPK) {
        this.fahpPK = fahpPK;
    }

    public Fahp(FahpPK fahpPK, Date dateCreate, Date dateLastModify, long userCreate, long userLastModify, Catalogue statusfahpCat) {
        this.fahpPK = fahpPK;
        this.dateCreate = dateCreate;
        this.dateLastModify = dateLastModify;
        this.userCreate = userCreate;
        this.userLastModify = userLastModify;
    }

    public FahpPK getFahpPK() {
        return fahpPK;
    }

    public void setFahpPK(FahpPK fahpPK) {
        this.fahpPK = fahpPK;
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

    public Catalogue getStatusfahpCat() {
        return statusfahpCat;
    }

    public void setStatusfahpCat(Catalogue statusfahpCat) {
        this.statusfahpCat = statusfahpCat;
    }

    public Catalogueitem getCatalogueitem() {
        return catalogueitem;
    }

    public void setCatalogueitem(Catalogueitem catalogueitem) {
        this.catalogueitem = catalogueitem;
    }

    public String getStatusfahpCatt() {
        return statusfahpCatt;
    }

    public void setStatusfahpCatt(String statusfahpCatt) {
        this.statusfahpCatt = statusfahpCatt;
    }

    public String getStatusfahp() {
        return statusfahp;
    }

    public void setStatusfahp(String statusfahp) {
        this.statusfahp = statusfahp;
    }

    public String getValueFAHPCat() {
        return valueFAHPCat;
    }

    public void setValueFAHPCat(String valueFAHPCat) {
        this.valueFAHPCat = valueFAHPCat;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.fahpPK);
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
        final Fahp other = (Fahp) obj;
        if (!Objects.equals(this.fahpPK, other.fahpPK)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fahp{" + "fahpPK=" + fahpPK + '}';
    }

    @XmlTransient
    public List<Surveybycodefahp> getSurveybycodefahpList() {
        return surveybycodefahpList;
    }

    public void setSurveybycodefahpList(List<Surveybycodefahp> surveybycodefahpList) {
        this.surveybycodefahpList = surveybycodefahpList;
    }

    @XmlTransient
    public List<Criteriabycodefahp> getCriteriabycodefahpList() {
        return criteriabycodefahpList;
    }

    public void setCriteriabycodefahpList(List<Criteriabycodefahp> criteriabycodefahpList) {
        this.criteriabycodefahpList = criteriabycodefahpList;
    }

    @XmlTransient
    public List<AttributesMatrixValue> getAttributesMatrixValueList() {
        return attributesMatrixValueList;
    }

    public void setAttributesMatrixValueList(List<AttributesMatrixValue> attributesMatrixValueList) {
        this.attributesMatrixValueList = attributesMatrixValueList;
    }

    @XmlTransient
    public List<CriteriaMatrixValue> getCriteriaMatrixValueList() {
        return criteriaMatrixValueList;
    }

    public void setCriteriaMatrixValueList(List<CriteriaMatrixValue> criteriaMatrixValueList) {
        this.criteriaMatrixValueList = criteriaMatrixValueList;
    }

    @XmlTransient
    public List<Sentemailbycodefahp> getSentemailbycodefahp() {
        return sentemailbycodefahp;
    }

    public void setSentemailbycodefahp(List<Sentemailbycodefahp> sentemailbycodefahp) {
        this.sentemailbycodefahp = sentemailbycodefahp;
    }

    @XmlTransient
    public List<AttributesMatrixAverageValue> getAttributesMatrixAverageValueList() {
        return attributesMatrixAverageValueList;
    }

    public void setAttributesMatrixAverageValueList(List<AttributesMatrixAverageValue> attributesMatrixAverageValueList) {
        this.attributesMatrixAverageValueList = attributesMatrixAverageValueList;
    }

    @XmlTransient
    public List<CriteriaMatrixAverageValue> getCriteriaMatrixAverageValueList() {
        return criteriaMatrixAverageValueList;
    }

    public void setCriteriaMatrixAverageValueList(List<CriteriaMatrixAverageValue> criteriaMatrixAverageValueList) {
        this.criteriaMatrixAverageValueList = criteriaMatrixAverageValueList;
    }

    @XmlTransient
    public List<ProcessFahpconsistencybycriteria> getProcessFahpconsistencybycriteriaList() {
        return processFahpconsistencybycriteriaList;
    }

    public void setProcessFahpconsistencybycriteriaList(List<ProcessFahpconsistencybycriteria> processFahpconsistencybycriteriaList) {
        this.processFahpconsistencybycriteriaList = processFahpconsistencybycriteriaList;
    }

    @XmlTransient
    public List<ResultFAHP> getResultFAHPList() {
        return resultFAHPList;
    }

    public void setResultFAHPList(List<ResultFAHP> resultFAHPList) {
        this.resultFAHPList = resultFAHPList;
    }

    @XmlTransient
    public List<ProcessFahpatributebycriteria> getProcessFahpatributebycriteriaList() {
        return processFahpatributebycriteriaList;
    }

    public void setProcessFahpatributebycriteriaList(List<ProcessFahpatributebycriteria> processFahpatributebycriteriaList) {
        this.processFahpatributebycriteriaList = processFahpatributebycriteriaList;
    }

    @XmlTransient
    public List<ProcessFahpweightbycriteria> getProcessFahpweightbycriteriaList() {
        return processFahpweightbycriteriaList;
    }

    public void setProcessFahpweightbycriteriaList(List<ProcessFahpweightbycriteria> processFahpweightbycriteriaList) {
        this.processFahpweightbycriteriaList = processFahpweightbycriteriaList;
    }

}
