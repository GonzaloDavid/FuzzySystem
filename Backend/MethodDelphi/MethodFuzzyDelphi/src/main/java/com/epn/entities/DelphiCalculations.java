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
 * @author ka
 */
@Entity
@Table(name = "DelphiCalculations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DelphiCalculations.findAll", query = "SELECT d FROM DelphiCalculations d")
    , @NamedQuery(name = "DelphiCalculations.findByCodeQuiz", query = "SELECT d FROM DelphiCalculations d WHERE d.delphiCalculationsPK.codeQuiz = :codeQuiz")
    , @NamedQuery(name = "DelphiCalculations.findByCodeQuestions", query = "SELECT d FROM DelphiCalculations d WHERE d.delphiCalculationsPK.codeQuestions = :codeQuestions")
    , @NamedQuery(name = "DelphiCalculations.findByCodeQuizItem", query = "SELECT d FROM DelphiCalculations d WHERE d.delphiCalculationsPK.codeQuizItem = :codeQuizItem")
    , @NamedQuery(name = "DelphiCalculations.findByCodePerson", query = "SELECT d FROM DelphiCalculations d WHERE d.delphiCalculationsPK.codePerson = :codePerson")
    , @NamedQuery(name = "DelphiCalculations.findByRoundNumber", query = "SELECT d FROM DelphiCalculations d WHERE d.delphiCalculationsPK.roundNumber = :roundNumber")
    , @NamedQuery(name = "DelphiCalculations.findByLowerValue", query = "SELECT d FROM DelphiCalculations d WHERE d.lowerValue = :lowerValue")
    , @NamedQuery(name = "DelphiCalculations.findByMiddleValue", query = "SELECT d FROM DelphiCalculations d WHERE d.middleValue = :middleValue")
    , @NamedQuery(name = "DelphiCalculations.findByUpperValue", query = "SELECT d FROM DelphiCalculations d WHERE d.upperValue = :upperValue")
    , @NamedQuery(name = "DelphiCalculations.findByConvergenceIndex", query = "SELECT d FROM DelphiCalculations d WHERE d.convergenceIndex = :convergenceIndex")
    , @NamedQuery(name = "DelphiCalculations.findByDiscriminator", query = "SELECT d FROM DelphiCalculations d WHERE d.discriminator = :discriminator")
    , @NamedQuery(name = "DelphiCalculations.findByDateCreate", query = "SELECT d FROM DelphiCalculations d WHERE d.dateCreate = :dateCreate")
    , @NamedQuery(name = "DelphiCalculations.findByDateLastModify", query = "SELECT d FROM DelphiCalculations d WHERE d.dateLastModify = :dateLastModify")
    , @NamedQuery(name = "DelphiCalculations.findByUserCreate", query = "SELECT d FROM DelphiCalculations d WHERE d.userCreate = :userCreate")
    , @NamedQuery(name = "DelphiCalculations.findByUserLastModify", query = "SELECT d FROM DelphiCalculations d WHERE d.userLastModify = :userLastModify")})
