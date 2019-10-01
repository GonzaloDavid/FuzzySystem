/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

import com.epn.entities.AttributesMatrixValue;
import com.epn.entities.CriteriaMatrixValue;
import com.epn.entities.SentemailbycodefahpPK;
import java.util.List;

/**
 *
 * @author david
 */
public class AttributeMatrixvalueSaveContainer {

    private SentemailbycodefahpPK sentemailbycodefahp = new SentemailbycodefahpPK();
    private List<CriteriaMatrixValue> criteriaMatrixlist;
    private List<AttributesMatrixValue> attributesMatrixlist;

    public AttributeMatrixvalueSaveContainer() {
    }

    public List<CriteriaMatrixValue> getCriteriaMatrixlist() {
        return criteriaMatrixlist;
    }

    public void setCriteriaMatrixlist(List<CriteriaMatrixValue> criteriaMatrixlist) {
        this.criteriaMatrixlist = criteriaMatrixlist;
    }

    public List<AttributesMatrixValue> getAttributesMatrixlist() {
        return attributesMatrixlist;
    }

    public void setAttributesMatrixlist(List<AttributesMatrixValue> attributesMatrixlist) {
        this.attributesMatrixlist = attributesMatrixlist;
    }

    public SentemailbycodefahpPK getSentemailbycodefahp() {
        return sentemailbycodefahp;
    }

    public void setSentemailbycodefahp(SentemailbycodefahpPK sentemailbycodefahp) {
        this.sentemailbycodefahp = sentemailbycodefahp;
    }
   

}
