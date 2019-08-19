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
import javax.validation.constraints.Size;

/**
 *
 * @author david
 */
@Embeddable
public class EnvironmentPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "uri")
    private String uri;
    @Basic(optional = false)
    @NotNull
    @Column(name = "typeenvironment")
    private String typeenvironment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "placeofuse")
    private String placeofuse;

    public EnvironmentPK() {
    }

    public EnvironmentPK(String uri, String typeenvironment, String placeofuse) {
        this.uri = uri;
        this.typeenvironment = typeenvironment;
        this.placeofuse = placeofuse;
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
        int hash = 0;
        hash += (uri != null ? uri.hashCode() : 0);
        hash += (typeenvironment != null ? typeenvironment.hashCode() : 0);
        hash += (placeofuse != null ? placeofuse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnvironmentPK)) {
            return false;
        }
        EnvironmentPK other = (EnvironmentPK) object;
        if ((this.uri == null && other.uri != null) || (this.uri != null && !this.uri.equals(other.uri))) {
            return false;
        }
        if ((this.typeenvironment == null && other.typeenvironment != null) || (this.typeenvironment != null && !this.typeenvironment.equals(other.typeenvironment))) {
            return false;
        }
        if ((this.placeofuse == null && other.placeofuse != null) || (this.placeofuse != null && !this.placeofuse.equals(other.placeofuse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.entities.EnvironmentPK[ uri=" + uri + ", typeenvironment=" + typeenvironment + ", placeofuse=" + placeofuse + " ]";
    }
    
}
