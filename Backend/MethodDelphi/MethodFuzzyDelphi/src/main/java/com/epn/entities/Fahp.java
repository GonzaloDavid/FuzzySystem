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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
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
    @JoinColumn(name = "statusfahpCat", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private Catalogue statusfahpCat;
    @JoinColumns({
        @JoinColumn(name = "statusfahpCat", referencedColumnName = "codeCatalogue"),
        @JoinColumn(name = "statusfahp", referencedColumnName = "codeItem")})
    @ManyToOne(optional = false)
    private Catalogueitem catalogueitem;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fahp")
    private List<ResultFAHP> resultFAHPList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fahp")
    private List<ProcessFahpconsistencybycriteria> processFahpconsistencybycriteriaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fahp")
    private List<Sentemailbycodefahp> sentemailbycodefahpList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fahp")
    private List<Surveybycodefahp> surveybycodefahpList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fahp")
    private List<Criteriabycodefahp> criteriabycodefahpList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fahp")
    private List<ProcessFahpatributebycriteria> processFahpatributebycriteriaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fahp")
    private List<ProcessFahpweightbycriteria> processFahpweightbycriteriaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fahp")
    private List<CriteriaMatrixValue> criteriaMatrixValueList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fahp")
    private List<AttributesMatrixValue> attributesMatrixValueList;

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
        this.statusfahpCat = statusfahpCat;
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

    @XmlTransient
    public List<ResultFAHP> getResultFAHPList() {
        return resultFAHPList;
    }

    public void setResultFAHPList(List<ResultFAHP> resultFAHPList) {
        this.resultFAHPList = resultFAHPList;
    }

    @XmlTransient
    public List<ProcessFahpconsistencybycriteria> getProcessFahpconsistencybycriteriaList() {
        return processFahpconsistencybycriteriaList;
    }

    public void setProcessFahpconsistencybycriteriaList(List<ProcessFahpconsistencybycriteria> processFahpconsistencybycriteriaList) {
        this.processFahpconsistencybycriteriaList = processFahpconsistencybycriteriaList;
    }

    @XmlTransient
    public List<Sentemailbycodefahp> getSentemailbycodefahpList() {
        return sentemailbycodefahpList;
    }

    public void setSentemailbycodefahpList(List<Sentemailbycodefahp> sentemailbycodefahpList) {
        this.sentemailbycodefahpList = sentemailbycodefahpList;
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

    @XmlTransient
    public List<CriteriaMatrixValue> getCriteriaMatrixValueList() {
        return criteriaMatrixValueList;
    }

    public void setCriteriaMatrixValueList(List<CriteriaMatrixValue> criteriaMatrixValueList) {
        this.criteriaMatrixValueList = criteriaMatrixValueList;
    }

    @XmlTransient
    public List<AttributesMatrixValue> getAttributesMatrixValueList() {
        return attributesMatrixValueList;
    }

    public void setAttributesMatrixValueList(List<AttributesMatrixValue> attributesMatrixValueList) {
        this.attributesMatrixValueList = attributesMatrixValueList;
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
    
}