public class DelphiCalculations implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DelphiCalculationsPK delphiCalculationsPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "lowerValue")
    private BigDecimal lowerValue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "middleValue")
    private BigDecimal middleValue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "upperValue")
    private BigDecimal upperValue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "convergenceIndex")
    private BigDecimal convergenceIndex;
    @Basic(optional = false)
    @NotNull
    @Column(name = "discriminator")
    private BigDecimal discriminator;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateCreate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateLastModify")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateLastModify;
    @Basic(optional = false)
    @NotNull
    @Column(name = "userCreate")
    private long userCreate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "userLastModify")
    private long userLastModify;
    @JoinColumn(name = "codeQuiz", referencedColumnName = "codeQuiz", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Quiz quiz;
    @JoinColumns({
        @JoinColumn(name = "codeQuestions", referencedColumnName = "codeQuestions", insertable = false, updatable = false)
        , @JoinColumn(name = "codeQuiz", referencedColumnName = "codeQuiz", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Questions questions;
    @JoinColumns({
        @JoinColumn(name = "codeQuizItem", referencedColumnName = "codeQuizItem", insertable = false, updatable = false)
        , @JoinColumn(name = "codeQuestions", referencedColumnName = "codeQuestions", insertable = false, updatable = false)
        , @JoinColumn(name = "codeQuiz", referencedColumnName = "codeQuiz", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private QuestionItem questionItem;
    @JoinColumns({
        @JoinColumn(name = "roundNumber", referencedColumnName = "roundNumber", insertable = false, updatable = false)
        , @JoinColumn(name = "codeQuiz", referencedColumnName = "codeQuiz", insertable = false, updatable = false)
        , @JoinColumn(name = "codePerson", referencedColumnName = "codePerson", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Rounds rounds;
    @JoinColumn(name = "codePerson", referencedColumnName = "codePerson", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Person person;
    @JoinColumn(name = "statusResultCat", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private Catalogue statusResultCat;
    @JoinColumns({
        @JoinColumn(name = "statusResultCat", referencedColumnName = "codeCatalogue")
        , @JoinColumn(name = "statusResult", referencedColumnName = "codeItem")})
    @ManyToOne(optional = false)
    private Catalogueitem catalogueitem;

    public DelphiCalculations() {
    }

    public DelphiCalculations(DelphiCalculationsPK delphiCalculationsPK) {
        this.delphiCalculationsPK = delphiCalculationsPK;
    }

    public DelphiCalculations(DelphiCalculationsPK delphiCalculationsPK, BigDecimal lowerValue, BigDecimal middleValue, BigDecimal upperValue, BigDecimal convergenceIndex, BigDecimal discriminator, Date dateCreate, Date dateLastModify, long userCreate, long userLastModify) {
        this.delphiCalculationsPK = delphiCalculationsPK;
        this.lowerValue = lowerValue;
        this.middleValue = middleValue;
        this.upperValue = upperValue;
        this.convergenceIndex = convergenceIndex;
        this.discriminator = discriminator;
        this.dateCreate = dateCreate;
        this.dateLastModify = dateLastModify;
        this.userCreate = userCreate;
        this.userLastModify = userLastModify;
    }

    public DelphiCalculations(long codeQuiz, long codeQuestions, long codeQuizItem, long codePerson, long roundNumber) {
        this.delphiCalculationsPK = new DelphiCalculationsPK(codeQuiz, codeQuestions, codeQuizItem, codePerson, roundNumber);
    }

    public DelphiCalculationsPK getDelphiCalculationsPK() {
        return delphiCalculationsPK;
    }

    public void setDelphiCalculationsPK(DelphiCalculationsPK delphiCalculationsPK) {
        this.delphiCalculationsPK = delphiCalculationsPK;
    }

    public BigDecimal getLowerValue() {
        return lowerValue;
    }

    public void setLowerValue(BigDecimal lowerValue) {
        this.lowerValue = lowerValue;
    }

    public BigDecimal getMiddleValue() {
        return middleValue;
    }

    public void setMiddleValue(BigDecimal middleValue) {
        this.middleValue = middleValue;
    }

    public BigDecimal getUpperValue() {
        return upperValue;
    }

    public void setUpperValue(BigDecimal upperValue) {
        this.upperValue = upperValue;
    }

    public BigDecimal getConvergenceIndex() {
        return convergenceIndex;
    }

    public void setConvergenceIndex(BigDecimal convergenceIndex) {
        this.convergenceIndex = convergenceIndex;
    }

    public BigDecimal getDiscriminator() {
        return discriminator;
    }

    public void setDiscriminator(BigDecimal discriminator) {
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

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Questions getQuestions() {
        return questions;
    }

    public void setQuestions(Questions questions) {
        this.questions = questions;
    }

    public QuestionItem getQuestionItem() {
        return questionItem;
    }

    public void setQuestionItem(QuestionItem questionItem) {
        this.questionItem = questionItem;
    }

    public Rounds getRounds() {
        return rounds;
    }

    public void setRounds(Rounds rounds) {
        this.rounds = rounds;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Catalogue getStatusResultCat() {
        return statusResultCat;
    }

    public void setStatusResultCat(Catalogue statusResultCat) {
        this.statusResultCat = statusResultCat;
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
        hash += (delphiCalculationsPK != null ? delphiCalculationsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DelphiCalculations)) {
            return false;
        }
        DelphiCalculations other = (DelphiCalculations) object;
        if ((this.delphiCalculationsPK == null && other.delphiCalculationsPK != null) || (this.delphiCalculationsPK != null && !this.delphiCalculationsPK.equals(other.delphiCalculationsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.entities.DelphiCalculations[ delphiCalculationsPK=" + delphiCalculationsPK + " ]";
    }
    
}
