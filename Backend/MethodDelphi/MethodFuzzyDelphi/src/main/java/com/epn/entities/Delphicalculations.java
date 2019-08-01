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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
 * @author ka
 */
@Entity
@Table(name = "delphicalculations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Delphicalculations.findAll", query = "SELECT d FROM Delphicalculations d")
    , @NamedQuery(name = "Delphicalculations.findBySeqdelphicalculation", query = "SELECT d FROM Delphicalculations d WHERE d.seqdelphicalculation = :seqdelphicalculation")
    , @NamedQuery(name = "Delphicalculations.findByCodeQuiz", query = "SELECT d FROM Delphicalculations d WHERE d.codeQuiz = :codeQuiz")
    , @NamedQuery(name = "Delphicalculations.findByCodeQuestions", query = "SELECT d FROM Delphicalculations d WHERE d.codeQuestions = :codeQuestions")
    , @NamedQuery(name = "Delphicalculations.findByCodeQuizItem", query = "SELECT d FROM Delphicalculations d WHERE d.codeQuizItem = :codeQuizItem")
    , @NamedQuery(name = "Delphicalculations.findByConvergenceIndex", query = "SELECT d FROM Delphicalculations d WHERE d.convergenceIndex = :convergenceIndex")
    , @NamedQuery(name = "Delphicalculations.findByRoundNumber", query = "SELECT d FROM Delphicalculations d WHERE d.roundNumber = :roundNumber")
    , @NamedQuery(name = "Delphicalculations.findByDiscriminator", query = "SELECT d FROM Delphicalculations d WHERE d.discriminator = :discriminator")
    , @NamedQuery(name = "Delphicalculations.findByDateCreate", query = "SELECT d FROM Delphicalculations d WHERE d.dateCreate = :dateCreate")
    , @NamedQuery(name = "Delphicalculations.findByDateLastModify", query = "SELECT d FROM Delphicalculations d WHERE d.dateLastModify = :dateLastModify")
    , @NamedQuery(name = "Delphicalculations.findByUserCreate", query = "SELECT d FROM Delphicalculations d WHERE d.userCreate = :userCreate")
    , @NamedQuery(name = "Delphicalculations.findByUserLastModify", query = "SELECT d FROM Delphicalculations d WHERE d.userLastModify = :userLastModify")
    , @NamedQuery(name = "Delphicalculations.findByLowervalue", query = "SELECT d FROM Delphicalculations d WHERE d.lowervalue = :lowervalue")
    , @NamedQuery(name = "Delphicalculations.findByMediavalue", query = "SELECT d FROM Delphicalculations d WHERE d.mediavalue = :mediavalue")
    , @NamedQuery(name = "Delphicalculations.findByUppervalue", query = "SELECT d FROM Delphicalculations d WHERE d.uppervalue = :uppervalue")})
public class Delphicalculations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "seqdelphicalculation")
    private Long seqdelphicalculation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codeQuiz")
    private long codeQuiz;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codeQuestions")
    private long codeQuestions;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codeQuizItem")
    private long codeQuizItem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "convergenceIndex")
    private double convergenceIndex;
    @Basic(optional = false)
    @NotNull
    @Column(name = "roundNumber")
    private long roundNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "discriminator")
    private double discriminator;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateCreate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateLastModify")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateLastModify;
    @Basic(optional = false)
    @NotNull
    @Column(name = "userCreate")
    private long userCreate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "userLastModify")
    private long userLastModify;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lowervalue")
    private double lowervalue;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "mediavalue")
    private String mediavalue;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "uppervalue")
    private String uppervalue;
    @JoinColumns({
        @JoinColumn(name = "statusResultCat", referencedColumnName = "codeCatalogue")
        , @JoinColumn(name = "statusResult", referencedColumnName = "codeItem")})
    @ManyToOne(optional = false)
    private Catalogueitem catalogueitem;

    public Delphicalculations() {
    }

    public Delphicalculations(Long seqdelphicalculation) {
        this.seqdelphicalculation = seqdelphicalculation;
    }

    public Delphicalculations(Long seqdelphicalculation, long codeQuiz, long codeQuestions, long codeQuizItem, double convergenceIndex, long roundNumber, double discriminator, Date dateCreate, Date dateLastModify, long userCreate, long userLastModify, double lowervalue, String mediavalue, String uppervalue) {
        this.seqdelphicalculation = seqdelphicalculation;
        this.codeQuiz = codeQuiz;
        this.codeQuestions = codeQuestions;
        this.codeQuizItem = codeQuizItem;
        this.convergenceIndex = convergenceIndex;
        this.roundNumber = roundNumber;
        this.discriminator = discriminator;
        this.dateCreate = dateCreate;
        this.dateLastModify = dateLastModify;
        this.userCreate = userCreate;
        this.userLastModify = userLastModify;
        this.lowervalue = lowervalue;
        this.mediavalue = mediavalue;
        this.uppervalue = uppervalue;
    }

    public Long getSeqdelphicalculation() {
        return seqdelphicalculation;
    }

    public void setSeqdelphicalculation(Long seqdelphicalculation) {
        this.seqdelphicalculation = seqdelphicalculation;
    }

    public long getCodeQuiz() {
        return codeQuiz;
    }

    public void setCodeQuiz(long codeQuiz) {
        this.codeQuiz = codeQuiz;
    }

    public long getCodeQuestions() {
        return codeQuestions;
    }

    public void setCodeQuestions(long codeQuestions) {
        this.codeQuestions = codeQuestions;
    }

    public long getCodeQuizItem() {
        return codeQuizItem;
    }

    public void setCodeQuizItem(long codeQuizItem) {
        this.codeQuizItem = codeQuizItem;
    }

    public double getConvergenceIndex() {
        return convergenceIndex;
    }

    public void setConvergenceIndex(double convergenceIndex) {
        this.convergenceIndex = convergenceIndex;
    }

    public long getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(long roundNumber) {
        this.roundNumber = roundNumber;
    }

    public double getDiscriminator() {
        return discriminator;
    }

    public void setDiscriminator(double discriminator) {
        this.discriminator = discriminator;
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

    public double getLowervalue() {
        return lowervalue;
    }

    public void setLowervalue(double lowervalue) {
        this.lowervalue = lowervalue;
    }

    public String getMediavalue() {
        return mediavalue;
    }

    public void setMediavalue(String mediavalue) {
        this.mediavalue = mediavalue;
    }

    public String getUppervalue() {
        return uppervalue;
    }

    public void setUppervalue(String uppervalue) {
        this.uppervalue = uppervalue;
    }

    public Catalogueitem getCatalogueitem() {
        return catalogueitem;
    }

    public void setCatalogueitem(Catalogueitem catalogueitem) {
        this.catalogueitem = catalogueitem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seqdelphicalculation != null ? seqdelphicalculation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Delphicalculations)) {
            return false;
        }
        Delphicalculations other = (Delphicalculations) object;
        if ((this.seqdelphicalculation == null && other.seqdelphicalculation != null) || (this.seqdelphicalculation != null && !this.seqdelphicalculation.equals(other.seqdelphicalculation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.entities.Delphicalculations[ seqdelphicalculation=" + seqdelphicalculation + " ]";
    }
    
}
