/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

import com.epn.entities.RoundsPK;
import java.util.Date;

/**
 *
 * @author david
 */
public class RoundsContainer {

    private RoundsPK roundsPK;
    private String name;
    private Date dateLastModify;
    private Date dateCreate;

    public RoundsContainer() {
    }

    public RoundsContainer(RoundsPK roundsPK) {
        this.roundsPK = roundsPK;
    }

    public RoundsPK getRoundsPK() {
        return roundsPK;
    }

    public void setRoundsPK(RoundsPK roundsPK) {
        this.roundsPK = roundsPK;
    }

    public Date getDateLastModify() {
        return dateLastModify;
    }

    public void setDateLastModify(Date dateLastModify) {
        this.dateLastModify = dateLastModify;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
