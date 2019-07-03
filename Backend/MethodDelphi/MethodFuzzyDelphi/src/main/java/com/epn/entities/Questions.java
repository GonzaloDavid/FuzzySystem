/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author david
 */
@Entity
@Table(name = "Questions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Questions.findAll", query = "SELECT q FROM Questions q"),
    @NamedQuery(name = "Questions.findByCodeQuestions", query = "SELECT q FROM Questions q WHERE q.codeQuestions = :codeQuestions"),
    @NamedQuery(name = "Questions.findByQuestion", query = "SELECT q FROM Questions q WHERE q.question = :question"),
    @NamedQuery(name = "Questions.findByDescription", query = "SELECT q FROM Questions q WHERE q.description = :description"),
    @NamedQuery(name = "Questions.findByStatusCat", query = "SELECT q FROM Questions q WHERE q.statusCat = :statusCat"),
    @NamedQuery(name = "Questions.findByStatus", query = "SELECT q FROM Questions q WHERE q.status = :status"),
    @NamedQuery(name = "Questions.findByDateCreate", query = "SELECT q FROM Questions q WHERE q.dateCreate = :dateCreate"),
    @NamedQuery(name = "Questions.findByDateLastModify", query = "SELECT q FROM Questions q WHERE q.dateLastModify = :dateLastModify"),
    @NamedQuery(name = "Questions.findByUserCreate", query = "SELECT q FROM Questions q WHERE q.userCreate = :userCreate"),
    @NamedQuery(name = "Questions.findByUserLastModify", query = "SELECT q FROM Questions q WHERE q.userLastModify = :userLastModify")})
public class Questions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codeQuestions")
    private Long codeQuestions;
    @Basic(optional = false)
    @Column(name = "question")
    private String question;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "statusCat")
    private String statusCat;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
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
    @JoinColumn(name = "codeQuiz", referencedColumnName = "codeQuiz", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Quiz codeQuiz;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codeQuestions")
    private List<QuestionItem> questionItemList;

    public Questions() {
    }

    public Questions(Long codeQuestions) {
        this.codeQuestions = codeQuestions;
    }

    public Questions(Long codeQuestions, String question, String description, String statusCat, String status, Date dateCreate, Date dateLastModify, long userCreate, long userLastModify) {
        this.codeQuestions = codeQuestions;
        this.question = question;
        this.description = description;
        this.statusCat = statusCat;
        this.status = status;
        this.dateCreate = dateCreate;
        this.dateLastModify = dateLastModify;
        this.userCreate = userCreate;
        this.userLastModify = userLastModify;
    }

    public Long getCodeQuestions() {
        return codeQuestions;
    }

    public void setCodeQuestions(Long codeQuestions) {
        this.codeQuestions = codeQuestions;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatusCat() {
        return statusCat;
    }

    public void setStatusCat(String statusCat) {
        this.statusCat = statusCat;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Quiz getCodeQuiz() {
        return codeQuiz;
    }

    public void setCodeQuiz(Quiz codeQuiz) {
        this.codeQuiz = codeQuiz;
    }

    public List<QuestionItem> getQuestionItemList() {
        return questionItemList;
    }

    public void setQuestionItemList(List<QuestionItem> questionItemList) {
        this.questionItemList = questionItemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeQuestions != null ? codeQuestions.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Questions)) {
            return false;
        }
        Questions other = (Questions) object;
        if ((this.codeQuestions == null && other.codeQuestions != null) || (this.codeQuestions != null && !this.codeQuestions.equals(other.codeQuestions))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.entities.Questions[ codeQuestions=" + codeQuestions + " ]";
    }
    
}
