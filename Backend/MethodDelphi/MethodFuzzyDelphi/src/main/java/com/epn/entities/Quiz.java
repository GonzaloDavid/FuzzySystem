/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@Table(name = "Quiz")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Quiz.findAll", query = "SELECT q FROM Quiz q"),
    @NamedQuery(name = "Quiz.findByCodeQuiz", query = "SELECT q FROM Quiz q WHERE q.quizPK.codeQuiz = :codeQuiz"),
    @NamedQuery(name = "Quiz.findByNameQuiz", query = "SELECT q FROM Quiz q WHERE q.nameQuiz = :nameQuiz"),
    @NamedQuery(name = "Quiz.findByShortNameQuiz", query = "SELECT q FROM Quiz q WHERE q.shortNameQuiz = :shortNameQuiz"),
    @NamedQuery(name = "Quiz.findByDescription", query = "SELECT q FROM Quiz q WHERE q.description = :description"),
    @NamedQuery(name = "Quiz.findByDateCreate", query = "SELECT q FROM Quiz q WHERE q.dateCreate = :dateCreate"),
    @NamedQuery(name = "Quiz.findByDateLastModify", query = "SELECT q FROM Quiz q WHERE q.dateLastModify = :dateLastModify"),
    @NamedQuery(name = "Quiz.findByUserCreate", query = "SELECT q FROM Quiz q WHERE q.userCreate = :userCreate"),
    @NamedQuery(name = "Quiz.findByUserLastModify", query = "SELECT q FROM Quiz q WHERE q.userLastModify = :userLastModify")})
public class Quiz implements Serializable {

   private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected QuizPK quizPK;
    @Basic(optional = false)
    @Column(name = "nameQuiz")
    private String nameQuiz;
    @Basic(optional = false)
    @Column(name = "shortNameQuiz")
    private String shortNameQuiz;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Column(name = "status")
    private String status;
    @Column(name = "statusCat")
    private String statusCat;
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
        @JoinColumn(name = "statusCat", referencedColumnName = "codeCatalogue", insertable = false, updatable = false),
        @JoinColumn(name = "status", referencedColumnName = "codeItem", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Catalogueitem catalogueitem;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "quiz")
    private List<Questions> questionsList;

    public Quiz() {
    }

    public Quiz(QuizPK quizPK) {
        this.quizPK = quizPK;
    }

    public Quiz(QuizPK quizPK, String nameQuiz, String shortNameQuiz, String description, String status, String statusCat, Date dateCreate, Date dateLastModify, long userCreate, long userLastModify, Catalogueitem catalogueitem, List<Questions> questionsList) {
        this.quizPK = quizPK;
        this.nameQuiz = nameQuiz;
        this.shortNameQuiz = shortNameQuiz;
        this.description = description;
        this.status = status;
        this.statusCat = statusCat;
        this.dateCreate = dateCreate;
        this.dateLastModify = dateLastModify;
        this.userCreate = userCreate;
        this.userLastModify = userLastModify;
        this.catalogueitem = catalogueitem;
        this.questionsList = questionsList;
    }

    public QuizPK getQuizPK() {
        return quizPK;
    }

    public void setQuizPK(QuizPK quizPK) {
        this.quizPK = quizPK;
    }

    public String getNameQuiz() {
        return nameQuiz;
    }

    public void setNameQuiz(String nameQuiz) {
        this.nameQuiz = nameQuiz;
    }

    public String getShortNameQuiz() {
        return shortNameQuiz;
    }

    public void setShortNameQuiz(String shortNameQuiz) {
        this.shortNameQuiz = shortNameQuiz;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Catalogueitem getCatalogueitem() {
        return catalogueitem;
    }

    public void setCatalogueitem(Catalogueitem catalogueitem) {
        this.catalogueitem = catalogueitem;
    }

    public List<Questions> getQuestionsList() {
        return questionsList;
    }

    public void setQuestionsList(List<Questions> questionsList) {
        this.questionsList = questionsList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusCat() {
        return statusCat;
    }

    public void setStatusCat(String statusCat) {
        this.statusCat = statusCat;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.quizPK);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Quiz other = (Quiz) obj;
        if (!Objects.equals(this.quizPK, other.quizPK)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Quiz{" + "quizPK=" + quizPK + ", nameQuiz=" + nameQuiz + ", shortNameQuiz=" + shortNameQuiz + ", description=" + description + ", status=" + status + ", statusCat=" + statusCat + ", dateCreate=" + dateCreate + ", dateLastModify=" + dateLastModify + ", userCreate=" + userCreate + ", userLastModify=" + userLastModify + ", catalogueitem=" + catalogueitem + ", questionsList=" + questionsList + '}';
    }
}
