/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

import com.epn.entities.AttributesMatrixValuePK;
import java.util.List;

/**
 *
 * @author david
 */
public class ProcessAttributeContainer {
    private AttributesMatrixValuePK attributesMatrixValuePK;
    private List<Double> tfn;

    public ProcessAttributeContainer() {
    }

    public ProcessAttributeContainer(AttributesMatrixValuePK attributesMatrixValuePK, List<Double> tfn) {
        this.attributesMatrixValuePK = attributesMatrixValuePK;
        this.tfn = tfn;
    }

    public AttributesMatrixValuePK getAttributesMatrixValuePK() {
        return attributesMatrixValuePK;
    }

    public void setAttributesMatrixValuePK(AttributesMatrixValuePK attributesMatrixValuePK) {
        this.attributesMatrixValuePK = attributesMatrixValuePK;
    }

    public List<Double> getTfn() {
        return tfn;
    }

    public void setTfn(List<Double> tfn) {
        this.tfn = tfn;
    }
    
    
}
