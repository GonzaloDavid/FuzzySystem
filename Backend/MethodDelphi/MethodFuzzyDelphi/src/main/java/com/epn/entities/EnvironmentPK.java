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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 *
 * @author david
 */
@Embeddable
public class EnvironmentPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "seqenvironment")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seqenvironment;

    public EnvironmentPK() {
    }

    public Long getSeqenvironment() {
        return seqenvironment;
    }

    public void setSeqenvironment(Long seqenvironment) {
        this.seqenvironment = seqenvironment;
    }

    @Override
    public String toString() {
        return "EnvironmentPK{" + "seqenvironment=" + seqenvironment + '}';
    }
    

}
