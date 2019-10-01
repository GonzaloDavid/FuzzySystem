/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

import com.epn.entities.Sentemailbycodefahp;
import java.util.List;

/**
 *
 * @author david
 */
public class SentemailbycodefahpSaveContainer {
    private List<Sentemailbycodefahp> personsselectedlist;
    String descriptionMail;

    public SentemailbycodefahpSaveContainer() {
    }

    public SentemailbycodefahpSaveContainer(List<Sentemailbycodefahp> personsselectedlist, String descriptionMail) {
        this.personsselectedlist = personsselectedlist;
        this.descriptionMail = descriptionMail;
    }

    public List<Sentemailbycodefahp> getPersonsselectedlist() {
        return personsselectedlist;
    }

    public void setPersonsselectedlist(List<Sentemailbycodefahp> personsselectedlist) {
        this.personsselectedlist = personsselectedlist;
    }

    public String getDescriptionMail() {
        return descriptionMail;
    }

    public void setDescriptionMail(String descriptionMail) {
        this.descriptionMail = descriptionMail;
    }
    
    
}
