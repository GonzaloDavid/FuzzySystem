/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@Table(name = "environment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Environment.findAll", query = "SELECT e FROM Environment e"),
    @NamedQuery(name = "Environment.findByUri", query = "SELECT e FROM Environment e WHERE e.environmentPK.uri = :uri"),
    @NamedQuery(name = "Environment.findByTypeenvironment", query = "SELECT e FROM Environment e WHERE e.environmentPK.typeenvironment = :typeenvironment"),
    @NamedQuery(name = "Environment.findByPlaceofuse", query = "SELECT e FROM Environment e WHERE e.environmentPK.placeofuse = :placeofuse")})
public class Environment implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EnvironmentPK environmentPK;

    public Environment() {
    }

    public Environment(EnvironmentPK environmentPK) {
        this.environmentPK = environmentPK;
    }

    public Environment(String uri, String typeenvironment, String placeofuse) {
        this.environmentPK = new EnvironmentPK(uri, typeenvironment, placeofuse);
    }

    public EnvironmentPK getEnvironmentPK() {
        return environmentPK;
    }

    public void setEnvironmentPK(EnvironmentPK environmentPK) {
        this.environmentPK = environmentPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (environmentPK != null ? environmentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Environment)) {
            return false;
        }
        Environment other = (Environment) object;
        if ((this.environmentPK == null && other.environmentPK != null) || (this.environmentPK != null && !this.environmentPK.equals(other.environmentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.entities.Environment[ environmentPK=" + environmentPK + " ]";
    }
    
}
