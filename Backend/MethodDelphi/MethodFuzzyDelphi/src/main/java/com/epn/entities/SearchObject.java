/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author david
 */
public class SearchObject {


    private Integer from;
    private Integer to;
    private String orderPropertyName;
    private Boolean isAscending;
    private List<Property> properties = new ArrayList<>();
    private List<OrderByProperty> orderByProperties = new ArrayList<>();
    private String pathToPK;

    public SearchObject() {
    }

    public SearchObject(Integer from, Integer to, String orderProperyName, Boolean isAscending, String pathToPK) {
        this.from = from;
        this.to = to;
        this.orderPropertyName = orderProperyName;
        this.isAscending = isAscending;
        this.pathToPK = pathToPK;
    }

    public SearchObject(String pathToPK) {

        this.pathToPK = pathToPK;
    }

    public SearchObject addParameter(String parameter, FilterTypes filter, Object value) {
        if (value != null) {
            properties.add(new Property(parameter, filter, value));
        }
        return this;
    }

    public SearchObject addOrderBy(String parameter, Boolean asc) {
        if (parameter != null) {
            orderByProperties.add(new OrderByProperty(parameter, asc));
        }
        return this;
    }

    public SearchObject isNull(String parameter) {
        properties.add(new Property(parameter, FilterTypes.IS_NULL, "IS_NULL"));
        return this;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public String getOrderPropertyName() {
        return orderPropertyName;
    }

    public void setOrderPropertyName(String orderProperyName) {
        this.orderPropertyName = orderProperyName;
    }

    public Boolean isIsAscending() {
        return isAscending;
    }

    public void setIsAscending(Boolean isAscending) {
        this.isAscending = isAscending;
    }

    public String getPathToPK() {
        return pathToPK;
    }

    public void setPathToPK(String pathToPK) {
        this.pathToPK = pathToPK;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public void asc() {
        this.isAscending = true;
    }

    public void desc() {
        this.isAscending = false;
    }

    public List<OrderByProperty> getOrderByProperties() {
        return orderByProperties;
    }

    public void setOrderByProperties(List<OrderByProperty> orderByProperties) {
        this.orderByProperties = orderByProperties;
    }
}
