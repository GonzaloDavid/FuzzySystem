/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
    , @NamedQuery(name = "DelphiCalculations.findByRoundNumber", query = "SELECT d FROM DelphiCalculations d WHERE d.delphiCalculationsPK.roundNumber = :roundNumber")
    , @NamedQuery(name = "DelphiCalculations.findByLowerValue", query = "SELECT d FROM DelphiCalculations d WHERE d.lowerValue = :lowerValue")
    , @NamedQuery(name = "DelphiCalculations.findByMediaValue", query = "SELECT d FROM DelphiCalculations d WHERE d.mediaValue = :mediaValue")
    , @NamedQuery(name = "DelphiCalculations.findByUpperValue", query = "SELECT d FROM DelphiCalculations d WHERE d.upperValue = :upperValue")
    , @NamedQuery(name = "DelphiCalculations.findByDefuzzificationValue", query = "SELECT d FROM DelphiCalculations d WHERE d.defuzzificationValue = :defuzzificationValue")
    , @NamedQuery(name = "DelphiCalculations.findByThreshold", query = "SELECT d FROM DelphiCalculations d WHERE d.threshold = :threshold")
    , @NamedQuery(name = "DelphiCalculations.findByLowerAverage", query = "SELECT d FROM DelphiCalculations d WHERE d.lowerAverage = :lowerAverage")
    , @NamedQuery(name = "DelphiCalculations.findByMediaAverage", query = "SELECT d FROM DelphiCalculations d WHERE d.mediaAverage = :mediaAverage")
    , @NamedQuery(name = "DelphiCalculations.findByUpperAverage", query = "SELECT d FROM DelphiCalculations d WHERE d.upperAverage = :upperAverage")
    , @NamedQuery(name = "DelphiCalculations.findByConsensus", query = "SELECT d FROM DelphiCalculations d WHERE d.consensus = :consensus")
    , @NamedQuery(name = "DelphiCalculations.findByValidated", query = "SELECT d FROM DelphiCalculations d WHERE d.validated = :validated")
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
    @Column(name = "lowerValue")
    private BigDecimal lowerValue;
    @Basic(optional = false)
    @Column(name = "mediaValue")
    private BigDecimal mediaValue;
    @Basic(optional = false)
    @Column(name = "upperValue")
    private BigDecimal upperValue;
    @Basic(optional = false)
    @Column(name = "defuzzificationValue")
    private BigDecimal defuzzificationValue;
    @Basic(optional = false)
    @Column(name = "threshold")
    private BigDecimal threshold;
    @Basic(optional = false)
    @Column(name = "lowerAverage")
    private BigDecimal lowerAverage;
    @Basic(optional = false)
    @Column(name = "mediaAverage")
    private BigDecimal mediaAverage;
    @Basic(optional = false)
    @Column(name = "upperAverage")
    private BigDecimal upperAverage;
    @Basic(optional = false)
    @Column(name = "validated")
    private int validated;
    @Basic(optional = false)
    @Column(name = "consensus")
    private int consensus;
    @Column(name = "statusResultCat")
    private String statusResultCat1;
    @Column(name = "statusResult")
    private String statusResult;
    @Column(name = "dateCreate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;
    @Column(name = "dateLastModify")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateLastModify;
    @Column(name = "userCreate")
    private BigInteger userCreate;
    @Column(name = "userLastModify")
    private BigInteger userLastModify;
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
    @JoinColumn(name = "statusResultCat", referencedColumnName = "code", insertable = false, updatable = false)
    @ManyToOne
    private Catalogue statusResultCat;
    @JoinColumns({
        @JoinColumn(name = "statusResultCat", referencedColumnName = "codeCatalogue", insertable = false, updatable = false)
        , @JoinColumn(name = "statusResult", referencedColumnName = "codeItem", insertable = false, updatable = false)})
    @ManyToOne
    private Catalogueitem catalogueitem;

    public DelphiCalculations() {
    }

    public DelphiCalculations(DelphiCalculationsPK delphiCalculationsPK) {
        this.delphiCalculationsPK = delphiCalculationsPK;
    }

    public DelphiCalculations(DelphiCalculationsPK delphiCalculationsPK, BigDecimal lowerValue, BigDecimal mediaValue, BigDecimal upperValue, BigDecimal defuzzificationValue, BigDecimal threshold, BigDecimal lowerAverage, BigDecimal mediaAverage, BigDecimal upperAverage, int validated, int consensus) {
        this.delphiCalculationsPK = delphiCalculationsPK;
        this.lowerValue = lowerValue;
        this.mediaValue = mediaValue;
        this.upperValue = upperValue;
        this.defuzzificationValue = defuzzificationValue;
        this.threshold = threshold;
        this.lowerAverage = lowerAverage;
        this.mediaAverage = mediaAverage;
        this.upperAverage = upperAverage;
        this.validated = validated;
        this.consensus = consensus;
    }

    public DelphiCalculations(long codeQuiz, long codeQuestions, long codeQuizItem, long roundNumber) {
        this.delphiCalculationsPK = new DelphiCalculationsPK(codeQuiz, codeQuestions, codeQuizItem, roundNumber);
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

    public int getConsensus() {
        return consensus;
    }

    public void setConsensus(int consensus) {
        this.consensus = consensus;
    }

    public void setLowerValue(BigDecimal lowerValue) {
        this.lowerValue = lowerValue;
    }

    public BigDecimal getMediaValue() {
        return mediaValue;
    }

    public void setMediaValue(BigDecimal mediaValue) {
        this.mediaValue = mediaValue;
    }

    public BigDecimal getUpperValue() {
        return upperValue;
    }

    public void setUpperValue(BigDecimal upperValue) {
        this.upperValue = upperValue;
    }

    public BigDecimal getDefuzzificationValue() {
        return defuzzificationValue;
    }

    public void setDefuzzificationValue(BigDecimal defuzzificationValue) {
        this.defuzzificationValue = defuzzificationValue;
    }

    public BigDecimal getThreshold() {
        return threshold;
    }

    public void setThreshold(BigDecimal threshold) {
        this.threshold = threshold;
    }

    public BigDecimal getLowerAverage() {
        return lowerAverage;
    }

    public void setLowerAverage(BigDecimal lowerAverage) {
        this.lowerAverage = lowerAverage;
    }

    public BigDecimal getMediaAverage() {
        return mediaAverage;
    }

    public void setMediaAverage(BigDecimal mediaAverage) {
        this.mediaAverage = mediaAverage;
    }

    public BigDecimal getUpperAverage() {
        return upperAverage;
    }

    public void setUpperAverage(BigDecimal upperAverage) {
        this.upperAverage = upperAverage;
    }

    public int getValidated() {
        return validated;
    }

    public void setValidated(int validated) {
        this.validated = validated;
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

    public BigInteger getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(BigInteger userCreate) {
        this.userCreate = userCreate;
    }

    public BigInteger getUserLastModify() {
        return userLastModify;
    }

    public void setUserLastModify(BigInteger userLastModify) {
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

    public String getStatusResultCat1() {
        return statusResultCat1;
    }

    public void setStatusResultCat1(String statusResultCat1) {
        this.statusResultCat1 = statusResultCat1;
    }

    public String getStatusResult() {
        return statusResult;
    }

    public void setStatusResult(String statusResult) {
        this.statusResult = statusResult;
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
