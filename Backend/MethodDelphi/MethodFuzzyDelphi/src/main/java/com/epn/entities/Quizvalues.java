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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ka
 */
@Entity
@Table(name = "Quizvalues")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Quizvalues.findAll", query = "SELECT q FROM Quizvalues q")
    , @NamedQuery(name = "Quizvalues.findByRoundNumber", query = "SELECT q FROM Quizvalues q WHERE q.quizvaluesPK.roundNumber = :roundNumber")
    , @NamedQuery(name = "Quizvalues.findByCodePerson", query = "SELECT q FROM Quizvalues q WHERE q.quizvaluesPK.codePerson = :codePerson")
    , @NamedQuery(name = "Quizvalues.findByCodeQuiz", query = "SELECT q FROM Quizvalues q WHERE q.quizvaluesPK.codeQuiz = :codeQuiz")
    , @NamedQuery(name = "Quizvalues.findByCodeQuestions", query = "SELECT q FROM Quizvalues q WHERE q.quizvaluesPK.codeQuestions = :codeQuestions")
    , @NamedQuery(name = "Quizvalues.findByCodeQuizItem", query = "SELECT q FROM Quizvalues q WHERE q.quizvaluesPK.codeQuizItem = :codeQuizItem")
    , @NamedQuery(name = "Quizvalues.findByMinimumValue", query = "SELECT q FROM Quizvalues q WHERE q.minimumValue = :minimumValue")
    , @NamedQuery(name = "Quizvalues.findByAverageValue", query = "SELECT q FROM Quizvalues q WHERE q.averageValue = :averageValue")
    , @NamedQuery(name = "Quizvalues.findByMaximunValue", query = "SELECT q FROM Quizvalues q WHERE q.maximunValue = :maximunValue")
    , @NamedQuery(name = "Quizvalues.findByRangeG", query = "SELECT q FROM Quizvalues q WHERE q.rangeG = :rangeG")
    , @NamedQuery(name = "Quizvalues.findByStatusRangeG", query = "SELECT q FROM Quizvalues q WHERE q.statusRangeG = :statusRangeG")
    , @NamedQuery(name = "Quizvalues.findByRangeC", query = "SELECT q FROM Quizvalues q WHERE q.rangeC = :rangeC")
    , @NamedQuery(name = "Quizvalues.findByDistanceGtoC", query = "SELECT q FROM Quizvalues q WHERE q.distanceGtoC = :distanceGtoC")
    , @NamedQuery(name = "Quizvalues.findByValidated", query = "SELECT q FROM Quizvalues q WHERE q.validated = :validated")
    , @NamedQuery(name = "Quizvalues.findByQuizObservation", query = "SELECT q FROM Quizvalues q WHERE q.quizObservation = :quizObservation")
    , @NamedQuery(name = "Quizvalues.findByQuestionObservation", query = "SELECT q FROM Quizvalues q WHERE q.questionObservation = :questionObservation")
    , @NamedQuery(name = "Quizvalues.findByDateCreate", query = "SELECT q FROM Quizvalues q WHERE q.dateCreate = :dateCreate")
    , @NamedQuery(name = "Quizvalues.findByDateLastModify", query = "SELECT q FROM Quizvalues q WHERE q.dateLastModify = :dateLastModify")
    , @NamedQuery(name = "Quizvalues.findByUserCreate", query = "SELECT q FROM Quizvalues q WHERE q.userCreate = :userCreate")
    , @NamedQuery(name = "Quizvalues.findByUserLastModify", query = "SELECT q FROM Quizvalues q WHERE q.userLastModify = :userLastModify")})
