/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

import com.epn.entities.CriteriaPK;
import java.util.Date;

/**
 *
 * @author david
 */
public class CriteriaContainer {
    private CriteriaPK criteriaPK;
    private String nameCriteria;
    private String descriptionCriteria;
    private Date dateCreate;
    private Date dateLastModify;
    private long userCreate;
    private long userLastModify;

    public CriteriaContainer() {
    }

    public CriteriaContainer(CriteriaPK criteriaPK, String nameCriteria, String descriptionCriteria, Date dateCreate, Date dateLastModify, long userCreate, long userLastModify) {
        this.criteriaPK = criteriaPK;
        this.nameCriteria = nameCriteria;
        this.descriptionCriteria = descriptionCriteria;
        this.dateCreate = dateCreate;
        this.dateLastModify = dateLastModify;
        this.userCreate = userCreate;
        this.userLastModify = userLastModify;
    }

    public CriteriaPK getCriteriaPK() {
        return criteriaPK;
    }

    public void setCriteriaPK(CriteriaPK criteriaPK) {
        this.criteriaPK = criteriaPK;
    }

    public String getNameCriteria() {
        return nameCriteria;
    }

    public void setNameCriteria(String nameCriteria) {
        this.nameCriteria = nameCriteria;
    }

    public String getDescriptionCriteria() {
        return descriptionCriteria;
    }

    public void setDescriptionCriteria(String descriptionCriteria) {
        this.descriptionCriteria = descriptionCriteria;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateLastModify() {
        return dateLastModify;
    }

    public void setDateLastModify(Date dateLastModify) {
        this.dateLastModify = dateLastModify;
    }

    public long getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(long userCreate) {
        this.userCreate = userCreate;
    }

    public long getUserLastModify() {
        return userLastModify;
    }

    public void setUserLastModify(long userLastModify) {
        this.userLastModify = userLastModify;
    }
    
}
