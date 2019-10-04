/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author david
 */
@Embeddable
public class AttributesMatrixValuePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "codefahp")
    private long codefahp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codePerson")
    private long codePerson;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codeCriteria")
    private long codeCriteria;
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
    @Column(name = "itemLabel")
    private long itemLabel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "itemLabelCouple")
    private long itemLabelCouple;

    public AttributesMatrixValuePK() {
    }

    public AttributesMatrixValuePK(long codefahp, long codePerson, long codeCriteria, long codeQuiz, long codeQuestions, long itemLabel, long itemLabelCouple) {
        this.codefahp = codefahp;
        this.codePerson = codePerson;
        this.codeCriteria = codeCriteria;
        this.codeQuiz = codeQuiz;
        this.codeQuestions = codeQuestions;
        this.itemLabel = itemLabel;
        this.itemLabelCouple = itemLabelCouple;
    }

    public long getCodefahp() {
        return codefahp;
    }

    public void setCodefahp(long codefahp) {
        this.codefahp = codefahp;
    }

    public long getCodePerson() {
        return codePerson;
    }

    public void setCodePerson(long codePerson) {
        this.codePerson = codePerson;
    }

    public long getCodeCriteria() {
        return codeCriteria;
    }

    public void setCodeCriteria(long codeCriteria) {
        this.codeCriteria = codeCriteria;
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

    public long getItemLabel() {
        return itemLabel;
    }

    public void setItemLabel(long itemLabel) {
        this.itemLabel = itemLabel;
    }

    public long getItemLabelCouple() {
        return itemLabelCouple;
    }

    public void setItemLabelCouple(long itemLabelCouple) {
        this.itemLabelCouple = itemLabelCouple;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codefahp;
        hash += (int) codePerson;
        hash += (int) codeCriteria;
        hash += (int) codeQuiz;
        hash += (int) codeQuestions;
        hash += (int) itemLabel;
        hash += (int) itemLabelCouple;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AttributesMatrixValuePK)) {
            return false;
        }
        AttributesMatrixValuePK other = (AttributesMatrixValuePK) object;
        if (this.codefahp != other.codefahp) {
            return false;
        }
        if (this.codePerson != other.codePerson) {
            return false;
        }
        if (this.codeCriteria != other.codeCriteria) {
            return false;
        }
        if (this.codeQuiz != other.codeQuiz) {
            return false;
        }
        if (this.codeQuestions != other.codeQuestions) {
            return false;
        }
        if (this.itemLabel != other.itemLabel) {
            return false;
        }
        if (this.itemLabelCouple != other.itemLabelCouple) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.entities.AttributesMatrixValuePK[ codefahp=" + codefahp + ", codePerson=" + codePerson + ", codeCriteria=" + codeCriteria + ", codeQuiz=" + codeQuiz + ", codeQuestions=" + codeQuestions + ", itemLabel=" + itemLabel + ", itemLabelCouple=" + itemLabelCouple + " ]";
    }
    
}
