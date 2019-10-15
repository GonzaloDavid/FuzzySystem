/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.entities;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@Table(name = "attributesMatrixAverageValue")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AttributesMatrixAverageValue.findAll", query = "SELECT a FROM AttributesMatrixAverageValue a"),
    @NamedQuery(name = "AttributesMatrixAverageValue.findByCodefahp", query = "SELECT a FROM AttributesMatrixAverageValue a WHERE a.attributesMatrixAverageValuePK.codefahp = :codefahp"),
    @NamedQuery(name = "AttributesMatrixAverageValue.findByCodeCriteria", query = "SELECT a FROM AttributesMatrixAverageValue a WHERE a.attributesMatrixAverageValuePK.codeCriteria = :codeCriteria"),
    @NamedQuery(name = "AttributesMatrixAverageValue.findByCodeQuiz", query = "SELECT a FROM AttributesMatrixAverageValue a WHERE a.attributesMatrixAverageValuePK.codeQuiz = :codeQuiz"),
    @NamedQuery(name = "AttributesMatrixAverageValue.findByCodeQuestions", query = "SELECT a FROM AttributesMatrixAverageValue a WHERE a.attributesMatrixAverageValuePK.codeQuestions = :codeQuestions"),
    @NamedQuery(name = "AttributesMatrixAverageValue.findByItemLabel", query = "SELECT a FROM AttributesMatrixAverageValue a WHERE a.attributesMatrixAverageValuePK.itemLabel = :itemLabel"),
    @NamedQuery(name = "AttributesMatrixAverageValue.findByItemLabelCouple", query = "SELECT a FROM AttributesMatrixAverageValue a WHERE a.attributesMatrixAverageValuePK.itemLabelCouple = :itemLabelCouple"),
    @NamedQuery(name = "AttributesMatrixAverageValue.findByValuecriteriaFAHP", query = "SELECT a FROM AttributesMatrixAverageValue a WHERE a.valuecriteriaFAHP = :valuecriteriaFAHP")})
public class AttributesMatrixAverageValue implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AttributesMatrixAverageValuePK attributesMatrixAverageValuePK;
    @Basic(optional = false)
    @Column(name = "valuecriteriaFAHP")
    private String valuecriteriaFAHP;
    @JoinColumn(name = "codefahp", referencedColumnName = "codefahp", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Fahp fahp;
    @JoinColumns({
        @JoinColumn(name = "itemLabel", referencedColumnName = "codeQuizItem", insertable = false, updatable = false),
        @JoinColumn(name = "codeQuestions", referencedColumnName = "codeQuestions", insertable = false, updatable = false),
        @JoinColumn(name = "codeQuiz", referencedColumnName = "codeQuiz", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private QuestionItem questionItem;
    @JoinColumns({
        @JoinColumn(name = "itemLabelCouple", referencedColumnName = "codeQuizItem", insertable = false, updatable = false),
        @JoinColumn(name = "codeQuestions", referencedColumnName = "codeQuestions", insertable = false, updatable = false),
        @JoinColumn(name = "codeQuiz", referencedColumnName = "codeQuiz", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private QuestionItem questionItem1;
    @JoinColumns({
        @JoinColumn(name = "codeQuestions", referencedColumnName = "codeQuestions", insertable = false, updatable = false),
        @JoinColumn(name = "codeQuiz", referencedColumnName = "codeQuiz", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Questions questions;
    @JoinColumn(name = "codeQuiz", referencedColumnName = "codeQuiz", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Quiz quiz;
    @JoinColumn(name = "valuecriteriaFAHPCat", referencedColumnName = "code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Catalogue valuecriteriaFAHPCat;
    @JoinColumn(name = "codeCriteria", referencedColumnName = "codeCriteria", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Criteria criteria;

    public AttributesMatrixAverageValue() {
    }

    public AttributesMatrixAverageValue(AttributesMatrixAverageValuePK attributesMatrixAverageValuePK) {
        this.attributesMatrixAverageValuePK = attributesMatrixAverageValuePK;
    }

    public AttributesMatrixAverageValue(AttributesMatrixAverageValuePK attributesMatrixAverageValuePK, String valuecriteriaFAHP) {
        this.attributesMatrixAverageValuePK = attributesMatrixAverageValuePK;
        this.valuecriteriaFAHP = valuecriteriaFAHP;
    }

    public AttributesMatrixAverageValue(long codefahp, long codeCriteria, long codeQuiz, long codeQuestions, long itemLabel, long itemLabelCouple) {
        this.attributesMatrixAverageValuePK = new AttributesMatrixAverageValuePK(codefahp, codeCriteria, codeQuiz, codeQuestions, itemLabel, itemLabelCouple);
    }

    public AttributesMatrixAverageValuePK getAttributesMatrixAverageValuePK() {
        return attributesMatrixAverageValuePK;
    }

    public void setAttributesMatrixAverageValuePK(AttributesMatrixAverageValuePK attributesMatrixAverageValuePK) {
        this.attributesMatrixAverageValuePK = attributesMatrixAverageValuePK;
    }

    public String getValuecriteriaFAHP() {
        return valuecriteriaFAHP;
    }

    public void setValuecriteriaFAHP(String valuecriteriaFAHP) {
        this.valuecriteriaFAHP = valuecriteriaFAHP;
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

    public QuestionItem getQuestionItem1() {
        return questionItem1;
    }

    public void setQuestionItem1(QuestionItem questionItem1) {
        this.questionItem1 = questionItem1;
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

    public Catalogue getValuecriteriaFAHPCat() {
        return valuecriteriaFAHPCat;
    }

    public void setValuecriteriaFAHPCat(Catalogue valuecriteriaFAHPCat) {
        this.valuecriteriaFAHPCat = valuecriteriaFAHPCat;
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
        hash += (attributesMatrixAverageValuePK != null ? attributesMatrixAverageValuePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AttributesMatrixAverageValue)) {
            return false;
        }
        AttributesMatrixAverageValue other = (AttributesMatrixAverageValue) object;
        if ((this.attributesMatrixAverageValuePK == null && other.attributesMatrixAverageValuePK != null) || (this.attributesMatrixAverageValuePK != null && !this.attributesMatrixAverageValuePK.equals(other.attributesMatrixAverageValuePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.entities.AttributesMatrixAverageValue[ attributesMatrixAverageValuePK=" + attributesMatrixAverageValuePK + " ]";
    }
    
}
