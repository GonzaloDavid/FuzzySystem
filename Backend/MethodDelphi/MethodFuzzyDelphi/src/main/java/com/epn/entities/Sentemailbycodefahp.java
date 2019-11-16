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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@Table(name = "sentemailbycodefahp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sentemailbycodefahp.findAll", query = "SELECT s FROM Sentemailbycodefahp s"),
    @NamedQuery(name = "Sentemailbycodefahp.findByCodefahp", query = "SELECT s FROM Sentemailbycodefahp s WHERE s.sentemailbycodefahpPK.codefahp = :codefahp"),
    @NamedQuery(name = "Sentemailbycodefahp.findByCodePerson", query = "SELECT s FROM Sentemailbycodefahp s WHERE s.sentemailbycodefahpPK.codePerson = :codePerson"),
    @NamedQuery(name = "Sentemailbycodefahp.findByDateCreate", query = "SELECT s FROM Sentemailbycodefahp s WHERE s.dateCreate = :dateCreate"),
    @NamedQuery(name = "Sentemailbycodefahp.findByDateLastModify", query = "SELECT s FROM Sentemailbycodefahp s WHERE s.dateLastModify = :dateLastModify"),
    @NamedQuery(name = "Sentemailbycodefahp.findByUserCreate", query = "SELECT s FROM Sentemailbycodefahp s WHERE s.userCreate = :userCreate"),
    @NamedQuery(name = "Sentemailbycodefahp.findByUserLastModify", query = "SELECT s FROM Sentemailbycodefahp s WHERE s.userLastModify = :userLastModify")})
public class Sentemailbycodefahp implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SentemailbycodefahpPK sentemailbycodefahpPK;

    @Column(name = "statussentfahpCat")
    private String statussentfahpCatt;
    @Column(name = "statussentfahp")
    private String statussentfahp;
    @Column(name = "token")
    private String token;
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
    @JoinColumn(name = "statussentfahpCat", referencedColumnName = "code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Catalogue statussentfahpCat;
    @JoinColumns({
        @JoinColumn(name = "statussentfahpCat", referencedColumnName = "codeCatalogue", insertable = false, updatable = false),
        @JoinColumn(name = "statussentfahp", referencedColumnName = "codeItem", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Catalogueitem catalogueitem;

    public Sentemailbycodefahp() {
    }

    public Sentemailbycodefahp(SentemailbycodefahpPK sentemailbycodefahpPK) {
        this.sentemailbycodefahpPK = sentemailbycodefahpPK;
    }

    public Sentemailbycodefahp(SentemailbycodefahpPK sentemailbycodefahpPK, Date dateCreate, Date dateLastModify, long userCreate, long userLastModify) {
        this.sentemailbycodefahpPK = sentemailbycodefahpPK;
        this.dateCreate = dateCreate;
        this.dateLastModify = dateLastModify;
        this.userCreate = userCreate;
        this.userLastModify = userLastModify;
    }

    public Sentemailbycodefahp(long codefahp, long codePerson) {
        this.sentemailbycodefahpPK = new SentemailbycodefahpPK(codefahp, codePerson);
    }

    public SentemailbycodefahpPK getSentemailbycodefahpPK() {
        return sentemailbycodefahpPK;
    }

    public void setSentemailbycodefahpPK(SentemailbycodefahpPK sentemailbycodefahpPK) {
        this.sentemailbycodefahpPK = sentemailbycodefahpPK;
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

    public Catalogue getStatussentfahpCat() {
        return statussentfahpCat;
    }

    public void setStatussentfahpCat(Catalogue statussentfahpCat) {
        this.statussentfahpCat = statussentfahpCat;
    }

    public Catalogueitem getCatalogueitem() {
        return catalogueitem;
    }

    public void setCatalogueitem(Catalogueitem catalogueitem) {
        this.catalogueitem = catalogueitem;
    }

    public String getStatussentfahpCatt() {
        return statussentfahpCatt;
    }

    public void setStatussentfahpCatt(String statussentfahpCatt) {
        this.statussentfahpCatt = statussentfahpCatt;
    }

    public String getStatussentfahp() {
        return statussentfahp;
    }

    public void setStatussentfahp(String statussentfahp) {
        this.statussentfahp = statussentfahp;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sentemailbycodefahpPK != null ? sentemailbycodefahpPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sentemailbycodefahp)) {
            return false;
        }
        Sentemailbycodefahp other = (Sentemailbycodefahp) object;
        if ((this.sentemailbycodefahpPK == null && other.sentemailbycodefahpPK != null) || (this.sentemailbycodefahpPK != null && !this.sentemailbycodefahpPK.equals(other.sentemailbycodefahpPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.entities.Sentemailbycodefahp[ sentemailbycodefahpPK=" + sentemailbycodefahpPK + " ]";
    }

}
