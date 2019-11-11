/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

/**
 *
 * @author david
 */
public class FileObjectB64 {

    private String name;
    private String base64Object;

    public FileObjectB64() {
    }

    public FileObjectB64(String name, String base64Object) {
        this.name = name;
        this.base64Object = base64Object;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBase64Object() {
        return base64Object;
    }

    public void setBase64Object(String base64Object) {
        this.base64Object = base64Object;
    }
    
    

}
