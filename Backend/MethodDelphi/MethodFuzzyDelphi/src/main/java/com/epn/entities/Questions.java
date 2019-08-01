/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @NamedQuery(name = "Questions.findByCodeQuestions", query = "SELECT q FROM Questions q WHERE q.questionsPK.codeQuestions = :codeQuestions"),
    @NamedQuery(name = "Questions.findByCodeQuiz", query = "SELECT q FROM Questions q WHERE q.questionsPK.codeQuiz = :codeQuiz"),
    @NamedQuery(name = "Questions.findByQuestion", query = "SELECT q FROM Questions q WHERE q.question = :question"),
    @NamedQuery(name = "Questions.findByDescription", query = "SELECT q FROM Questions q WHERE q.description = :description"),
    @NamedQuery(name = "Questions.findByStatusCat", query = "SELECT q FROM Questions q WHERE q.statusCat = :statusCat"),
    @NamedQuery(name = "Questions.findByStatus", query = "SELECT q FROM Questions q WHERE q.status = :status"),
    @NamedQuery(name = "Questions.findByMinimumParameterSetting", query = "SELECT q FROM Questions q WHERE q.minimumParameterSetting = :minimumParameterSetting"),
    @NamedQuery(name = "Questions.findByMaximumParameterSetting", query = "SELECT q FROM Questions q WHERE q.maximumParameterSetting = :maximumParameterSetting"),
    @NamedQuery(name = "Questions.findByJumpNext", query = "SELECT q FROM Questions q WHERE q.jumpNext = :jumpNext"),
    @NamedQuery(name = "Questions.findByDateCreate", query = "SELECT q FROM Questions q WHERE q.dateCreate = :dateCreate"),
    @NamedQuery(name = "Questions.findByDateLastModify", query = "SELECT q FROM Questions q WHERE q.dateLastModify = :dateLastModify"),
    @NamedQuery(name = "Questions.findByUserCreate", query = "SELECT q FROM Questions q WHERE q.userCreate = :userCreate"),
    @NamedQuery(name = "Questions.findByUserLastModify", query = "SELECT q FROM Questions q WHERE q.userLastModify = :userLastModify")})
public class Questions implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected QuestionsPK questionsPK;
    @Basic(optional = false)
    @Size(min = 1, max = 100)
    @Column(name = "question")
    private String question;
    @Basic(optional = false)
    @Size(min = 1, max = 100)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Size(min = 1, max = 100)
    @Column(name = "statusCat")
    private String statusCat;
    @Basic(optional = false)
    @Size(min = 1, max = 100)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @Size(min = 1, max = 100)
    @Column(name = "minimumParameterSetting")
    private String minimumParameterSetting;
    @Basic(optional = false)
    @Size(min = 1, max = 100)
    @Column(name = "maximumParameterSetting")
    private String maximumParameterSetting;
    @Basic(optional = false)
    @Size(min = 1, max = 100)
    @Column(name = "jumpNext")
    private String jumpNext;
    @Column(name = "questionObservation")
    private String questionObservation;
    @Column(name = "diffuseDelphiDiscriminatorbyQuestion")
    private BigDecimal diffuseDelphiDiscriminatorbyQuestion;
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
    private Quiz quiz;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questions")
    private List<QuestionItem> questionItemList;
   // @OneToMany(cascade = CascadeType.ALL, mappedBy = "questions")
  //  private List<Quizvalues> quizvaluesList;

    public Questions() {
    }

    public Questions(QuestionsPK questionsPK) {
        this.questionsPK = questionsPK;
    }

    public Questions(QuestionsPK questionsPK, String question, String description, String statusCat, String status, String minimumParameterSetting, String maximumParameterSetting, String jumpNext, Date dateCreate, Date dateLastModify, long userCreate, long userLastModify) {
        this.questionsPK = questionsPK;
        this.question = question;
        this.description = description;
        this.statusCat = statusCat;
        this.status = status;
        this.minimumParameterSetting = minimumParameterSetting;
        this.maximumParameterSetting = maximumParameterSetting;
        this.jumpNext = jumpNext;
        this.dateCreate = dateCreate;
        this.dateLastModify = dateLastModify;
        this.userCreate = userCreate;
        this.userLastModify = userLastModify;
    }

    public Questions(long codeQuestions, long codeQuiz) {
        this.questionsPK = new QuestionsPK(codeQuestions, codeQuiz);
    }

    public QuestionsPK getQuestionsPK() {
        return questionsPK;
    }

    public void setQuestionsPK(QuestionsPK questionsPK) {
        this.questionsPK = questionsPK;
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

    public String getMinimumParameterSetting() {
        return minimumParameterSetting;
    }

    public void setMinimumParameterSetting(String minimumParameterSetting) {
        this.minimumParameterSetting = minimumParameterSetting;
    }

    public String getMaximumParameterSetting() {
        return maximumParameterSetting;
    }

    public void setMaximumParameterSetting(String maximumParameterSetting) {
        this.maximumParameterSetting = maximumParameterSetting;
    }

    public String getJumpNext() {
        return jumpNext;
    }

    public void setJumpNext(String jumpNext) {
        this.jumpNext = jumpNext;
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

    public List<QuestionItem> getQuestionItemList() {
        return questionItemList;
    }

    public void setQuestionItemList(List<QuestionItem> questionItemList) {
        this.questionItemList = questionItemList;
    }

    public String getQuestionObservation() {
        return questionObservation;
    }

    public void setQuestionObservation(String questionObservation) {
        this.questionObservation = questionObservation;
    }

    public BigDecimal getDiffuseDelphiDiscriminatorbyQuestion() {
        return diffuseDelphiDiscriminatorbyQuestion;
    }

    public void setDiffuseDelphiDiscriminatorbyQuestion(BigDecimal diffuseDelphiDiscriminatorbyQuestion) {
        this.diffuseDelphiDiscriminatorbyQuestion = diffuseDelphiDiscriminatorbyQuestion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (questionsPK != null ? questionsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Questions)) {
            return false;
        }
        Questions other = (Questions) object;
        if ((this.questionsPK == null && other.questionsPK != null) || (this.questionsPK != null && !this.questionsPK.equals(other.questionsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.entities.Questions[ questionsPK=" + questionsPK + " ]";
    }

   /* @XmlTransient
    public List<Quizvalues> getQuizvaluesList() {
        return quizvaluesList;
    }

    public void setQuizvaluesList(List<Quizvalues> quizvaluesList) {
        this.quizvaluesList = quizvaluesList;
    }*/

}
