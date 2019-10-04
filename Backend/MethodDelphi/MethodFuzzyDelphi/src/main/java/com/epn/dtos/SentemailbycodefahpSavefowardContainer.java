/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

import com.epn.entities.Sentemailbycodefahp;

/**
 *
 * @author david
 */
public class SentemailbycodefahpSavefowardContainer {
    private Sentemailbycodefahp sentemailbycodefahp=new Sentemailbycodefahp();
    private String messageMail;

    public SentemailbycodefahpSavefowardContainer() {
    }

    public Sentemailbycodefahp getSentemailbycodefahp() {
        return sentemailbycodefahp;
    }

    public void setSentemailbycodefahp(Sentemailbycodefahp sentemailbycodefahp) {
        this.sentemailbycodefahp = sentemailbycodefahp;
    }

    public String getMessageMail() {
        return messageMail;
    }

    public void setMessageMail(String messageMail) {
        this.messageMail = messageMail;
    }
    
}
