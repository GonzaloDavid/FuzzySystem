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
@Table(name = "attributesMatrixValue")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AttributesMatrixValue.findAll", query = "SELECT a FROM AttributesMatrixValue a"),
    @NamedQuery(name = "AttributesMatrixValue.findByCodefahp", query = "SELECT a FROM AttributesMatrixValue a WHERE a.attributesMatrixValuePK.codefahp = :codefahp"),
    @NamedQuery(name = "AttributesMatrixValue.findByCodePerson", query = "SELECT a FROM AttributesMatrixValue a WHERE a.attributesMatrixValuePK.codePerson = :codePerson"),
    @NamedQuery(name = "AttributesMatrixValue.findByCodeQuiz", query = "SELECT a FROM AttributesMatrixValue a WHERE a.attributesMatrixValuePK.codeQuiz = :codeQuiz"),
    @NamedQuery(name = "AttributesMatrixValue.findByCodeQuestions", query = "SELECT a FROM AttributesMatrixValue a WHERE a.attributesMatrixValuePK.codeQuestions = :codeQuestions"),
    @NamedQuery(name = "AttributesMatrixValue.findByItemLabel", query = "SELECT a FROM AttributesMatrixValue a WHERE a.attributesMatrixValuePK.itemLabel = :itemLabel"),
    @NamedQuery(name = "AttributesMatrixValue.findByItemLabelCouple", query = "SELECT a FROM AttributesMatrixValue a WHERE a.attributesMatrixValuePK.itemLabelCouple = :itemLabelCouple"),
    @NamedQuery(name = "AttributesMatrixValue.findByDateCreate", query = "SELECT a FROM AttributesMatrixValue a WHERE a.dateCreate = :dateCreate"),
    @NamedQuery(name = "AttributesMatrixValue.findByDateLastModify", query = "SELECT a FROM AttributesMatrixValue a WHERE a.dateLastModify = :dateLastModify"),
    @NamedQuery(name = "AttributesMatrixValue.findByUserCreate", query = "SELECT a FROM AttributesMatrixValue a WHERE a.userCreate = :userCreate"),
    @NamedQuery(name = "AttributesMatrixValue.findByUserLastModify", query = "SELECT a FROM AttributesMatrixValue a WHERE a.userLastModify = :userLastModify")})
public class AttributesMatrixValue implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AttributesMatrixValuePK attributesMatrixValuePK;
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
    @JoinColumn(name = "codePerson", referencedColumnName = "codePerson", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Person person;
    @JoinColumns({
        @JoinColumn(name = "itemLabel", referencedColumnName = "codeQuizItem", insertable = false, updatable = false),
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
    @JoinColumn(name = "valuecriteriaFAHPCat", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private Catalogue valuecriteriaFAHPCat;
    @JoinColumns({
        @JoinColumn(name = "valuecriteriaFAHPCat", referencedColumnName = "codeCatalogue"),
        @JoinColumn(name = "valuecriteriaFAHP", referencedColumnName = "codeItem")})
    @ManyToOne(optional = false)
    private Catalogueitem catalogueitem;

    public AttributesMatrixValue() {
    }

    public AttributesMatrixValue(AttributesMatrixValuePK attributesMatrixValuePK) {
        this.attributesMatrixValuePK = attributesMatrixValuePK;
    }

    public AttributesMatrixValue(AttributesMatrixValuePK attributesMatrixValuePK, Date dateCreate, Date dateLastModify, long userCreate, long userLastModify) {
        this.attributesMatrixValuePK = attributesMatrixValuePK;
        this.dateCreate = dateCreate;
        this.dateLastModify = dateLastModify;
        this.userCreate = userCreate;
        this.userLastModify = userLastModify;
    }

    public AttributesMatrixValue(long codefahp, long codePerson, long codeQuiz, long codeQuestions, long itemLabel, long itemLabelCouple) {
        this.attributesMatrixValuePK = new AttributesMatrixValuePK(codefahp, codePerson, codeQuiz, codeQuestions, itemLabel, itemLabelCouple);
    }

    public AttributesMatrixValuePK getAttributesMatrixValuePK() {
        return attributesMatrixValuePK;
    }

    public void setAttributesMatrixValuePK(AttributesMatrixValuePK attributesMatrixValuePK) {
        this.attributesMatrixValuePK = attributesMatrixValuePK;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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

    public Catalogue getValuecriteriaFAHPCat() {
        return valuecriteriaFAHPCat;
    }

    public void setValuecriteriaFAHPCat(Catalogue valuecriteriaFAHPCat) {
        this.valuecriteriaFAHPCat = valuecriteriaFAHPCat;
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
        hash += (attributesMatrixValuePK != null ? attributesMatrixValuePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AttributesMatrixValue)) {
            return false;
        }
        AttributesMatrixValue other = (AttributesMatrixValue) object;
        if ((this.attributesMatrixValuePK == null && other.attributesMatrixValuePK != null) || (this.attributesMatrixValuePK != null && !this.attributesMatrixValuePK.equals(other.attributesMatrixValuePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.entities.AttributesMatrixValue[ attributesMatrixValuePK=" + attributesMatrixValuePK + " ]";
    }
    
}
