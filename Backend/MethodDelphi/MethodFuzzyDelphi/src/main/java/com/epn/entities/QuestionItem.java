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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "QuestionItem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QuestionItem.findAll", query = "SELECT q FROM QuestionItem q"),
    @NamedQuery(name = "QuestionItem.findByCodeQuizItem", query = "SELECT q FROM QuestionItem q WHERE q.codeQuizItem = :codeQuizItem"),
    @NamedQuery(name = "QuestionItem.findByItemLabel", query = "SELECT q FROM QuestionItem q WHERE q.itemLabel = :itemLabel"),
    @NamedQuery(name = "QuestionItem.findByMaximunValue", query = "SELECT q FROM QuestionItem q WHERE q.maximunValue = :maximunValue"),
    @NamedQuery(name = "QuestionItem.findByMinimumValue", query = "SELECT q FROM QuestionItem q WHERE q.minimumValue = :minimumValue"),
    @NamedQuery(name = "QuestionItem.findByAverageValue", query = "SELECT q FROM QuestionItem q WHERE q.averageValue = :averageValue"),
    @NamedQuery(name = "QuestionItem.findByMinimumParameterSetting", query = "SELECT q FROM QuestionItem q WHERE q.minimumParameterSetting = :minimumParameterSetting"),
    @NamedQuery(name = "QuestionItem.findByMaximumParameterSetting", query = "SELECT q FROM QuestionItem q WHERE q.maximumParameterSetting = :maximumParameterSetting"),
    @NamedQuery(name = "QuestionItem.findByJumpNext", query = "SELECT q FROM QuestionItem q WHERE q.jumpNext = :jumpNext"),
    @NamedQuery(name = "QuestionItem.findByDateCreate", query = "SELECT q FROM QuestionItem q WHERE q.dateCreate = :dateCreate"),
    @NamedQuery(name = "QuestionItem.findByDateLastModify", query = "SELECT q FROM QuestionItem q WHERE q.dateLastModify = :dateLastModify"),
    @NamedQuery(name = "QuestionItem.findByUserCreate", query = "SELECT q FROM QuestionItem q WHERE q.userCreate = :userCreate"),
    @NamedQuery(name = "QuestionItem.findByUserLastModify", query = "SELECT q FROM QuestionItem q WHERE q.userLastModify = :userLastModify")})
public class QuestionItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codeQuizItem")
    private Long codeQuizItem;
    @Basic(optional = false)
    @Column(name = "itemLabel")
    private String itemLabel;
    @Column(name = "maximunValue")
    private String maximunValue;
    @Column(name = "minimumValue")
    private String minimumValue;
    @Column(name = "averageValue")
    private String averageValue;
    @Basic(optional = false)
    @Column(name = "minimumParameterSetting")
    private String minimumParameterSetting;
    @Basic(optional = false)
    @Column(name = "maximumParameterSetting")
    private String maximumParameterSetting;
    @Basic(optional = false)
    @Column(name = "jumpNext")
    private String jumpNext;
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
    @JoinColumn(name = "codeQuestions", referencedColumnName = "codeQuestions")
    @ManyToOne(optional = false)
    private Questions codeQuestions;

    public QuestionItem() {
    }

    public QuestionItem(Long codeQuizItem) {
        this.codeQuizItem = codeQuizItem;
    }

    public QuestionItem(Long codeQuizItem, String itemLabel, String minimumParameterSetting, String maximumParameterSetting, String jumpNext, Date dateCreate, Date dateLastModify, long userCreate, long userLastModify) {
        this.codeQuizItem = codeQuizItem;
        this.itemLabel = itemLabel;
        this.minimumParameterSetting = minimumParameterSetting;
        this.maximumParameterSetting = maximumParameterSetting;
        this.jumpNext = jumpNext;
        this.dateCreate = dateCreate;
        this.dateLastModify = dateLastModify;
        this.userCreate = userCreate;
        this.userLastModify = userLastModify;
    }

    public Long getCodeQuizItem() {
        return codeQuizItem;
    }

    public void setCodeQuizItem(Long codeQuizItem) {
        this.codeQuizItem = codeQuizItem;
    }

    public String getItemLabel() {
        return itemLabel;
    }

    public void setItemLabel(String itemLabel) {
        this.itemLabel = itemLabel;
    }

    public String getMaximunValue() {
        return maximunValue;
    }

    public void setMaximunValue(String maximunValue) {
        this.maximunValue = maximunValue;
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

    public Questions getCodeQuestions() {
        return codeQuestions;
    }

    public void setCodeQuestions(Questions codeQuestions) {
        this.codeQuestions = codeQuestions;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeQuizItem != null ? codeQuizItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuestionItem)) {
            return false;
        }
        QuestionItem other = (QuestionItem) object;
        if ((this.codeQuizItem == null && other.codeQuizItem != null) || (this.codeQuizItem != null && !this.codeQuizItem.equals(other.codeQuizItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.entities.QuestionItem[ codeQuizItem=" + codeQuizItem + " ]";
    }
    
}
