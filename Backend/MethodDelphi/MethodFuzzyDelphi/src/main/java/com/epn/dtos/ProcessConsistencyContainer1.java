/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

import java.util.List;

/**
 *
 * @author david
 */
public class ProcessConsistencyContainer1 {
    private List<Double> totales;

    public ProcessConsistencyContainer1() {
    }

    public ProcessConsistencyContainer1(List<Double> totales) {
        this.totales = totales;
    }

    public List<Double> getTotales() {
        return totales;
    }

    public void setTotales(List<Double> totales) {
        this.totales = totales;
    }
    
}
