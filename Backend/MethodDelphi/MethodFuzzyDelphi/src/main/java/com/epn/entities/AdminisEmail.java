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
 * @author desarrollador
 */
@Entity
@Table(name = "AdminisEmail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdminisEmail.findAll", query = "SELECT a FROM AdminisEmail a")
    , @NamedQuery(name = "AdminisEmail.findBySeqadminisemail", query = "SELECT a FROM AdminisEmail a WHERE a.adminisEmailPK.seqadminisemail = :seqadminisemail")
    , @NamedQuery(name = "AdminisEmail.findByCodeQuiz", query = "SELECT a FROM AdminisEmail a WHERE a.adminisEmailPK.codeQuiz = :codeQuiz")
    , @NamedQuery(name = "AdminisEmail.findByCodePerson", query = "SELECT a FROM AdminisEmail a WHERE a.adminisEmailPK.codePerson = :codePerson")
    , @NamedQuery(name = "AdminisEmail.findByDateCreate", query = "SELECT a FROM AdminisEmail a WHERE a.dateCreate = :dateCreate")
    , @NamedQuery(name = "AdminisEmail.findByDateLastModify", query = "SELECT a FROM AdminisEmail a WHERE a.dateLastModify = :dateLastModify")
    , @NamedQuery(name = "AdminisEmail.findByUserCreate", query = "SELECT a FROM AdminisEmail a WHERE a.userCreate = :userCreate")
    , @NamedQuery(name = "AdminisEmail.findByUserLastModify", query = "SELECT a FROM AdminisEmail a WHERE a.userLastModify = :userLastModify")})
public class AdminisEmail implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AdminisEmailPK adminisEmailPK;
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
    @JoinColumn(name = "codePerson", referencedColumnName = "codePerson", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Person person;
    @JoinColumn(name = "codeQuiz", referencedColumnName = "codeQuiz", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Quiz quiz;
    @JoinColumns({
        @JoinColumn(name = "statusEmailCat", referencedColumnName = "codeCatalogue")
        , @JoinColumn(name = "statusEmail", referencedColumnName = "codeItem")})
    @ManyToOne(optional = false)
    private Catalogueitem catalogueitem;

    public AdminisEmail() {
    }

    public AdminisEmail(AdminisEmailPK adminisEmailPK) {
        this.adminisEmailPK = adminisEmailPK;
    }

    public AdminisEmail(AdminisEmailPK adminisEmailPK, Date dateCreate, Date dateLastModify, long userCreate, long userLastModify) {
        this.adminisEmailPK = adminisEmailPK;
        this.dateCreate = dateCreate;
        this.dateLastModify = dateLastModify;
        this.userCreate = userCreate;
        this.userLastModify = userLastModify;
    }

    public AdminisEmail(long seqadminisemail, long codeQuiz, long codePerson) {
        this.adminisEmailPK = new AdminisEmailPK(seqadminisemail, codeQuiz, codePerson);
    }

    public AdminisEmailPK getAdminisEmailPK() {
        return adminisEmailPK;
    }

    public void setAdminisEmailPK(AdminisEmailPK adminisEmailPK) {
        this.adminisEmailPK = adminisEmailPK;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Catalogueitem getCatalogueitem() {
        return catalogueitem;
    }

    public void setCatalogueitem(Catalogueitem catalogueitem) {
        this.catalogueitem = catalogueitem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adminisEmailPK != null ? adminisEmailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdminisEmail)) {
            return false;
        }
        AdminisEmail other = (AdminisEmail) object;
        if ((this.adminisEmailPK == null && other.adminisEmailPK != null) || (this.adminisEmailPK != null && !this.adminisEmailPK.equals(other.adminisEmailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.entities.AdminisEmail[ adminisEmailPK=" + adminisEmailPK + " ]";
    }
    
}
