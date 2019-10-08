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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@Table(name = "processFahpconsistencybycriteria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcessFahpconsistencybycriteria.findAll", query = "SELECT p FROM ProcessFahpconsistencybycriteria p"),
    @NamedQuery(name = "ProcessFahpconsistencybycriteria.findByCodefahp", query = "SELECT p FROM ProcessFahpconsistencybycriteria p WHERE p.processFahpconsistencybycriteriaPK.codefahp = :codefahp"),
    @NamedQuery(name = "ProcessFahpconsistencybycriteria.findByCodePerson", query = "SELECT p FROM ProcessFahpconsistencybycriteria p WHERE p.processFahpconsistencybycriteriaPK.codePerson = :codePerson"),
    @NamedQuery(name = "ProcessFahpconsistencybycriteria.findByIndexConsistency", query = "SELECT p FROM ProcessFahpconsistencybycriteria p WHERE p.indexConsistency = :indexConsistency"),
    @NamedQuery(name = "ProcessFahpconsistencybycriteria.findByRatioConsistency", query = "SELECT p FROM ProcessFahpconsistencybycriteria p WHERE p.ratioConsistency = :ratioConsistency"),
    @NamedQuery(name = "ProcessFahpconsistencybycriteria.findByConsistency", query = "SELECT p FROM ProcessFahpconsistencybycriteria p WHERE p.consistency = :consistency"),
    @NamedQuery(name = "ProcessFahpconsistencybycriteria.findByDateCreate", query = "SELECT p FROM ProcessFahpconsistencybycriteria p WHERE p.dateCreate = :dateCreate"),
    @NamedQuery(name = "ProcessFahpconsistencybycriteria.findByDateLastModify", query = "SELECT p FROM ProcessFahpconsistencybycriteria p WHERE p.dateLastModify = :dateLastModify"),
    @NamedQuery(name = "ProcessFahpconsistencybycriteria.findByUserCreate", query = "SELECT p FROM ProcessFahpconsistencybycriteria p WHERE p.userCreate = :userCreate"),
    @NamedQuery(name = "ProcessFahpconsistencybycriteria.findByUserLastModify", query = "SELECT p FROM ProcessFahpconsistencybycriteria p WHERE p.userLastModify = :userLastModify")})
public class ProcessFahpconsistencybycriteria implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProcessFahpconsistencybycriteriaPK processFahpconsistencybycriteriaPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "indexConsistency")
    private BigDecimal indexConsistency;
    @Basic(optional = false)
    @Column(name = "ratioConsistency")
    private BigDecimal ratioConsistency;
    @Basic(optional = false)
    @Column(name = "consistency")
    private BigDecimal consistency;
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

    public ProcessFahpconsistencybycriteria() {
    }

    public ProcessFahpconsistencybycriteria(ProcessFahpconsistencybycriteriaPK processFahpconsistencybycriteriaPK) {
        this.processFahpconsistencybycriteriaPK = processFahpconsistencybycriteriaPK;
    }

    public ProcessFahpconsistencybycriteria(ProcessFahpconsistencybycriteriaPK processFahpconsistencybycriteriaPK, BigDecimal indexConsistency, BigDecimal ratioConsistency, BigDecimal consistency, Date dateCreate, Date dateLastModify, long userCreate, long userLastModify) {
        this.processFahpconsistencybycriteriaPK = processFahpconsistencybycriteriaPK;
        this.indexConsistency = indexConsistency;
        this.ratioConsistency = ratioConsistency;
        this.consistency = consistency;
        this.dateCreate = dateCreate;
        this.dateLastModify = dateLastModify;
        this.userCreate = userCreate;
        this.userLastModify = userLastModify;
    }

    public ProcessFahpconsistencybycriteria(long codefahp, long codePerson) {
        this.processFahpconsistencybycriteriaPK = new ProcessFahpconsistencybycriteriaPK(codefahp, codePerson);
    }

    public ProcessFahpconsistencybycriteriaPK getProcessFahpconsistencybycriteriaPK() {
        return processFahpconsistencybycriteriaPK;
    }

    public void setProcessFahpconsistencybycriteriaPK(ProcessFahpconsistencybycriteriaPK processFahpconsistencybycriteriaPK) {
        this.processFahpconsistencybycriteriaPK = processFahpconsistencybycriteriaPK;
    }

    public BigDecimal getIndexConsistency() {
        return indexConsistency;
    }

    public void setIndexConsistency(BigDecimal indexConsistency) {
        this.indexConsistency = indexConsistency;
    }

    public BigDecimal getRatioConsistency() {
        return ratioConsistency;
    }

    public void setRatioConsistency(BigDecimal ratioConsistency) {
        this.ratioConsistency = ratioConsistency;
    }

    public BigDecimal getConsistency() {
        return consistency;
    }

    public void setConsistency(BigDecimal consistency) {
        this.consistency = consistency;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (processFahpconsistencybycriteriaPK != null ? processFahpconsistencybycriteriaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcessFahpconsistencybycriteria)) {
            return false;
        }
        ProcessFahpconsistencybycriteria other = (ProcessFahpconsistencybycriteria) object;
        if ((this.processFahpconsistencybycriteriaPK == null && other.processFahpconsistencybycriteriaPK != null) || (this.processFahpconsistencybycriteriaPK != null && !this.processFahpconsistencybycriteriaPK.equals(other.processFahpconsistencybycriteriaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.entities.ProcessFahpconsistencybycriteria[ processFahpconsistencybycriteriaPK=" + processFahpconsistencybycriteriaPK + " ]";
    }
    
}
