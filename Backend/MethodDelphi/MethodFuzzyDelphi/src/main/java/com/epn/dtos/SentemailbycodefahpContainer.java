/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

import com.epn.entities.SentemailbycodefahpPK;

/**
 *
 * @author david
 */
public class SentemailbycodefahpContainer {
    private SentemailbycodefahpPK sentemailbycodefahpPK;
    private String statussentfahpCatt;
    private String statussentfahp;
    private String nameperson;
    private String namesentfahpstatus;
    public SentemailbycodefahpContainer() {
    }

    public SentemailbycodefahpPK getSentemailbycodefahpPK() {
        return sentemailbycodefahpPK;
    }

    public void setSentemailbycodefahpPK(SentemailbycodefahpPK sentemailbycodefahpPK) {
        this.sentemailbycodefahpPK = sentemailbycodefahpPK;
    }

    public String getStatussentfahpCatt() {
        return statussentfahpCatt;
    }

    public void setStatussentfahpCatt(String statussentfahpCatt) {
        this.statussentfahpCatt = statussentfahpCatt;
    }

    public String getStatussentfahp() {
        return statussentfahp;
    }

    public void setStatussentfahp(String statussentfahp) {
        this.statussentfahp = statussentfahp;
    }

    public String getNameperson() {
        return nameperson;
    }

    public void setNameperson(String nameperson) {
        this.nameperson = nameperson;
    }

    public String getNamesentfahpstatus() {
        return namesentfahpstatus;
    }

    public void setNamesentfahpstatus(String namesentfahpstatus) {
        this.namesentfahpstatus = namesentfahpstatus;
    }
    
    
}
