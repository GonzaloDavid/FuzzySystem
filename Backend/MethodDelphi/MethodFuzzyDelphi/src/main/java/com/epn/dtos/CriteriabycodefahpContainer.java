/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

import com.epn.entities.CriteriabycodefahpPK;

/**
 *
 * @author david
 */
public class CriteriabycodefahpContainer {

    private CriteriabycodefahpPK criteriabycodefahpPK;
    private String namecriteria;
    private String criteriaDescription;

    public CriteriabycodefahpContainer() {
    }

    public CriteriabycodefahpContainer(CriteriabycodefahpPK criteriabycodefahpPK, String namecriteria) {
        this.criteriabycodefahpPK = criteriabycodefahpPK;
        this.namecriteria = namecriteria;
    }

    public CriteriabycodefahpPK getCriteriabycodefahpPK() {
        return criteriabycodefahpPK;
    }

    public void setCriteriabycodefahpPK(CriteriabycodefahpPK criteriabycodefahpPK) {
        this.criteriabycodefahpPK = criteriabycodefahpPK;
    }

    public String getNamecriteria() {
        return namecriteria;
    }

    public void setNamecriteria(String namecriteria) {
        this.namecriteria = namecriteria;
    }

    public String getCriteriaDescription() {
        return criteriaDescription;
    }

    public void setCriteriaDescription(String criteriaDescription) {
        this.criteriaDescription = criteriaDescription;
    }

}
