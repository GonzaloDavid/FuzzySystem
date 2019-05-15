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
public class OrderByProperty {

    private String nameParameter;
    private Boolean asc;
    

    public OrderByProperty(String nameParameter, Boolean asc) {
        this.nameParameter = nameParameter;
        this.asc = asc;
    }
	/**
	 * @return the nameParameter
	 */
	public String getNameParameter() {
		return nameParameter;
	}


	/**
	 * @param nameParameter the nameParameter to set
	 */
	public void setNameParameter(String nameParameter) {
		this.nameParameter = nameParameter;
	}


	/**
	 * @return the asc
	 */
	public Boolean getAsc() {
		return asc;
	}


	/**
	 * @param asc the asc to set
	 */
	public void setAsc(Boolean asc) {
		this.asc = asc;
	}

    
}
