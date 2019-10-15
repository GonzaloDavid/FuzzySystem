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
@Table(name = "processFahpatributebycriteria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcessFahpatributebycriteria.findAll", query = "SELECT p FROM ProcessFahpatributebycriteria p"),
    @NamedQuery(name = "ProcessFahpatributebycriteria.findByCodefahp", query = "SELECT p FROM ProcessFahpatributebycriteria p WHERE p.processFahpatributebycriteriaPK.codefahp = :codefahp"),
    @NamedQuery(name = "ProcessFahpatributebycriteria.findByCodeQuiz", query = "SELECT p FROM ProcessFahpatributebycriteria p WHERE p.processFahpatributebycriteriaPK.codeQuiz = :codeQuiz"),
    @NamedQuery(name = "ProcessFahpatributebycriteria.findByCodeQuestions", query = "SELECT p FROM ProcessFahpatributebycriteria p WHERE p.processFahpatributebycriteriaPK.codeQuestions = :codeQuestions"),
    @NamedQuery(name = "ProcessFahpatributebycriteria.findByCodeQuizItem", query = "SELECT p FROM ProcessFahpatributebycriteria p WHERE p.processFahpatributebycriteriaPK.codeQuizItem = :codeQuizItem"),
    @NamedQuery(name = "ProcessFahpatributebycriteria.findByCodeCriteria", query = "SELECT p FROM ProcessFahpatributebycriteria p WHERE p.processFahpatributebycriteriaPK.codeCriteria = :codeCriteria"),
    @NamedQuery(name = "ProcessFahpatributebycriteria.findByWeight", query = "SELECT p FROM ProcessFahpatributebycriteria p WHERE p.weight = :weight"),
    @NamedQuery(name = "ProcessFahpatributebycriteria.findByDateCreate", query = "SELECT p FROM ProcessFahpatributebycriteria p WHERE p.dateCreate = :dateCreate"),
    @NamedQuery(name = "ProcessFahpatributebycriteria.findByDateLastModify", query = "SELECT p FROM ProcessFahpatributebycriteria p WHERE p.dateLastModify = :dateLastModify"),
    @NamedQuery(name = "ProcessFahpatributebycriteria.findByUserCreate", query = "SELECT p FROM ProcessFahpatributebycriteria p WHERE p.userCreate = :userCreate"),
    @NamedQuery(name = "ProcessFahpatributebycriteria.findByUserLastModify", query = "SELECT p FROM ProcessFahpatributebycriteria p WHERE p.userLastModify = :userLastModify")})
public class ProcessFahpatributebycriteria implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProcessFahpatributebycriteriaPK processFahpatributebycriteriaPK;
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
    @JoinColumn(name = "codeCriteria", referencedColumnName = "codeCriteria", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Criteria criteria;

    public ProcessFahpatributebycriteria() {
    }

    public ProcessFahpatributebycriteria(ProcessFahpatributebycriteriaPK processFahpatributebycriteriaPK) {
        this.processFahpatributebycriteriaPK = processFahpatributebycriteriaPK;
    }

    public ProcessFahpatributebycriteria(ProcessFahpatributebycriteriaPK processFahpatributebycriteriaPK, BigDecimal weight, Date dateCreate, Date dateLastModify, long userCreate, long userLastModify) {
        this.processFahpatributebycriteriaPK = processFahpatributebycriteriaPK;
        this.weight = weight;
        this.dateCreate = dateCreate;
        this.dateLastModify = dateLastModify;
        this.userCreate = userCreate;
        this.userLastModify = userLastModify;
    }

    public ProcessFahpatributebycriteria(long codefahp, long codeQuiz, long codeQuestions, long codeQuizItem, long codeCriteria) {
        this.processFahpatributebycriteriaPK = new ProcessFahpatributebycriteriaPK(codefahp, codeQuiz, codeQuestions, codeQuizItem, codeCriteria);
    }

    public ProcessFahpatributebycriteriaPK getProcessFahpatributebycriteriaPK() {
        return processFahpatributebycriteriaPK;
    }

    public void setProcessFahpatributebycriteriaPK(ProcessFahpatributebycriteriaPK processFahpatributebycriteriaPK) {
        this.processFahpatributebycriteriaPK = processFahpatributebycriteriaPK;
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

    public Criteria getCriteria() {
        return criteria;
    }

    public void setCriteria(Criteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (processFahpatributebycriteriaPK != null ? processFahpatributebycriteriaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcessFahpatributebycriteria)) {
            return false;
        }
        ProcessFahpatributebycriteria other = (ProcessFahpatributebycriteria) object;
        if ((this.processFahpatributebycriteriaPK == null && other.processFahpatributebycriteriaPK != null) || (this.processFahpatributebycriteriaPK != null && !this.processFahpatributebycriteriaPK.equals(other.processFahpatributebycriteriaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.entities.ProcessFahpatributebycriteria[ processFahpatributebycriteriaPK=" + processFahpatributebycriteriaPK + " ]";
    }
    
}
