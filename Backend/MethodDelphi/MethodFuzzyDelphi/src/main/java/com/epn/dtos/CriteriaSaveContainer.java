/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

import com.epn.entities.CriteriaFAHP;
import java.util.List;

/**
 *
 * @author david
 */
public class CriteriaSaveContainer {
    private List<CriteriaFAHP> criterialist;
    private List<CriteriaFAHP> criteriadeletedlist;

    public CriteriaSaveContainer() {
    }

    public CriteriaSaveContainer(List<CriteriaFAHP> criterialist, List<CriteriaFAHP> criteriadeletedlist) {
        this.criterialist = criterialist;
        this.criteriadeletedlist = criteriadeletedlist;
    }

    public List<CriteriaFAHP> getCriterialist() {
        return criterialist;
    }

    public void setCriterialist(List<CriteriaFAHP> criterialist) {
        this.criterialist = criterialist;
    }

    public List<CriteriaFAHP> getCriteriadeletedlist() {
        return criteriadeletedlist;
    }

    public void setCriteriadeletedlist(List<CriteriaFAHP> criteriadeletedlist) {
        this.criteriadeletedlist = criteriadeletedlist;
    }
    
}
