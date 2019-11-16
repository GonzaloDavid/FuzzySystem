/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

import com.epn.entities.FahpPK;

/**
 *
 * @author david
 */
public class FahpContainer {
    private FahpPK fahpPK;
    private String statusfahpCatt;
    private String statusfahp;
    private String valueFAHPCat;

    public FahpContainer() {
    }

    public FahpPK getFahpPK() {
        return fahpPK;
    }

    public void setFahpPK(FahpPK fahpPK) {
        this.fahpPK = fahpPK;
    }

    public String getStatusfahpCatt() {
        return statusfahpCatt;
    }

    public void setStatusfahpCatt(String statusfahpCatt) {
        this.statusfahpCatt = statusfahpCatt;
    }

    public String getStatusfahp() {
        return statusfahp;
    }

    public void setStatusfahp(String statusfahp) {
        this.statusfahp = statusfahp;
    }

    public String getValueFAHPCat() {
        return valueFAHPCat;
    }

    public void setValueFAHPCat(String valueFAHPCat) {
        this.valueFAHPCat = valueFAHPCat;
    }
    
    
}
