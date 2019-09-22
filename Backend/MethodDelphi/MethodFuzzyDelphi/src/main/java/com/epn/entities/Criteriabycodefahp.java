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
@Table(name = "criteriabycodefahp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Criteriabycodefahp.findAll", query = "SELECT c FROM Criteriabycodefahp c"),
    @NamedQuery(name = "Criteriabycodefahp.findByCodefahp", query = "SELECT c FROM Criteriabycodefahp c WHERE c.criteriabycodefahpPK.codefahp = :codefahp"),
    @NamedQuery(name = "Criteriabycodefahp.findByCodeCriteria", query = "SELECT c FROM Criteriabycodefahp c WHERE c.criteriabycodefahpPK.codeCriteria = :codeCriteria"),
    @NamedQuery(name = "Criteriabycodefahp.findByDateCreate", query = "SELECT c FROM Criteriabycodefahp c WHERE c.dateCreate = :dateCreate"),
    @NamedQuery(name = "Criteriabycodefahp.findByDateLastModify", query = "SELECT c FROM Criteriabycodefahp c WHERE c.dateLastModify = :dateLastModify"),
    @NamedQuery(name = "Criteriabycodefahp.findByUserCreate", query = "SELECT c FROM Criteriabycodefahp c WHERE c.userCreate = :userCreate"),
    @NamedQuery(name = "Criteriabycodefahp.findByUserLastModify", query = "SELECT c FROM Criteriabycodefahp c WHERE c.userLastModify = :userLastModify")})
public class Criteriabycodefahp implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CriteriabycodefahpPK criteriabycodefahpPK;
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
    @JoinColumn(name = "codeCriteria", referencedColumnName = "codeCriteria", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Criteria criteria;

    public Criteriabycodefahp() {
    }

    public Criteriabycodefahp(CriteriabycodefahpPK criteriabycodefahpPK) {
        this.criteriabycodefahpPK = criteriabycodefahpPK;
    }

    public Criteriabycodefahp(CriteriabycodefahpPK criteriabycodefahpPK, Date dateCreate, Date dateLastModify, long userCreate, long userLastModify) {
        this.criteriabycodefahpPK = criteriabycodefahpPK;
        this.dateCreate = dateCreate;
        this.dateLastModify = dateLastModify;
        this.userCreate = userCreate;
        this.userLastModify = userLastModify;
    }

    public Criteriabycodefahp(long codefahp, long codeCriteria) {
        this.criteriabycodefahpPK = new CriteriabycodefahpPK(codefahp, codeCriteria);
    }

    public CriteriabycodefahpPK getCriteriabycodefahpPK() {
        return criteriabycodefahpPK;
    }

    public void setCriteriabycodefahpPK(CriteriabycodefahpPK criteriabycodefahpPK) {
        this.criteriabycodefahpPK = criteriabycodefahpPK;
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

    public Criteria getCriteria() {
        return criteria;
    }

    public void setCriteria(Criteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (criteriabycodefahpPK != null ? criteriabycodefahpPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Criteriabycodefahp)) {
            return false;
        }
        Criteriabycodefahp other = (Criteriabycodefahp) object;
        if ((this.criteriabycodefahpPK == null && other.criteriabycodefahpPK != null) || (this.criteriabycodefahpPK != null && !this.criteriabycodefahpPK.equals(other.criteriabycodefahpPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.entities.Criteriabycodefahp[ criteriabycodefahpPK=" + criteriabycodefahpPK + " ]";
    }
    
}
