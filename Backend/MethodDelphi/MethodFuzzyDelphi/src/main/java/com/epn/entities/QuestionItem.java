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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@Table(name = "QuestionItem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QuestionItem.findAll", query = "SELECT q FROM QuestionItem q"),
    @NamedQuery(name = "QuestionItem.findByCodeQuizItem", query = "SELECT q FROM QuestionItem q WHERE q.questionItemPK.codeQuizItem = :codeQuizItem"),
    @NamedQuery(name = "QuestionItem.findByCodeQuestions", query = "SELECT q FROM QuestionItem q WHERE q.questionItemPK.codeQuestions = :codeQuestions"),
    @NamedQuery(name = "QuestionItem.findByCodeQuiz", query = "SELECT q FROM QuestionItem q WHERE q.questionItemPK.codeQuiz = :codeQuiz"),
    @NamedQuery(name = "QuestionItem.findByItemLabel", query = "SELECT q FROM QuestionItem q WHERE q.itemLabel = :itemLabel"),
    @NamedQuery(name = "QuestionItem.findByDateCreate", query = "SELECT q FROM QuestionItem q WHERE q.dateCreate = :dateCreate"),
    @NamedQuery(name = "QuestionItem.findByDateLastModify", query = "SELECT q FROM QuestionItem q WHERE q.dateLastModify = :dateLastModify"),
    @NamedQuery(name = "QuestionItem.findByUserCreate", query = "SELECT q FROM QuestionItem q WHERE q.userCreate = :userCreate"),
    @NamedQuery(name = "QuestionItem.findByUserLastModify", query = "SELECT q FROM QuestionItem q WHERE q.userLastModify = :userLastModify")})
public class QuestionItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected QuestionItemPK questionItemPK;
    @Basic(optional = false)
    @Size(min = 1, max = 100)
    @Column(name = "itemLabel")
    private String itemLabel;
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
    @JoinColumns({
        @JoinColumn(name = "codeQuestions", referencedColumnName = "codeQuestions", insertable = false, updatable = false),
        @JoinColumn(name = "codeQuiz", referencedColumnName = "codeQuiz", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Questions questions;

    public QuestionItem() {
    }

    public QuestionItem(QuestionItemPK questionItemPK) {
        this.questionItemPK = questionItemPK;
    }

    public QuestionItem(QuestionItemPK questionItemPK, String itemLabel, Date dateCreate, Date dateLastModify, long userCreate, long userLastModify) {
        this.questionItemPK = questionItemPK;
        this.itemLabel = itemLabel;
        this.dateCreate = dateCreate;
        this.dateLastModify = dateLastModify;
        this.userCreate = userCreate;
        this.userLastModify = userLastModify;
    }

    public QuestionItem(long codeQuizItem, long codeQuestions, long codeQuiz) {
        this.questionItemPK = new QuestionItemPK(codeQuizItem, codeQuestions, codeQuiz);
    }

    public QuestionItemPK getQuestionItemPK() {
        return questionItemPK;
    }

    public void setQuestionItemPK(QuestionItemPK questionItemPK) {
        this.questionItemPK = questionItemPK;
    }

    public String getItemLabel() {
        return itemLabel;
    }

    public void setItemLabel(String itemLabel) {
        this.itemLabel = itemLabel;
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

    public Questions getQuestions() {
        return questions;
    }

    public void setQuestions(Questions questions) {
        this.questions = questions;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (questionItemPK != null ? questionItemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuestionItem)) {
            return false;
        }
        QuestionItem other = (QuestionItem) object;
        if ((this.questionItemPK == null && other.questionItemPK != null) || (this.questionItemPK != null && !this.questionItemPK.equals(other.questionItemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.entities.QuestionItem[ questionItemPK=" + questionItemPK + " ]";
    }
    
}
