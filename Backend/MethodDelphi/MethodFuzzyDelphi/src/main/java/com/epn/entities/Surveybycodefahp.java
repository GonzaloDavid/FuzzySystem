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
@Table(name = "surveybycodefahp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Surveybycodefahp.findAll", query = "SELECT s FROM Surveybycodefahp s"),
    @NamedQuery(name = "Surveybycodefahp.findByCodefahp", query = "SELECT s FROM Surveybycodefahp s WHERE s.surveybycodefahpPK.codefahp = :codefahp"),
    @NamedQuery(name = "Surveybycodefahp.findByCodeQuiz", query = "SELECT s FROM Surveybycodefahp s WHERE s.surveybycodefahpPK.codeQuiz = :codeQuiz"),
    @NamedQuery(name = "Surveybycodefahp.findByCodeQuestions", query = "SELECT s FROM Surveybycodefahp s WHERE s.surveybycodefahpPK.codeQuestions = :codeQuestions"),
    @NamedQuery(name = "Surveybycodefahp.findByDateCreate", query = "SELECT s FROM Surveybycodefahp s WHERE s.dateCreate = :dateCreate"),
    @NamedQuery(name = "Surveybycodefahp.findByDateLastModify", query = "SELECT s FROM Surveybycodefahp s WHERE s.dateLastModify = :dateLastModify"),
    @NamedQuery(name = "Surveybycodefahp.findByUserCreate", query = "SELECT s FROM Surveybycodefahp s WHERE s.userCreate = :userCreate"),
    @NamedQuery(name = "Surveybycodefahp.findByUserLastModify", query = "SELECT s FROM Surveybycodefahp s WHERE s.userLastModify = :userLastModify")})
public class Surveybycodefahp implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SurveybycodefahpPK surveybycodefahpPK;
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
    @JoinColumns({
        @JoinColumn(name = "codeQuestions", referencedColumnName = "codeQuestions", insertable = false, updatable = false),
        @JoinColumn(name = "codeQuiz", referencedColumnName = "codeQuiz", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Questions questions;
    @JoinColumn(name = "codeQuiz", referencedColumnName = "codeQuiz", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Quiz quiz;

    public Surveybycodefahp() {
    }

    public Surveybycodefahp(SurveybycodefahpPK surveybycodefahpPK) {
        this.surveybycodefahpPK = surveybycodefahpPK;
    }

    public Surveybycodefahp(SurveybycodefahpPK surveybycodefahpPK, Date dateCreate, Date dateLastModify, long userCreate, long userLastModify) {
        this.surveybycodefahpPK = surveybycodefahpPK;
        this.dateCreate = dateCreate;
        this.dateLastModify = dateLastModify;
        this.userCreate = userCreate;
        this.userLastModify = userLastModify;
    }

    public Surveybycodefahp(long codefahp, long codeQuiz, long codeQuestions) {
        this.surveybycodefahpPK = new SurveybycodefahpPK(codefahp, codeQuiz, codeQuestions);
    }

    public SurveybycodefahpPK getSurveybycodefahpPK() {
        return surveybycodefahpPK;
    }

    public void setSurveybycodefahpPK(SurveybycodefahpPK surveybycodefahpPK) {
        this.surveybycodefahpPK = surveybycodefahpPK;
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

    public Questions getQuestions() {
        return questions;
    }

    public void setQuestions(Questions questions) {
        this.questions = questions;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (surveybycodefahpPK != null ? surveybycodefahpPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Surveybycodefahp)) {
            return false;
        }
        Surveybycodefahp other = (Surveybycodefahp) object;
        if ((this.surveybycodefahpPK == null && other.surveybycodefahpPK != null) || (this.surveybycodefahpPK != null && !this.surveybycodefahpPK.equals(other.surveybycodefahpPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.entities.Surveybycodefahp[ surveybycodefahpPK=" + surveybycodefahpPK + " ]";
    }
    
}
