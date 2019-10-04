/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

import com.epn.entities.CriteriaMatrixValuePK;

/**
 *
 * @author david
 */
public class CriteriaMatrixValueContainer {
    private CriteriaMatrixValuePK criteriaMatrixValuePK;
    private String valuecriteriaFAHPCatt;
    private String valuecriteriaFAHP;

    public CriteriaMatrixValueContainer() {
    }

    public CriteriaMatrixValuePK getCriteriaMatrixValuePK() {
        return criteriaMatrixValuePK;
    }

    public void setCriteriaMatrixValuePK(CriteriaMatrixValuePK criteriaMatrixValuePK) {
        this.criteriaMatrixValuePK = criteriaMatrixValuePK;
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
