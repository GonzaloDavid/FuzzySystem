/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fuzzydelphi.methodfuzzydelphi;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "catalogueitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Catalogueitem.findAll", query = "SELECT c FROM Catalogueitem c")
    , @NamedQuery(name = "Catalogueitem.findByCodeCatalogue", query = "SELECT c FROM Catalogueitem c WHERE c.catalogueitemPK.codeCatalogue = :codeCatalogue")
    , @NamedQuery(name = "Catalogueitem.findByCodeItem", query = "SELECT c FROM Catalogueitem c WHERE c.catalogueitemPK.codeItem = :codeItem")
    , @NamedQuery(name = "Catalogueitem.findByNameItem", query = "SELECT c FROM Catalogueitem c WHERE c.nameItem = :nameItem")
    , @NamedQuery(name = "Catalogueitem.findByDateCreate", query = "SELECT c FROM Catalogueitem c WHERE c.dateCreate = :dateCreate")
    , @NamedQuery(name = "Catalogueitem.findByDateLastModify", query = "SELECT c FROM Catalogueitem c WHERE c.dateLastModify = :dateLastModify")
    , @NamedQuery(name = "Catalogueitem.findByUserCreate", query = "SELECT c FROM Catalogueitem c WHERE c.userCreate = :userCreate")
    , @NamedQuery(name = "Catalogueitem.findByUserLastModify", query = "SELECT c FROM Catalogueitem c WHERE c.userLastModify = :userLastModify")})
public class Catalogueitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CatalogueitemPK catalogueitemPK;
    @Basic(optional = false)
    @Column(name = "nameItem")
    private String nameItem;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catalogueitem")
    private List<Person> personList;
    @OneToMany(mappedBy = "catalogueitem1")
    private List<Person> personList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catalogueitem2")
    private List<Person> personList2;
    @OneToMany(mappedBy = "catalogueitem3")
    private List<Person> personList3;
    @OneToMany(mappedBy = "catalogueitem4")
    private List<Person> personList4;

    public Catalogueitem() {
    }

    public Catalogueitem(CatalogueitemPK catalogueitemPK) {
        this.catalogueitemPK = catalogueitemPK;
    }

    public Catalogueitem(CatalogueitemPK catalogueitemPK, String nameItem, Date dateCreate, Date dateLastModify, long userCreate, long userLastModify) {
        this.catalogueitemPK = catalogueitemPK;
        this.nameItem = nameItem;
        this.dateCreate = dateCreate;
        this.dateLastModify = dateLastModify;
        this.userCreate = userCreate;
        this.userLastModify = userLastModify;
    }

    public Catalogueitem(String codeCatalogue, String codeItem) {
        this.catalogueitemPK = new CatalogueitemPK(codeCatalogue, codeItem);
    }

    public CatalogueitemPK getCatalogueitemPK() {
        return catalogueitemPK;
    }

    public void setCatalogueitemPK(CatalogueitemPK catalogueitemPK) {
        this.catalogueitemPK = catalogueitemPK;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
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

    @XmlTransient
    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    @XmlTransient
    public List<Person> getPersonList1() {
        return personList1;
    }

    public void setPersonList1(List<Person> personList1) {
        this.personList1 = personList1;
    }

    @XmlTransient
    public List<Person> getPersonList2() {
        return personList2;
    }

    public void setPersonList2(List<Person> personList2) {
        this.personList2 = personList2;
    }

    @XmlTransient
    public List<Person> getPersonList3() {
        return personList3;
    }

    public void setPersonList3(List<Person> personList3) {
        this.personList3 = personList3;
    }

    @XmlTransient
    public List<Person> getPersonList4() {
        return personList4;
    }

    public void setPersonList4(List<Person> personList4) {
        this.personList4 = personList4;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catalogueitemPK != null ? catalogueitemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Catalogueitem)) {
            return false;
        }
        Catalogueitem other = (Catalogueitem) object;
        if ((this.catalogueitemPK == null && other.catalogueitemPK != null) || (this.catalogueitemPK != null && !this.catalogueitemPK.equals(other.catalogueitemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.fuzzydelphi.methodfuzzydelphi.Catalogueitem[ catalogueitemPK=" + catalogueitemPK + " ]";
    }
    
}
