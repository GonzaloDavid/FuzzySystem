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
@Table(name = "GraphicsParam")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GraphicsParam.findAll", query = "SELECT g FROM GraphicsParam g")
    , @NamedQuery(name = "GraphicsParam.findByCodeGraphicsParam", query = "SELECT g FROM GraphicsParam g WHERE g.codeGraphicsParam = :codeGraphicsParam")
    , @NamedQuery(name = "GraphicsParam.findByCodeQuiz", query = "SELECT g FROM GraphicsParam g WHERE g.codeQuiz = :codeQuiz")
    , @NamedQuery(name = "GraphicsParam.findByXAxis", query = "SELECT g FROM GraphicsParam g WHERE g.xAxis = :xAxis")
    , @NamedQuery(name = "GraphicsParam.findByYAxis", query = "SELECT g FROM GraphicsParam g WHERE g.yAxis = :yAxis")
    , @NamedQuery(name = "GraphicsParam.findByDateCreate", query = "SELECT g FROM GraphicsParam g WHERE g.dateCreate = :dateCreate")
    , @NamedQuery(name = "GraphicsParam.findByDateLastModify", query = "SELECT g FROM GraphicsParam g WHERE g.dateLastModify = :dateLastModify")
    , @NamedQuery(name = "GraphicsParam.findByUserCreate", query = "SELECT g FROM GraphicsParam g WHERE g.userCreate = :userCreate")
    , @NamedQuery(name = "GraphicsParam.findByUserLastModify", query = "SELECT g FROM GraphicsParam g WHERE g.userLastModify = :userLastModify")})
public class GraphicsParam implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codeGraphicsParam")
    private String codeGraphicsParam;
    @Basic(optional = false)
    @Column(name = "codeQuiz")
    private long codeQuiz;
    @Basic(optional = false)
    @Column(name = "xAxis")
    private String xAxis;
    @Basic(optional = false)
    @Column(name = "yAxis")
    private String yAxis;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codeGraphicsParam")
    private List<GraphicsData> graphicsDataList;

    public GraphicsParam() {
    }

    public GraphicsParam(String codeGraphicsParam) {
        this.codeGraphicsParam = codeGraphicsParam;
    }

    public GraphicsParam(String codeGraphicsParam, long codeQuiz, String xAxis, String yAxis, Date dateCreate, Date dateLastModify, long userCreate, long userLastModify) {
        this.codeGraphicsParam = codeGraphicsParam;
        this.codeQuiz = codeQuiz;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.dateCreate = dateCreate;
        this.dateLastModify = dateLastModify;
        this.userCreate = userCreate;
        this.userLastModify = userLastModify;
    }

    public String getCodeGraphicsParam() {
        return codeGraphicsParam;
    }

    public void setCodeGraphicsParam(String codeGraphicsParam) {
        this.codeGraphicsParam = codeGraphicsParam;
    }

    public long getCodeQuiz() {
        return codeQuiz;
    }

    public void setCodeQuiz(long codeQuiz) {
        this.codeQuiz = codeQuiz;
    }

    public String getXAxis() {
        return xAxis;
    }

    public void setXAxis(String xAxis) {
        this.xAxis = xAxis;
    }

    public String getYAxis() {
        return yAxis;
    }

    public void setYAxis(String yAxis) {
        this.yAxis = yAxis;
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
    public List<GraphicsData> getGraphicsDataList() {
        return graphicsDataList;
    }

    public void setGraphicsDataList(List<GraphicsData> graphicsDataList) {
        this.graphicsDataList = graphicsDataList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeGraphicsParam != null ? codeGraphicsParam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GraphicsParam)) {
            return false;
        }
        GraphicsParam other = (GraphicsParam) object;
        if ((this.codeGraphicsParam == null && other.codeGraphicsParam != null) || (this.codeGraphicsParam != null && !this.codeGraphicsParam.equals(other.codeGraphicsParam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.fuzzydelphi.methodfuzzydelphi.GraphicsParam[ codeGraphicsParam=" + codeGraphicsParam + " ]";
    }
    
}
