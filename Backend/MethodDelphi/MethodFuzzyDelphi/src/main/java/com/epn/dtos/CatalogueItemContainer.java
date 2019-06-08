/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

import com.epn.entities.CatalogueitemPK;

/**
 *
 * @author david
 */
public class CatalogueItemContainer {

    private CatalogueitemPK catalogueitemPK;
    private String nameItem;

    public CatalogueItemContainer() {
    }

    public CatalogueitemPK getCatalogueitemPK() {
        return catalogueitemPK;
    }

    public void setCatalogueitemPK(CatalogueitemPK catalogueitemPK) {
        this.catalogueitemPK = catalogueitemPK;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

}
