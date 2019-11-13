/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author desarrollador
 */
@Entity
@Table(name = "catalogue")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Catalogue.findAll", query = "SELECT c FROM Catalogue c"),
    @NamedQuery(name = "Catalogue.findByCode", query = "SELECT c FROM Catalogue c WHERE c.code = :code"),
    @NamedQuery(name = "Catalogue.findByName", query = "SELECT c FROM Catalogue c WHERE c.name = :name"),
    @NamedQuery(name = "Catalogue.findByDescripcion", query = "SELECT c FROM Catalogue c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Catalogue.findByDateCreate", query = "SELECT c FROM Catalogue c WHERE c.dateCreate = :dateCreate"),
    @NamedQuery(name = "Catalogue.findByDateLastModify", query = "SELECT c FROM Catalogue c WHERE c.dateLastModify = :dateLastModify"),
    @NamedQuery(name = "Catalogue.findByUserCreate", query = "SELECT c FROM Catalogue c WHERE c.userCreate = :userCreate"),
    @NamedQuery(name = "Catalogue.findByUserLastModify", query = "SELECT c FROM Catalogue c WHERE c.userLastModify = :userLastModify")})
public class Catalogue implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sentstatusCat")
    private List<Rounds> roundsList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "descripcion")
    private String descripcion;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catalogue")
    private List<Catalogueitem> catalogueitemList;

    public Catalogue() {
    }

    public Catalogue(String code) {
        this.code = code;
    }

    public Catalogue(String code, String name, Date dateCreate, Date dateLastModify, long userCreate, long userLastModify) {
        this.code = code;
        this.name = name;
        this.dateCreate = dateCreate;
        this.dateLastModify = dateLastModify;
        this.userCreate = userCreate;
        this.userLastModify = userLastModify;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

   

    public List<Catalogueitem> getCatalogueitemList() {
        return catalogueitemList;
    }

    public void setCatalogueitemList(List<Catalogueitem> catalogueitemList) {
        this.catalogueitemList = catalogueitemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Catalogue)) {
            return false;
        }
        Catalogue other = (Catalogue) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.entities.Catalogue[ code=" + code + " ]";
    }

    @XmlTransient
    public List<Rounds> getRoundsList() {
        return roundsList;
    }

    public void setRoundsList(List<Rounds> roundsList) {
        this.roundsList = roundsList;
    }

}
