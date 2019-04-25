/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fuzzydelphi.methodfuzzydelphi;

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
 * @author desarrollador
 */
@Entity
@Table(name = "Quiz")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Quiz.findAll", query = "SELECT q FROM Quiz q")
    , @NamedQuery(name = "Quiz.findByCodeQuiz", query = "SELECT q FROM Quiz q WHERE q.codeQuiz = :codeQuiz")
    , @NamedQuery(name = "Quiz.findByDescription", query = "SELECT q FROM Quiz q WHERE q.description = :description")
    , @NamedQuery(name = "Quiz.findByStatusCat", query = "SELECT q FROM Quiz q WHERE q.statusCat = :statusCat")
    , @NamedQuery(name = "Quiz.findByStatus", query = "SELECT q FROM Quiz q WHERE q.status = :status")
    , @NamedQuery(name = "Quiz.findByDateCreate", query = "SELECT q FROM Quiz q WHERE q.dateCreate = :dateCreate")
    , @NamedQuery(name = "Quiz.findByDateLastModify", query = "SELECT q FROM Quiz q WHERE q.dateLastModify = :dateLastModify")
    , @NamedQuery(name = "Quiz.findByUserCreate", query = "SELECT q FROM Quiz q WHERE q.userCreate = :userCreate")
    , @NamedQuery(name = "Quiz.findByUserLastModify", query = "SELECT q FROM Quiz q WHERE q.userLastModify = :userLastModify")})
public class Quiz implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codeQuiz")
    private Long codeQuiz;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Column(name = "statusCat")
    private String statusCat;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "quiz")
    private List<AdminisEmail> adminisEmailList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codeQuiz")
    private List<DelphiCalculations> delphiCalculationsList;

    public Quiz() {
    }

    public Quiz(Long codeQuiz) {
        this.codeQuiz = codeQuiz;
    }

    public Quiz(Long codeQuiz, String description, Date dateCreate, Date dateLastModify, long userCreate, long userLastModify) {
        this.codeQuiz = codeQuiz;
        this.description = description;
        this.dateCreate = dateCreate;
        this.dateLastModify = dateLastModify;
        this.userCreate = userCreate;
        this.userLastModify = userLastModify;
    }

    public Long getCodeQuiz() {
        return codeQuiz;
    }

    public void setCodeQuiz(Long codeQuiz) {
        this.codeQuiz = codeQuiz;
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

    @XmlTransient
    public List<AdminisEmail> getAdminisEmailList() {
        return adminisEmailList;
    }

    public void setAdminisEmailList(List<AdminisEmail> adminisEmailList) {
        this.adminisEmailList = adminisEmailList;
    }

    @XmlTransient
    public List<DelphiCalculations> getDelphiCalculationsList() {
        return delphiCalculationsList;
    }

    public void setDelphiCalculationsList(List<DelphiCalculations> delphiCalculationsList) {
        this.delphiCalculationsList = delphiCalculationsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeQuiz != null ? codeQuiz.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quiz)) {
            return false;
        }
        Quiz other = (Quiz) object;
        if ((this.codeQuiz == null && other.codeQuiz != null) || (this.codeQuiz != null && !this.codeQuiz.equals(other.codeQuiz))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.fuzzydelphi.methodfuzzydelphi.Quiz[ codeQuiz=" + codeQuiz + " ]";
    }
    
}
