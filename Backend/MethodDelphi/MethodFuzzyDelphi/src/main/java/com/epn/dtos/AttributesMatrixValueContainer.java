/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

import com.epn.entities.AttributesMatrixValuePK;

/**
 *
 * @author david
 */
public class AttributesMatrixValueContainer {
    private AttributesMatrixValuePK attributesMatrixValuePK;
    private String valuecriteriaFAHPCatt;
    private String valuecriteriaFAHP;

    public AttributesMatrixValueContainer() {
    }

    public AttributesMatrixValuePK getAttributesMatrixValuePK() {
        return attributesMatrixValuePK;
    }

    public void setAttributesMatrixValuePK(AttributesMatrixValuePK attributesMatrixValuePK) {
        this.attributesMatrixValuePK = attributesMatrixValuePK;
    }

    public String getValuecriteriaFAHPCatt() {
        return valuecriteriaFAHPCatt;
    }

    public void setValuecriteriaFAHPCatt(String valuecriteriaFAHPCatt) {
        this.valuecriteriaFAHPCatt = valuecriteriaFAHPCatt;
    }

    public String getValuecriteriaFAHP() {
        return valuecriteriaFAHP;
    }

    public void setValuecriteriaFAHP(String valuecriteriaFAHP) {
        this.valuecriteriaFAHP = valuecriteriaFAHP;
    }
    
}
