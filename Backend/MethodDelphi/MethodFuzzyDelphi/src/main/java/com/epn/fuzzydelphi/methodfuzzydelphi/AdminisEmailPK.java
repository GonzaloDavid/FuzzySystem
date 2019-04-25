/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fuzzydelphi.methodfuzzydelphi;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author desarrollador
 */
@Embeddable
public class AdminisEmailPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "seqadminisemail")
    private long seqadminisemail;
    @Basic(optional = false)
    @Column(name = "codeQuiz")
    private long codeQuiz;
    @Basic(optional = false)
    @Column(name = "codePerson")
    private long codePerson;

    public AdminisEmailPK() {
    }

    public AdminisEmailPK(long seqadminisemail, long codeQuiz, long codePerson) {
        this.seqadminisemail = seqadminisemail;
        this.codeQuiz = codeQuiz;
        this.codePerson = codePerson;
    }

    public long getSeqadminisemail() {
        return seqadminisemail;
    }

    public void setSeqadminisemail(long seqadminisemail) {
        this.seqadminisemail = seqadminisemail;
    }

    public long getCodeQuiz() {
        return codeQuiz;
    }

    public void setCodeQuiz(long codeQuiz) {
        this.codeQuiz = codeQuiz;
    }

    public long getCodePerson() {
        return codePerson;
    }

    public void setCodePerson(long codePerson) {
        this.codePerson = codePerson;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) seqadminisemail;
        hash += (int) codeQuiz;
        hash += (int) codePerson;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdminisEmailPK)) {
            return false;
        }
        AdminisEmailPK other = (AdminisEmailPK) object;
        if (this.seqadminisemail != other.seqadminisemail) {
            return false;
        }
        if (this.codeQuiz != other.codeQuiz) {
            return false;
        }
        if (this.codePerson != other.codePerson) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.fuzzydelphi.methodfuzzydelphi.AdminisEmailPK[ seqadminisemail=" + seqadminisemail + ", codeQuiz=" + codeQuiz + ", codePerson=" + codePerson + " ]";
    }
    
}
