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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author david
 */
@Entity
@Table(name = "Rounds")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rounds.findAll", query = "SELECT r FROM Rounds r"),
    @NamedQuery(name = "Rounds.findByRoundNumber", query = "SELECT r FROM Rounds r WHERE r.roundsPK.roundNumber = :roundNumber"),
    @NamedQuery(name = "Rounds.findByCodeQuiz", query = "SELECT r FROM Rounds r WHERE r.roundsPK.codeQuiz = :codeQuiz"),
    @NamedQuery(name = "Rounds.findByCodePerson", query = "SELECT r FROM Rounds r WHERE r.roundsPK.codePerson = :codePerson")})
public class Rounds implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RoundsPK roundsPK;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rounds")
    private List<Quizvalues> quizvaluesList;

    public Rounds() {
    }

    public Rounds(RoundsPK roundsPK) {
        this.roundsPK = roundsPK;
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
    public List<Quizvalues> getQuizvaluesList() {
        return quizvaluesList;
    }

    public void setQuizvaluesList(List<Quizvalues> quizvaluesList) {
        this.quizvaluesList = quizvaluesList;
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
