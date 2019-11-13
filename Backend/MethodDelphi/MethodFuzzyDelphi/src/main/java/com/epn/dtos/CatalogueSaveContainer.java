/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

import com.epn.entities.Catalogue;
import com.epn.entities.Catalogueitem;
import java.util.List;

/**
 *
 * @author david
 */
public class CatalogueSaveContainer {
    private Catalogue catalogueobject;
    private List<Catalogueitem> catalogueItemdeleteList;

    public CatalogueSaveContainer() {
    }

    public Catalogue getCatalogueobject() {
        return catalogueobject;
    }

    public void setCatalogueobject(Catalogue catalogueobject) {
        this.catalogueobject = catalogueobject;
    }

    public List<Catalogueitem> getCatalogueItemdeleteList() {
        return catalogueItemdeleteList;
    }

    public void setCatalogueItemdeleteList(List<Catalogueitem> catalogueItemdeleteList) {
        this.catalogueItemdeleteList = catalogueItemdeleteList;
    }
    
    
}
