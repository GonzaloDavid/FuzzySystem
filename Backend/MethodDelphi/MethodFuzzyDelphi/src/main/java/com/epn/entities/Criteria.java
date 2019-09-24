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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author david
 */
@Entity
@Table(name = "criteria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Criteria.findAll", query = "SELECT c FROM Criteria c"),
    @NamedQuery(name = "Criteria.findByCodeCriteria", query = "SELECT c FROM Criteria c WHERE c.criteriaPK.codeCriteria = :codeCriteria"),
    @NamedQuery(name = "Criteria.findByNameCriteria", query = "SELECT c FROM Criteria c WHERE c.nameCriteria = :nameCriteria"),
    @NamedQuery(name = "Criteria.findByDescriptionCriteria", query = "SELECT c FROM Criteria c WHERE c.descriptionCriteria = :descriptionCriteria"),
    @NamedQuery(name = "Criteria.findByDateCreate", query = "SELECT c FROM Criteria c WHERE c.dateCreate = :dateCreate"),
    @NamedQuery(name = "Criteria.findByDateLastModify", query = "SELECT c FROM Criteria c WHERE c.dateLastModify = :dateLastModify"),
    @NamedQuery(name = "Criteria.findByUserCreate", query = "SELECT c FROM Criteria c WHERE c.userCreate = :userCreate"),
    @NamedQuery(name = "Criteria.findByUserLastModify", query = "SELECT c FROM Criteria c WHERE c.userLastModify = :userLastModify")})
public class Criteria implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CriteriaPK criteriaPK;
    @Basic(optional = false)
    @Column(name = "nameCriteria")
    private String nameCriteria;
    @Basic(optional = false)
    @Column(name = "descriptionCriteria")
    private String descriptionCriteria;
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
    

    public Criteria() {
    }

    public Criteria(CriteriaPK criteriaPK) {
        this.criteriaPK = criteriaPK;
    }

    public Criteria(CriteriaPK criteriaPK, String nameCriteria, String descriptionCriteria, Date dateCreate, Date dateLastModify, long userCreate, long userLastModify, List<Criteriabycodefahp> criteriabycodefahpList, List<ProcessFahpatributebycriteria> processFahpatributebycriteriaList, List<ProcessFahpweightbycriteria> processFahpweightbycriteriaList, List<CriteriaMatrixValue> criteriaMatrixValueList) {
        this.criteriaPK = criteriaPK;
        this.nameCriteria = nameCriteria;
        this.descriptionCriteria = descriptionCriteria;
        this.dateCreate = dateCreate;
        this.dateLastModify = dateLastModify;
        this.userCreate = userCreate;
        this.userLastModify = userLastModify;
    }

    public CriteriaPK getCriteriaPK() {
        return criteriaPK;
    }

    public void setCriteriaPK(CriteriaPK criteriaPK) {
        this.criteriaPK = criteriaPK;
    }

    public String getNameCriteria() {
        return nameCriteria;
    }

    public void setNameCriteria(String nameCriteria) {
        this.nameCriteria = nameCriteria;
    }

    public String getDescriptionCriteria() {
        return descriptionCriteria;
    }

    public void setDescriptionCriteria(String descriptionCriteria) {
        this.descriptionCriteria = descriptionCriteria;
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


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.criteriaPK);
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
        final Criteria other = (Criteria) obj;
        if (!Objects.equals(this.criteriaPK, other.criteriaPK)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Criteria{" + "criteriaPK=" + criteriaPK + '}';
    }
}
