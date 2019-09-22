/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;


import com.epn.entities.Criteria;
import java.util.List;

/**
 *
 * @author david
 */
public class CriteriaSaveContainer {
    private List<Criteria> criterialist;
    private List<Criteria> criteriadeletedlist;

    public CriteriaSaveContainer() {
    }

    public CriteriaSaveContainer(List<Criteria> criterialist, List<Criteria> criteriadeletedlist) {
        this.criterialist = criterialist;
        this.criteriadeletedlist = criteriadeletedlist;
    }

    public List<Criteria> getCriterialist() {
        return criterialist;
    }

    public void setCriterialist(List<Criteria> criterialist) {
        this.criterialist = criterialist;
    }

    public List<Criteria> getCriteriadeletedlist() {
        return criteriadeletedlist;
    }

    public void setCriteriadeletedlist(List<Criteria> criteriadeletedlist) {
        this.criteriadeletedlist = criteriadeletedlist;
    }

 
    
}
