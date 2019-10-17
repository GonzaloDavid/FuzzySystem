/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

import com.epn.entities.CriteriaMatrixValuePK;
import java.util.List;

/**
 *
 * @author david
 */
public class ProcessConsitencyContainer {

    private CriteriaMatrixValuePK criteriaMatrixValuePK;
    private String valuecriteriaFAHP;
    private List<Double> valuenormalized;

    public ProcessConsitencyContainer() {
    }

    public CriteriaMatrixValuePK getCriteriaMatrixValuePK() {
        return criteriaMatrixValuePK;
    }

    public void setCriteriaMatrixValuePK(CriteriaMatrixValuePK criteriaMatrixValuePK) {
        this.criteriaMatrixValuePK = criteriaMatrixValuePK;
    }

    public String getValuecriteriaFAHP() {
        return valuecriteriaFAHP;
    }

    public void setValuecriteriaFAHP(String valuecriteriaFAHP) {
        this.valuecriteriaFAHP = valuecriteriaFAHP;
    }

    public List<Double> getValuenormalized() {
        return valuenormalized;
    }

    public void setValuenormalized(List<Double> valuenormalized) {
        this.valuenormalized = valuenormalized;
    }
    
}
