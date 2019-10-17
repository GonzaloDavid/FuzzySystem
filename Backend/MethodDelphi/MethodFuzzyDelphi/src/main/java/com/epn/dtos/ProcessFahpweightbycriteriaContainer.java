/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

import com.epn.entities.ProcessFahpweightbycriteriaPK;
import java.math.BigDecimal;

/**
 *
 * @author david
 */
public class ProcessFahpweightbycriteriaContainer {

    private ProcessFahpweightbycriteriaPK processFahpweightbycriteriaPK;
    private String namecriteria;
    private String criteriadescription;
    private BigDecimal weight;

    public ProcessFahpweightbycriteriaContainer() {
    }

    public ProcessFahpweightbycriteriaPK getProcessFahpweightbycriteriaPK() {
        return processFahpweightbycriteriaPK;
    }

    public void setProcessFahpweightbycriteriaPK(ProcessFahpweightbycriteriaPK processFahpweightbycriteriaPK) {
        this.processFahpweightbycriteriaPK = processFahpweightbycriteriaPK;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getNamecriteria() {
        return namecriteria;
    }

    public void setNamecriteria(String namecriteria) {
        this.namecriteria = namecriteria;
    }

    public String getCriteriadescription() {
        return criteriadescription;
    }

    public void setCriteriadescription(String criteriadescription) {
        this.criteriadescription = criteriadescription;
    }
    
}
