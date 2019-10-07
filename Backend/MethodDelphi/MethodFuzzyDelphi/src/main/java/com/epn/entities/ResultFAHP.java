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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@Table(name = "resultFAHP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResultFAHP.findAll", query = "SELECT r FROM ResultFAHP r"),
    @NamedQuery(name = "ResultFAHP.findByCodefahp", query = "SELECT r FROM ResultFAHP r WHERE r.resultFAHPPK.codefahp = :codefahp"),
    @NamedQuery(name = "ResultFAHP.findByCodeQuiz", query = "SELECT r FROM ResultFAHP r WHERE r.resultFAHPPK.codeQuiz = :codeQuiz"),
    @NamedQuery(name = "ResultFAHP.findByCodeQuestions", query = "SELECT r FROM ResultFAHP r WHERE r.resultFAHPPK.codeQuestions = :codeQuestions"),
    @NamedQuery(name = "ResultFAHP.findByCodeQuizItem", query = "SELECT r FROM ResultFAHP r WHERE r.resultFAHPPK.codeQuizItem = :codeQuizItem"),
    @NamedQuery(name = "ResultFAHP.findByValuepriority", query = "SELECT r FROM ResultFAHP r WHERE r.weight = :weight"),
    @NamedQuery(name = "ResultFAHP.findByDateCreate", query = "SELECT r FROM ResultFAHP r WHERE r.dateCreate = :dateCreate"),
    @NamedQuery(name = "ResultFAHP.findByDateLastModify", query = "SELECT r FROM ResultFAHP r WHERE r.dateLastModify = :dateLastModify"),
    @NamedQuery(name = "ResultFAHP.findByUserCreate", query = "SELECT r FROM ResultFAHP r WHERE r.userCreate = :userCreate"),
    @NamedQuery(name = "ResultFAHP.findByUserLastModify", query = "SELECT r FROM ResultFAHP r WHERE r.userLastModify = :userLastModify")})
public class ResultFAHP implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ResultFAHPPK resultFAHPPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "weight")
    private BigDecimal weight;
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
        @JoinColumn(name = "codeQuizItem", referencedColumnName = "codeQuizItem", insertable = false, updatable = false),
        @JoinColumn(name = "codeQuestions", referencedColumnName = "codeQuestions", insertable = false, updatable = false),
        @JoinColumn(name = "codeQuiz", referencedColumnName = "codeQuiz", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private QuestionItem questionItem;
    @JoinColumns({
        @JoinColumn(name = "codeQuestions", referencedColumnName = "codeQuestions", insertable = false, updatable = false),
        @JoinColumn(name = "codeQuiz", referencedColumnName = "codeQuiz", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Questions questions;
    @JoinColumn(name = "codeQuiz", referencedColumnName = "codeQuiz", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Quiz quiz;

    public ResultFAHP() {
    }

    public ResultFAHP(ResultFAHPPK resultFAHPPK) {
        this.resultFAHPPK = resultFAHPPK;
    }

    public ResultFAHP(ResultFAHPPK resultFAHPPK, BigDecimal weight, Date dateCreate, Date dateLastModify, long userCreate, long userLastModify) {
        this.resultFAHPPK = resultFAHPPK;
        this.weight = weight;
        this.dateCreate = dateCreate;
        this.dateLastModify = dateLastModify;
        this.userCreate = userCreate;
        this.userLastModify = userLastModify;
    }

    public ResultFAHP(long codefahp, long codeQuiz, long codeQuestions, long codeQuizItem) {
        this.resultFAHPPK = new ResultFAHPPK(codefahp, codeQuiz, codeQuestions, codeQuizItem);
    }

    public ResultFAHPPK getResultFAHPPK() {
        return resultFAHPPK;
    }

    public void setResultFAHPPK(ResultFAHPPK resultFAHPPK) {
        this.resultFAHPPK = resultFAHPPK;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
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

    public QuestionItem getQuestionItem() {
        return questionItem;
    }

    public void setQuestionItem(QuestionItem questionItem) {
        this.questionItem = questionItem;
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
        hash += (resultFAHPPK != null ? resultFAHPPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResultFAHP)) {
            return false;
        }
        ResultFAHP other = (ResultFAHP) object;
        if ((this.resultFAHPPK == null && other.resultFAHPPK != null) || (this.resultFAHPPK != null && !this.resultFAHPPK.equals(other.resultFAHPPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.entities.ResultFAHP[ resultFAHPPK=" + resultFAHPPK + " ]";
    }
    
}