public class Quizvalues implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected QuizvaluesPK quizvaluesPK;
    @Basic(optional = false)
    @Size(min = 1, max = 100)
    @Column(name = "minimumValue")
    private String minimumValue;
    @Basic(optional = false)
    @Size(min = 1, max = 100)
    @Column(name = "averageValue")
    private String averageValue;
    @Basic(optional = false)
    @Size(min = 1, max = 100)
    @Column(name = "maximunValue")
    private String maximunValue;
    @Column(name = "rangeG")
    private Double rangeG;
    @Column(name = "statusRangeG")
    private Integer statusRangeG;
    @Column(name = "rangeC")
    private Double rangeC;
    @Column(name = "distanceGtoC")
    private Double distanceGtoC;
    @Column(name = "validated")
    private Integer validated;
    @Size(max = 100)
    @Column(name = "quizObservation")
    private String quizObservation;
    @Size(max = 100)
    @Column(name = "questionObservation")
    private String questionObservation;
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
        @JoinColumn(name = "codeQuizItem", referencedColumnName = "codeQuizItem", insertable = false, updatable = false)
        , @JoinColumn(name = "codeQuestions", referencedColumnName = "codeQuestions", insertable = false, updatable = false)
        , @JoinColumn(name = "codeQuiz", referencedColumnName = "codeQuiz", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private QuestionItem questionItem;
    @JoinColumns({
        @JoinColumn(name = "codeQuestions", referencedColumnName = "codeQuestions", insertable = false, updatable = false)
        , @JoinColumn(name = "codeQuiz", referencedColumnName = "codeQuiz", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Questions questions;
    @JoinColumn(name = "codeQuiz", referencedColumnName = "codeQuiz", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Quiz quiz;
    @JoinColumns({
        @JoinColumn(name = "roundNumber", referencedColumnName = "roundNumber", insertable = false, updatable = false)
        , @JoinColumn(name = "codeQuiz", referencedColumnName = "codeQuiz", insertable = false, updatable = false)
        , @JoinColumn(name = "codePerson", referencedColumnName = "codePerson", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Rounds rounds;

    public Quizvalues() {
    }

    public Quizvalues(QuizvaluesPK quizvaluesPK) {
        this.quizvaluesPK = quizvaluesPK;
    }

    public Quizvalues(QuizvaluesPK quizvaluesPK, String minimumValue, String averageValue, String maximunValue, Date dateCreate, Date dateLastModify, long userCreate, long userLastModify) {
        this.quizvaluesPK = quizvaluesPK;
        this.minimumValue = minimumValue;
        this.averageValue = averageValue;
        this.maximunValue = maximunValue;
        this.dateCreate = dateCreate;
        this.dateLastModify = dateLastModify;
        this.userCreate = userCreate;
        this.userLastModify = userLastModify;
    }

    public Quizvalues(QuizvaluesPK quizvaluesPK, String minimumValue, String averageValue, String maximunValue, Double rangeG, Integer statusRangeG, Double rangeC, Double distanceGtoC, Integer validated, long userCreate, long userLastModify) {
        this.quizvaluesPK = quizvaluesPK;
        this.minimumValue = minimumValue;
        this.averageValue = averageValue;
        this.maximunValue = maximunValue;
        this.rangeG = rangeG;
        this.statusRangeG = statusRangeG;
        this.rangeC = rangeC;
        this.distanceGtoC = distanceGtoC;
        this.validated = validated;
        this.userCreate = userCreate;
        this.userLastModify = userLastModify;
    }

    

    public Quizvalues(long roundNumber, long codePerson, long codeQuiz, long codeQuestions, long codeQuizItem) {
        this.quizvaluesPK = new QuizvaluesPK(roundNumber, codePerson, codeQuiz, codeQuestions, codeQuizItem);
    }

    public QuizvaluesPK getQuizvaluesPK() {
        return quizvaluesPK;
    }

    public void setQuizvaluesPK(QuizvaluesPK quizvaluesPK) {
        this.quizvaluesPK = quizvaluesPK;
    }

    public String getMinimumValue() {
        return minimumValue;
    }

    public void setMinimumValue(String minimumValue) {
        this.minimumValue = minimumValue;
    }

    public String getAverageValue() {
        return averageValue;
    }

    public void setAverageValue(String averageValue) {
        this.averageValue = averageValue;
    }

    public String getMaximunValue() {
        return maximunValue;
    }

    public void setMaximunValue(String maximunValue) {
        this.maximunValue = maximunValue;
    }

    public Double getRangeG() {
        return rangeG;
    }

    public void setRangeG(Double rangeG) {
        this.rangeG = rangeG;
    }

    public Integer getStatusRangeG() {
        return statusRangeG;
    }

    public void setStatusRangeG(Integer statusRangeG) {
        this.statusRangeG = statusRangeG;
    }

    public Double getRangeC() {
        return rangeC;
    }

    public void setRangeC(Double rangeC) {
        this.rangeC = rangeC;
    }

    public Double getDistanceGtoC() {
        return distanceGtoC;
    }

    public void setDistanceGtoC(Double distanceGtoC) {
        this.distanceGtoC = distanceGtoC;
    }

    public Integer getValidated() {
        return validated;
    }

    public void setValidated(Integer validated) {
        this.validated = validated;
    }

    public String getQuizObservation() {
        return quizObservation;
    }

    public void setQuizObservation(String quizObservation) {
        this.quizObservation = quizObservation;
    }

    public String getQuestionObservation() {
        return questionObservation;
    }

    public void setQuestionObservation(String questionObservation) {
        this.questionObservation = questionObservation;
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

    public Rounds getRounds() {
        return rounds;
    }

    public void setRounds(Rounds rounds) {
        this.rounds = rounds;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (quizvaluesPK != null ? quizvaluesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quizvalues)) {
            return false;
        }
        Quizvalues other = (Quizvalues) object;
        if ((this.quizvaluesPK == null && other.quizvaluesPK != null) || (this.quizvaluesPK != null && !this.quizvaluesPK.equals(other.quizvaluesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.entities.Quizvalues[ quizvaluesPK=" + quizvaluesPK + " ]";
    }

}
