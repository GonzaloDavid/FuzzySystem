/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fuzzydelphi.methodfuzzydelphi;

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
 * @author desarrollador
 */
@Entity
@Table(name = "QuestionItem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QuestionItem.findAll", query = "SELECT q FROM QuestionItem q")
    , @NamedQuery(name = "QuestionItem.findByCodeQuizItem", query = "SELECT q FROM QuestionItem q WHERE q.codeQuizItem = :codeQuizItem")
    , @NamedQuery(name = "QuestionItem.findByItem", query = "SELECT q FROM QuestionItem q WHERE q.item = :item")
    , @NamedQuery(name = "QuestionItem.findByStatusItemCat", query = "SELECT q FROM QuestionItem q WHERE q.statusItemCat = :statusItemCat")
    , @NamedQuery(name = "QuestionItem.findByStatusItem", query = "SELECT q FROM QuestionItem q WHERE q.statusItem = :statusItem")
    , @NamedQuery(name = "QuestionItem.findByDateCreate", query = "SELECT q FROM QuestionItem q WHERE q.dateCreate = :dateCreate")
    , @NamedQuery(name = "QuestionItem.findByDateLastModify", query = "SELECT q FROM QuestionItem q WHERE q.dateLastModify = :dateLastModify")
    , @NamedQuery(name = "QuestionItem.findByUserCreate", query = "SELECT q FROM QuestionItem q WHERE q.userCreate = :userCreate")
    , @NamedQuery(name = "QuestionItem.findByUserLastModify", query = "SELECT q FROM QuestionItem q WHERE q.userLastModify = :userLastModify")})
public class QuestionItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codeQuizItem")
    private Long codeQuizItem;
    @Column(name = "item")
    private String item;
    @Column(name = "statusItemCat")
    private String statusItemCat;
    @Column(name = "statusItem")
    private String statusItem;
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

    public QuestionItem(Long codeQuizItem, Date dateCreate, Date dateLastModify, long userCreate, long userLastModify) {
        this.codeQuizItem = codeQuizItem;
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

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getStatusItemCat() {
        return statusItemCat;
    }

    public void setStatusItemCat(String statusItemCat) {
        this.statusItemCat = statusItemCat;
    }

    public String getStatusItem() {
        return statusItem;
    }

    public void setStatusItem(String statusItem) {
        this.statusItem = statusItem;
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
        return "com.epn.fuzzydelphi.methodfuzzydelphi.QuestionItem[ codeQuizItem=" + codeQuizItem + " ]";
    }
    
}
