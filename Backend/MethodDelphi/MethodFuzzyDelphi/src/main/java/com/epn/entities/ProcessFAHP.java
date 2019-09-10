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
@Table(name = "processFAHP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcessFAHP.findAll", query = "SELECT p FROM ProcessFAHP p"),
    @NamedQuery(name = "ProcessFAHP.findByCodeCriteria", query = "SELECT p FROM ProcessFAHP p WHERE p.processFAHPPK.codeCriteria = :codeCriteria"),
    @NamedQuery(name = "ProcessFAHP.findByCodeQuiz", query = "SELECT p FROM ProcessFAHP p WHERE p.processFAHPPK.codeQuiz = :codeQuiz"),
    @NamedQuery(name = "ProcessFAHP.findByCodeQuestions", query = "SELECT p FROM ProcessFAHP p WHERE p.processFAHPPK.codeQuestions = :codeQuestions"),
    @NamedQuery(name = "ProcessFAHP.findByIndexConsistency", query = "SELECT p FROM ProcessFAHP p WHERE p.indexConsistency = :indexConsistency"),
    @NamedQuery(name = "ProcessFAHP.findByRatioConsistency", query = "SELECT p FROM ProcessFAHP p WHERE p.ratioConsistency = :ratioConsistency"),
    @NamedQuery(name = "ProcessFAHP.findByConsistency", query = "SELECT p FROM ProcessFAHP p WHERE p.consistency = :consistency"),
    @NamedQuery(name = "ProcessFAHP.findByDateCreate", query = "SELECT p FROM ProcessFAHP p WHERE p.dateCreate = :dateCreate"),
    @NamedQuery(name = "ProcessFAHP.findByDateLastModify", query = "SELECT p FROM ProcessFAHP p WHERE p.dateLastModify = :dateLastModify"),
    @NamedQuery(name = "ProcessFAHP.findByUserCreate", query = "SELECT p FROM ProcessFAHP p WHERE p.userCreate = :userCreate"),
    @NamedQuery(name = "ProcessFAHP.findByUserLastModify", query = "SELECT p FROM ProcessFAHP p WHERE p.userLastModify = :userLastModify")})
public class ProcessFAHP implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProcessFAHPPK processFAHPPK;
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
    @JoinColumns({
        @JoinColumn(name = "statusresultFAHPcat", referencedColumnName = "codeCatalogue"),
        @JoinColumn(name = "statusresultFAHP", referencedColumnName = "codeItem")})
    @ManyToOne(optional = false)
    private Catalogueitem catalogueitem;
    @JoinColumn(name = "codeCriteria", referencedColumnName = "codeCriteria", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CriteriaFAHP criteriaFAHP;

    public ProcessFAHP() {
    }

    public ProcessFAHP(ProcessFAHPPK processFAHPPK) {
        this.processFAHPPK = processFAHPPK;
    }

    public ProcessFAHP(ProcessFAHPPK processFAHPPK, BigDecimal indexConsistency, BigDecimal ratioConsistency, BigDecimal consistency, Date dateCreate, Date dateLastModify, long userCreate, long userLastModify) {
        this.processFAHPPK = processFAHPPK;
        this.indexConsistency = indexConsistency;
        this.ratioConsistency = ratioConsistency;
        this.consistency = consistency;
        this.dateCreate = dateCreate;
        this.dateLastModify = dateLastModify;
        this.userCreate = userCreate;
        this.userLastModify = userLastModify;
    }

    public ProcessFAHP(long codeCriteria, long codeQuiz, long codeQuestions) {
        this.processFAHPPK = new ProcessFAHPPK(codeCriteria, codeQuiz, codeQuestions);
    }

    public ProcessFAHPPK getProcessFAHPPK() {
        return processFAHPPK;
    }

    public void setProcessFAHPPK(ProcessFAHPPK processFAHPPK) {
        this.processFAHPPK = processFAHPPK;
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

    public Catalogueitem getCatalogueitem() {
        return catalogueitem;
    }

    public void setCatalogueitem(Catalogueitem catalogueitem) {
        this.catalogueitem = catalogueitem;
    }

    public CriteriaFAHP getCriteriaFAHP() {
        return criteriaFAHP;
    }

    public void setCriteriaFAHP(CriteriaFAHP criteriaFAHP) {
        this.criteriaFAHP = criteriaFAHP;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (processFAHPPK != null ? processFAHPPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcessFAHP)) {
            return false;
        }
        ProcessFAHP other = (ProcessFAHP) object;
        if ((this.processFAHPPK == null && other.processFAHPPK != null) || (this.processFAHPPK != null && !this.processFAHPPK.equals(other.processFAHPPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.entities.ProcessFAHP[ processFAHPPK=" + processFAHPPK + " ]";
    }
    
}
