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
@Table(name = "resultFAHP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResultFAHP.findAll", query = "SELECT r FROM ResultFAHP r"),
    @NamedQuery(name = "ResultFAHP.findByCodeQuiz", query = "SELECT r FROM ResultFAHP r WHERE r.resultFAHPPK.codeQuiz = :codeQuiz"),
    @NamedQuery(name = "ResultFAHP.findByCodeQuestions", query = "SELECT r FROM ResultFAHP r WHERE r.resultFAHPPK.codeQuestions = :codeQuestions"),
    @NamedQuery(name = "ResultFAHP.findByCodeQuizItem", query = "SELECT r FROM ResultFAHP r WHERE r.resultFAHPPK.codeQuizItem = :codeQuizItem"),
    @NamedQuery(name = "ResultFAHP.findByValuepriority", query = "SELECT r FROM ResultFAHP r WHERE r.valuepriority = :valuepriority"),
    @NamedQuery(name = "ResultFAHP.findByDateCreate", query = "SELECT r FROM ResultFAHP r WHERE r.dateCreate = :dateCreate"),
    @NamedQuery(name = "ResultFAHP.findByDateLastModify", query = "SELECT r FROM ResultFAHP r WHERE r.dateLastModify = :dateLastModify"),
    @NamedQuery(name = "ResultFAHP.findByUserCreate", query = "SELECT r FROM ResultFAHP r WHERE r.userCreate = :userCreate"),
    @NamedQuery(name = "ResultFAHP.findByUserLastModify", query = "SELECT r FROM ResultFAHP r WHERE r.userLastModify = :userLastModify")})
public class ResultFAHP implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ResultFAHPPK resultFAHPPK;
    @Basic(optional = false)
    @Column(name = "valuepriority")
    private String valuepriority;
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

    public ResultFAHP() {
    }

    public ResultFAHP(ResultFAHPPK resultFAHPPK) {
        this.resultFAHPPK = resultFAHPPK;
    }

    public ResultFAHP(ResultFAHPPK resultFAHPPK, String valuepriority, Date dateCreate, Date dateLastModify, long userCreate, long userLastModify) {
        this.resultFAHPPK = resultFAHPPK;
        this.valuepriority = valuepriority;
        this.dateCreate = dateCreate;
        this.dateLastModify = dateLastModify;
        this.userCreate = userCreate;
        this.userLastModify = userLastModify;
    }

    public ResultFAHP(long codeQuiz, long codeQuestions, long codeQuizItem) {
        this.resultFAHPPK = new ResultFAHPPK(codeQuiz, codeQuestions, codeQuizItem);
    }

    public ResultFAHPPK getResultFAHPPK() {
        return resultFAHPPK;
    }

    public void setResultFAHPPK(ResultFAHPPK resultFAHPPK) {
        this.resultFAHPPK = resultFAHPPK;
    }

    public String getValuepriority() {
        return valuepriority;
    }

    public void setValuepriority(String valuepriority) {
        this.valuepriority = valuepriority;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resultFAHPPK != null ? resultFAHPPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResultFAHP)) {
            return false;
        }
        ResultFAHP other = (ResultFAHP) object;
        if ((this.resultFAHPPK == null && other.resultFAHPPK != null) || (this.resultFAHPPK != null && !this.resultFAHPPK.equals(other.resultFAHPPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.entities.ResultFAHP[ resultFAHPPK=" + resultFAHPPK + " ]";
    }
    
}
