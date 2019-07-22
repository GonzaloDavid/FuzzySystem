/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@Table(name = "Rounds")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rounds.findAll", query = "SELECT r FROM Rounds r"),
    @NamedQuery(name = "Rounds.findByRoundNumber", query = "SELECT r FROM Rounds r WHERE r.roundsPK.roundNumber = :roundNumber"),
    @NamedQuery(name = "Rounds.findByCodeQuiz", query = "SELECT r FROM Rounds r WHERE r.roundsPK.codeQuiz = :codeQuiz")})
public class Rounds implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RoundsPK roundsPK;
    @JoinColumn(name = "codeQuiz", referencedColumnName = "codeQuiz", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Quiz quiz;

    public Rounds() {
    }

    public Rounds(RoundsPK roundsPK) {
        this.roundsPK = roundsPK;
    }

    public Rounds(long roundNumber, long codeQuiz) {
        this.roundsPK = new RoundsPK(roundNumber, codeQuiz);
    }

    public RoundsPK getRoundsPK() {
        return roundsPK;
    }

    public void setRoundsPK(RoundsPK roundsPK) {
        this.roundsPK = roundsPK;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roundsPK != null ? roundsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rounds)) {
            return false;
        }
        Rounds other = (Rounds) object;
        if ((this.roundsPK == null && other.roundsPK != null) || (this.roundsPK != null && !this.roundsPK.equals(other.roundsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.entities.Rounds[ roundsPK=" + roundsPK + " ]";
    }
    
}
