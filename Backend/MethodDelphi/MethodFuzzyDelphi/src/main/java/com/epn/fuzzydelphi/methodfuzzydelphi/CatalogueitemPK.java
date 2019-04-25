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
public class CatalogueitemPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "codeCatalogue")
    private String codeCatalogue;
    @Basic(optional = false)
    @Column(name = "codeItem")
    private String codeItem;

    public CatalogueitemPK() {
    }

    public CatalogueitemPK(String codeCatalogue, String codeItem) {
        this.codeCatalogue = codeCatalogue;
        this.codeItem = codeItem;
    }

    public String getCodeCatalogue() {
        return codeCatalogue;
    }

    public void setCodeCatalogue(String codeCatalogue) {
        this.codeCatalogue = codeCatalogue;
    }

    public String getCodeItem() {
        return codeItem;
    }

    public void setCodeItem(String codeItem) {
        this.codeItem = codeItem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeCatalogue != null ? codeCatalogue.hashCode() : 0);
        hash += (codeItem != null ? codeItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatalogueitemPK)) {
            return false;
        }
        CatalogueitemPK other = (CatalogueitemPK) object;
        if ((this.codeCatalogue == null && other.codeCatalogue != null) || (this.codeCatalogue != null && !this.codeCatalogue.equals(other.codeCatalogue))) {
            return false;
        }
        if ((this.codeItem == null && other.codeItem != null) || (this.codeItem != null && !this.codeItem.equals(other.codeItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.epn.fuzzydelphi.methodfuzzydelphi.CatalogueitemPK[ codeCatalogue=" + codeCatalogue + ", codeItem=" + codeItem + " ]";
    }
    
}
