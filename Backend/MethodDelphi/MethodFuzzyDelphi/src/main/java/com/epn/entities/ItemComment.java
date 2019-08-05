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
@Table(name = "itemComment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemComment.findAll", query = "SELECT i FROM ItemComment i"),
    @NamedQuery(name = "ItemComment.findByCodeQuizItem", query = "SELECT i FROM ItemComment i WHERE i.itemCommentPK.codeQuizItem = :codeQuizItem"),
    @NamedQuery(name = "ItemComment.findByCodeQuestions", query = "SELECT i FROM ItemComment i WHERE i.itemCommentPK.codeQuestions = :codeQuestions"),
    @NamedQuery(name = "ItemComment.findByCodeQuiz", query = "SELECT i FROM ItemComment i WHERE i.itemCommentPK.codeQuiz = :codeQuiz"),
    @NamedQuery(name = "ItemComment.findByCodePerson", query = "SELECT i FROM ItemComment i WHERE i.itemCommentPK.codePerson = :codePerson"),
    @NamedQuery(name = "ItemComment.findByCommentary", query = "SELECT i FROM ItemComment i WHERE i.commentary = :commentary"),
    @NamedQuery(name = "ItemComment.findByDateCreate", query = "SELECT i FROM ItemComment i WHERE i.dateCreate = :dateCreate"),
    @NamedQuery(name = "ItemComment.findByDateLastModify", query = "SELECT i FROM ItemComment i WHERE i.dateLastModify = :dateLastModify"),
    @NamedQuery(name = "ItemComment.findByUserCreate", query = "SELECT i FROM ItemComment i WHERE i.userCreate = :userCreate"),
    @NamedQuery(name = "ItemComment.findByUserLastModify", query = "SELECT i FROM ItemComment i WHERE i.userLastModify = :userLastModify")})
public class ItemComment implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItemCommentPK itemCommentPK;
    @Basic(optional = false)
    @Column(name = "commentary")
    private String commentary;
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

    public ItemComment() {
    }

    public ItemComment(ItemCommentPK itemCommentPK) {
        this.itemCommentPK = itemCommentPK;
    }

    public ItemComment(ItemCommentPK itemCommentPK, String commentary, Date dateCreate, Date dateLastModify, long userCreate, long userLastModify) {
        this.itemCommentPK = itemCommentPK;
        this.commentary = commentary;
        this.dateCreate = dateCreate;
        this.dateLastModify = dateLastModify;
        this.userCreate = userCreate;
        this.userLastModify = userLastModify;
    }

    public ItemComment(long codeQuizItem, long codeQuestions, long codeQuiz, long codePerson) {
        this.itemCommentPK = new ItemCommentPK(codeQuizItem, codeQuestions, codeQuiz, codePerson);
    }

    public ItemCommentPK getItemCommentPK() {
        return itemCommentPK;
    }

    public void setItemCommentPK(ItemCommentPK itemCommentPK) {
        this.itemCommentPK = itemCommentPK;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemCommentPK != null ? itemCommentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemComment)) {
            return false;
        }
        ItemComment other = (ItemComment) object;
        if ((this.itemCommentPK == null && other.itemCommentPK != null) || (this.itemCommentPK != null && !this.itemCommentPK.equals(other.itemCommentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.entities.ItemComment[ itemCommentPK=" + itemCommentPK + " ]";
    }
    
}
