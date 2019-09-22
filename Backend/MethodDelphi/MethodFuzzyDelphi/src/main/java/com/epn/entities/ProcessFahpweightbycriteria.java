/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
@Table(name = "processFahpweightbycriteria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcessFahpweightbycriteria.findAll", query = "SELECT p FROM ProcessFahpweightbycriteria p"),
    @NamedQuery(name = "ProcessFahpweightbycriteria.findByCodefahp", query = "SELECT p FROM ProcessFahpweightbycriteria p WHERE p.processFahpweightbycriteriaPK.codefahp = :codefahp"),
    @NamedQuery(name = "ProcessFahpweightbycriteria.findByCodePerson", query = "SELECT p FROM ProcessFahpweightbycriteria p WHERE p.processFahpweightbycriteriaPK.codePerson = :codePerson"),
    @NamedQuery(name = "ProcessFahpweightbycriteria.findByCodeCriteria", query = "SELECT p FROM ProcessFahpweightbycriteria p WHERE p.processFahpweightbycriteriaPK.codeCriteria = :codeCriteria"),
    @NamedQuery(name = "ProcessFahpweightbycriteria.findByWeight", query = "SELECT p FROM ProcessFahpweightbycriteria p WHERE p.weight = :weight"),
    @NamedQuery(name = "ProcessFahpweightbycriteria.findByDateCreate", query = "SELECT p FROM ProcessFahpweightbycriteria p WHERE p.dateCreate = :dateCreate"),
    @NamedQuery(name = "ProcessFahpweightbycriteria.findByDateLastModify", query = "SELECT p FROM ProcessFahpweightbycriteria p WHERE p.dateLastModify = :dateLastModify"),
    @NamedQuery(name = "ProcessFahpweightbycriteria.findByUserCreate", query = "SELECT p FROM ProcessFahpweightbycriteria p WHERE p.userCreate = :userCreate"),
    @NamedQuery(name = "ProcessFahpweightbycriteria.findByUserLastModify", query = "SELECT p FROM ProcessFahpweightbycriteria p WHERE p.userLastModify = :userLastModify")})
public class ProcessFahpweightbycriteria implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProcessFahpweightbycriteriaPK processFahpweightbycriteriaPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "weight")
    private BigDecimal weight;
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
    @JoinColumn(name = "codeCriteria", referencedColumnName = "codeCriteria", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Criteria criteria;

    public ProcessFahpweightbycriteria() {
    }

    public ProcessFahpweightbycriteria(ProcessFahpweightbycriteriaPK processFahpweightbycriteriaPK) {
        this.processFahpweightbycriteriaPK = processFahpweightbycriteriaPK;
    }

    public ProcessFahpweightbycriteria(ProcessFahpweightbycriteriaPK processFahpweightbycriteriaPK, BigDecimal weight, Date dateCreate, Date dateLastModify, long userCreate, long userLastModify) {
        this.processFahpweightbycriteriaPK = processFahpweightbycriteriaPK;
        this.weight = weight;
        this.dateCreate = dateCreate;
        this.dateLastModify = dateLastModify;
        this.userCreate = userCreate;
        this.userLastModify = userLastModify;
    }

    public ProcessFahpweightbycriteria(long codefahp, long codePerson, long codeCriteria) {
        this.processFahpweightbycriteriaPK = new ProcessFahpweightbycriteriaPK(codefahp, codePerson, codeCriteria);
    }

    public ProcessFahpweightbycriteriaPK getProcessFahpweightbycriteriaPK() {
        return processFahpweightbycriteriaPK;
    }

    public void setProcessFahpweightbycriteriaPK(ProcessFahpweightbycriteriaPK processFahpweightbycriteriaPK) {
        this.processFahpweightbycriteriaPK = processFahpweightbycriteriaPK;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
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

    public Criteria getCriteria() {
        return criteria;
    }

    public void setCriteria(Criteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (processFahpweightbycriteriaPK != null ? processFahpweightbycriteriaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcessFahpweightbycriteria)) {
            return false;
        }
        ProcessFahpweightbycriteria other = (ProcessFahpweightbycriteria) object;
        if ((this.processFahpweightbycriteriaPK == null && other.processFahpweightbycriteriaPK != null) || (this.processFahpweightbycriteriaPK != null && !this.processFahpweightbycriteriaPK.equals(other.processFahpweightbycriteriaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.entities.ProcessFahpweightbycriteria[ processFahpweightbycriteriaPK=" + processFahpweightbycriteriaPK + " ]";
    }
    
}
