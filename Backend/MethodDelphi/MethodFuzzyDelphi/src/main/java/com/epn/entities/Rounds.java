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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@Table(name = "Rounds")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rounds.findAll", query = "SELECT r FROM Rounds r"),
    @NamedQuery(name = "Rounds.findByRoundNumber", query = "SELECT r FROM Rounds r WHERE r.roundsPK.roundNumber = :roundNumber"),
    @NamedQuery(name = "Rounds.findByCodeQuiz", query = "SELECT r FROM Rounds r WHERE r.roundsPK.codeQuiz = :codeQuiz"),
    @NamedQuery(name = "Rounds.findByCodePerson", query = "SELECT r FROM Rounds r WHERE r.roundsPK.codePerson = :codePerson"),
    @NamedQuery(name = "Rounds.findByDateCreate", query = "SELECT r FROM Rounds r WHERE r.dateCreate = :dateCreate"),
    @NamedQuery(name = "Rounds.findByDateLastModify", query = "SELECT r FROM Rounds r WHERE r.dateLastModify = :dateLastModify"),
    @NamedQuery(name = "Rounds.findByUserCreate", query = "SELECT r FROM Rounds r WHERE r.userCreate = :userCreate"),
    @NamedQuery(name = "Rounds.findByUserLastModify", query = "SELECT r FROM Rounds r WHERE r.userLastModify = :userLastModify")})
public class Rounds implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RoundsPK roundsPK;
    @Column(name = "sentstatusCat")
    private String sentstatusCatalogue;
    @Column(name = "sentstatus")
    private String sentstatus;
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
    @JoinColumn(name = "sentstatusCat", referencedColumnName = "code",insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Catalogue sentstatusCat;
    @JoinColumns({
        @JoinColumn(name = "sentstatusCat", referencedColumnName = "codeCatalogue",insertable = false, updatable = false),
        @JoinColumn(name = "sentstatus", referencedColumnName = "codeItem",insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Catalogueitem catalogueitem;

    public Rounds() {
    }

    public Rounds(RoundsPK roundsPK) {
        this.roundsPK = roundsPK;
    }

    public Rounds(RoundsPK roundsPK, Date dateCreate, Date dateLastModify, long userCreate, long userLastModify) {
        this.roundsPK = roundsPK;
        this.dateCreate = dateCreate;
        this.dateLastModify = dateLastModify;
        this.userCreate = userCreate;
        this.userLastModify = userLastModify;
    }

    public Rounds(long roundNumber, long codeQuiz, long codePerson) {
        this.roundsPK = new RoundsPK(roundNumber, codeQuiz, codePerson);
    }

    public RoundsPK getRoundsPK() {
        return roundsPK;
    }

    public void setRoundsPK(RoundsPK roundsPK) {
        this.roundsPK = roundsPK;
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

    public Catalogue getSentstatusCat() {
        return sentstatusCat;
    }

    public void setSentstatusCat(Catalogue sentstatusCat) {
        this.sentstatusCat = sentstatusCat;
    }

    public Catalogueitem getCatalogueitem() {
        return catalogueitem;
    }

    public void setCatalogueitem(Catalogueitem catalogueitem) {
        this.catalogueitem = catalogueitem;
    }

    public String getSentstatusCatalogue() {
        return sentstatusCatalogue;
    }

    public void setSentstatusCatalogue(String sentstatusCatalogue) {
        this.sentstatusCatalogue = sentstatusCatalogue;
    }

    public String getSentstatus() {
        return sentstatus;
    }

    public void setSentstatus(String sentstatus) {
        this.sentstatus = sentstatus;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roundsPK != null ? roundsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rounds)) {
            return false;
        }
        Rounds other = (Rounds) object;
        if ((this.roundsPK == null && other.roundsPK != null) || (this.roundsPK != null && !this.roundsPK.equals(other.roundsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.entities.Rounds[ roundsPK=" + roundsPK + " ]";
    }
    
}
