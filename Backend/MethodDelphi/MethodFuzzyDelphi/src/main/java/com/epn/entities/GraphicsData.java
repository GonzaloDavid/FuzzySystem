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
 * @author desarrollador
 */
@Entity
@Table(name = "GraphicsData")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GraphicsData.findAll", query = "SELECT g FROM GraphicsData g")
    , @NamedQuery(name = "GraphicsData.findBySeqgraphicsdata", query = "SELECT g FROM GraphicsData g WHERE g.seqgraphicsdata = :seqgraphicsdata")
    , @NamedQuery(name = "GraphicsData.findByXAxisvalues", query = "SELECT g FROM GraphicsData g WHERE g.xAxisvalues = :xAxisvalues")
    , @NamedQuery(name = "GraphicsData.findByYAxisvalues", query = "SELECT g FROM GraphicsData g WHERE g.yAxisvalues = :yAxisvalues")
    , @NamedQuery(name = "GraphicsData.findByDateCreate", query = "SELECT g FROM GraphicsData g WHERE g.dateCreate = :dateCreate")
    , @NamedQuery(name = "GraphicsData.findByDateLastModify", query = "SELECT g FROM GraphicsData g WHERE g.dateLastModify = :dateLastModify")
    , @NamedQuery(name = "GraphicsData.findByUserCreate", query = "SELECT g FROM GraphicsData g WHERE g.userCreate = :userCreate")
    , @NamedQuery(name = "GraphicsData.findByUserLastModify", query = "SELECT g FROM GraphicsData g WHERE g.userLastModify = :userLastModify")})
public class GraphicsData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "seqgraphicsdata")
    private Long seqgraphicsdata;
    @Basic(optional = false)
    @Column(name = "xAxisvalues")
    private String xAxisvalues;
    @Basic(optional = false)
    @Column(name = "yAxisvalues")
    private String yAxisvalues;
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
    @JoinColumn(name = "codeGraphicsParam", referencedColumnName = "codeGraphicsParam")
    @ManyToOne(optional = false)
    private GraphicsParam codeGraphicsParam;
    @JoinColumn(name = "codeQuizItem", referencedColumnName = "codeQuizItem")
    @ManyToOne(optional = false)
    private QuestionItem codeQuizItem;
    @JoinColumn(name = "codeQuestions", referencedColumnName = "codeQuestions")
    @ManyToOne(optional = false)
    private Questions codeQuestions;
    @JoinColumn(name = "codeQuiz", referencedColumnName = "codeQuiz")
    @ManyToOne(optional = false)
    private Quiz codeQuiz;

    public GraphicsData() {
    }

    public GraphicsData(Long seqgraphicsdata) {
        this.seqgraphicsdata = seqgraphicsdata;
    }

    public GraphicsData(Long seqgraphicsdata, String xAxisvalues, String yAxisvalues, Date dateCreate, Date dateLastModify, long userCreate, long userLastModify) {
        this.seqgraphicsdata = seqgraphicsdata;
        this.xAxisvalues = xAxisvalues;
        this.yAxisvalues = yAxisvalues;
        this.dateCreate = dateCreate;
        this.dateLastModify = dateLastModify;
        this.userCreate = userCreate;
        this.userLastModify = userLastModify;
    }

    public Long getSeqgraphicsdata() {
        return seqgraphicsdata;
    }

    public void setSeqgraphicsdata(Long seqgraphicsdata) {
        this.seqgraphicsdata = seqgraphicsdata;
    }

    public String getXAxisvalues() {
        return xAxisvalues;
    }

    public void setXAxisvalues(String xAxisvalues) {
        this.xAxisvalues = xAxisvalues;
    }

    public String getYAxisvalues() {
        return yAxisvalues;
    }

    public void setYAxisvalues(String yAxisvalues) {
        this.yAxisvalues = yAxisvalues;
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

    public GraphicsParam getCodeGraphicsParam() {
        return codeGraphicsParam;
    }

    public void setCodeGraphicsParam(GraphicsParam codeGraphicsParam) {
        this.codeGraphicsParam = codeGraphicsParam;
    }

    public QuestionItem getCodeQuizItem() {
        return codeQuizItem;
    }

    public void setCodeQuizItem(QuestionItem codeQuizItem) {
        this.codeQuizItem = codeQuizItem;
    }

    public Questions getCodeQuestions() {
        return codeQuestions;
    }

    public void setCodeQuestions(Questions codeQuestions) {
        this.codeQuestions = codeQuestions;
    }

    public Quiz getCodeQuiz() {
        return codeQuiz;
    }

    public void setCodeQuiz(Quiz codeQuiz) {
        this.codeQuiz = codeQuiz;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seqgraphicsdata != null ? seqgraphicsdata.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GraphicsData)) {
            return false;
        }
        GraphicsData other = (GraphicsData) object;
        if ((this.seqgraphicsdata == null && other.seqgraphicsdata != null) || (this.seqgraphicsdata != null && !this.seqgraphicsdata.equals(other.seqgraphicsdata))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.entities.GraphicsData[ seqgraphicsdata=" + seqgraphicsdata + " ]";
    }
    
}
