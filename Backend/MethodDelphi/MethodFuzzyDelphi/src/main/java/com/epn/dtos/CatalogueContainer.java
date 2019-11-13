/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author david
 */
public class CatalogueContainer {
    
    private String code;
    private String name;
    private String descripcion;
  //  private List<CatalogueItemContainer> catalogueitemList=new ArrayList();

    public CatalogueContainer() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

 /*   public List<CatalogueItemContainer> getCatalogueitemList() {
        return catalogueitemList;
    }

    public void setCatalogueitemList(List<CatalogueItemContainer> catalogueitemList) {
        this.catalogueitemList = catalogueitemList;
    }
    */
    
}
