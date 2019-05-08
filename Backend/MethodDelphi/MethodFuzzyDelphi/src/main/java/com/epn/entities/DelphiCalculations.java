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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "DelphiCalculations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DelphiCalculations.findAll", query = "SELECT d FROM DelphiCalculations d")
    , @NamedQuery(name = "DelphiCalculations.findBySeqdelphicalculation", query = "SELECT d FROM DelphiCalculations d WHERE d.seqdelphicalculation = :seqdelphicalculation")
    , @NamedQuery(name = "DelphiCalculations.findByConvergenceIndex", query = "SELECT d FROM DelphiCalculations d WHERE d.convergenceIndex = :convergenceIndex")
    , @NamedQuery(name = "DelphiCalculations.findByRoundNumber", query = "SELECT d FROM DelphiCalculations d WHERE d.roundNumber = :roundNumber")
    , @NamedQuery(name = "DelphiCalculations.findByDiscriminator", query = "SELECT d FROM DelphiCalculations d WHERE d.discriminator = :discriminator")
    , @NamedQuery(name = "DelphiCalculations.findByDateCreate", query = "SELECT d FROM DelphiCalculations d WHERE d.dateCreate = :dateCreate")
    , @NamedQuery(name = "DelphiCalculations.findByDateLastModify", query = "SELECT d FROM DelphiCalculations d WHERE d.dateLastModify = :dateLastModify")
    , @NamedQuery(name = "DelphiCalculations.findByUserCreate", query = "SELECT d FROM DelphiCalculations d WHERE d.userCreate = :userCreate")
    , @NamedQuery(name = "DelphiCalculations.findByUserLastModify", query = "SELECT d FROM DelphiCalculations d WHERE d.userLastModify = :userLastModify")})
public class DelphiCalculations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "seqdelphicalculation")
    private Long seqdelphicalculation;
    @Basic(optional = false)
    @Column(name = "convergenceIndex")
    private double convergenceIndex;
    @Basic(optional = false)
    @Column(name = "roundNumber")
    private long roundNumber;
    @Basic(optional = false)
    @Column(name = "discriminator")
    private double discriminator;
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
    @JoinColumn(name = "codeQuizItem", referencedColumnName = "codeQuizItem")
    @ManyToOne(optional = false)
    private QuestionItem codeQuizItem;
    @JoinColumn(name = "codeQuestions", referencedColumnName = "codeQuestions")
    @ManyToOne(optional = false)
    private Questions codeQuestions;
    @JoinColumn(name = "codeQuiz", referencedColumnName = "codeQuiz")
    @ManyToOne(optional = false)
    private Quiz codeQuiz;
    @JoinColumns({
        @JoinColumn(name = "statusResultCat", referencedColumnName = "codeCatalogue")
        , @JoinColumn(name = "statusResult", referencedColumnName = "codeItem")})
    @ManyToOne(optional = false)
    private Catalogueitem catalogueitem;

    public DelphiCalculations() {
    }

    public DelphiCalculations(Long seqdelphicalculation) {
        this.seqdelphicalculation = seqdelphicalculation;
    }

    public DelphiCalculations(Long seqdelphicalculation, double convergenceIndex, long roundNumber, double discriminator, Date dateCreate, Date dateLastModify, long userCreate, long userLastModify) {
        this.seqdelphicalculation = seqdelphicalculation;
        this.convergenceIndex = convergenceIndex;
        this.roundNumber = roundNumber;
        this.discriminator = discriminator;
        this.dateCreate = dateCreate;
        this.dateLastModify = dateLastModify;
        this.userCreate = userCreate;
        this.userLastModify = userLastModify;
    }

    public Long getSeqdelphicalculation() {
        return seqdelphicalculation;
    }

    public void setSeqdelphicalculation(Long seqdelphicalculation) {
        this.seqdelphicalculation = seqdelphicalculation;
    }

    public double getConvergenceIndex() {
        return convergenceIndex;
    }

    public void setConvergenceIndex(double convergenceIndex) {
        this.convergenceIndex = convergenceIndex;
    }

    public long getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(long roundNumber) {
        this.roundNumber = roundNumber;
    }

    public double getDiscriminator() {
        return discriminator;
    }

    public void setDiscriminator(double discriminator) {
        this.discriminator = discriminator;
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

    public QuestionItem getCodeQuizItem() {
        return codeQuizItem;
    }

    public void setCodeQuizItem(QuestionItem codeQuizItem) {
        this.codeQuizItem = codeQuizItem;
    }

    public Questions getCodeQuestions() {
        return codeQuestions;
    }

    public void setCodeQuestions(Questions codeQuestions) {
        this.codeQuestions = codeQuestions;
    }

    public Quiz getCodeQuiz() {
        return codeQuiz;
    }

    public void setCodeQuiz(Quiz codeQuiz) {
        this.codeQuiz = codeQuiz;
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
        hash += (seqdelphicalculation != null ? seqdelphicalculation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DelphiCalculations)) {
            return false;
        }
        DelphiCalculations other = (DelphiCalculations) object;
        if ((this.seqdelphicalculation == null && other.seqdelphicalculation != null) || (this.seqdelphicalculation != null && !this.seqdelphicalculation.equals(other.seqdelphicalculation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.entities.DelphiCalculations[ seqdelphicalculation=" + seqdelphicalculation + " ]";
    }
    
}
