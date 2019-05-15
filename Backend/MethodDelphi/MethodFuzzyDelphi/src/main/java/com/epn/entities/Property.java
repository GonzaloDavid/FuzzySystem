/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.entities;

/**
 *
 * @author david
 */
public class Property {
    private String nameParameter;
    private FilterTypes type;
    private Object value;

    public Property(String nameParameter, FilterTypes type, Object value) {
        this.nameParameter = nameParameter;
        this.type = type;
        this.value = value;
    }

    public String getNameParameter() {
        return nameParameter;
    }

    public void setNameParameter(String nameParameter) {
        this.nameParameter = nameParameter;
    }

    public FilterTypes getType() {
        return type;
    }

    public void setType(FilterTypes type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
    
    
}
