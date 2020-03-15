/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @NamedQuery(name = "Environment.findBySeqenvironment", query = "SELECT e FROM Environment e WHERE e.environmentPK = :seqenvironment"),
    @NamedQuery(name = "Environment.findByUri", query = "SELECT e FROM Environment e WHERE e.uri = :uri"),
    @NamedQuery(name = "Environment.findByTypeenvironment", query = "SELECT e FROM Environment e WHERE e.typeenvironment = :typeenvironment"),
    @NamedQuery(name = "Environment.findByPlaceofuse", query = "SELECT e FROM Environment e WHERE e.placeofuse = :placeofuse")})
public class Environment implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected EnvironmentPK environmentPK;
    @Basic(optional = false)
    @Column(name = "uri")
    private String uri;
    @Basic(optional = false)    
    @Column(name = "typeenvironment")
    private String typeenvironment;
    @Basic(optional = false)
    @Column(name = "placeofuse")
    private String placeofuse;

    public Environment() {
    }

    public Environment(EnvironmentPK environmentPK) {
        this.environmentPK = environmentPK;
    }

    public EnvironmentPK getEnvironmentPK() {
        return environmentPK;
    }

    public void setEnvironmentPK(EnvironmentPK environmentPK) {
        this.environmentPK = environmentPK;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getTypeenvironment() {
        return typeenvironment;
    }

    public void setTypeenvironment(String typeenvironment) {
        this.typeenvironment = typeenvironment;
    }

    public String getPlaceofuse() {
        return placeofuse;
    }

    public void setPlaceofuse(String placeofuse) {
        this.placeofuse = placeofuse;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.environmentPK);
        hash = 97 * hash + Objects.hashCode(this.uri);
        hash = 97 * hash + Objects.hashCode(this.typeenvironment);
        hash = 97 * hash + Objects.hashCode(this.placeofuse);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Environment other = (Environment) obj;
        if (!Objects.equals(this.environmentPK, other.environmentPK)) {
            return false;
        }
        if (!Objects.equals(this.uri, other.uri)) {
            return false;
        }
        if (!Objects.equals(this.typeenvironment, other.typeenvironment)) {
            return false;
        }
        if (!Objects.equals(this.placeofuse, other.placeofuse)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Environment{" + "environmentPK=" + environmentPK + ", uri=" + uri + ", typeenvironment=" + typeenvironment + ", placeofuse=" + placeofuse + '}';
    }



    
}
