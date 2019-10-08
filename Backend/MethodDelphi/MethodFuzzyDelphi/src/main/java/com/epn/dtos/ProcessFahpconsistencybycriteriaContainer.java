/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

import com.epn.entities.ProcessFahpconsistencybycriteriaPK;
import java.math.BigDecimal;

/**
 *
 * @author david
 */
public class ProcessFahpconsistencybycriteriaContainer {
    
    private ProcessFahpconsistencybycriteriaPK processFahpconsistencybycriteriaPK;
    private BigDecimal indexConsistency;
    private BigDecimal ratioConsistency;
    private BigDecimal consistency;
    private String nameperson;

    public ProcessFahpconsistencybycriteriaContainer() {
    }

    public ProcessFahpconsistencybycriteriaPK getProcessFahpconsistencybycriteriaPK() {
        return processFahpconsistencybycriteriaPK;
    }

    public void setProcessFahpconsistencybycriteriaPK(ProcessFahpconsistencybycriteriaPK processFahpconsistencybycriteriaPK) {
        this.processFahpconsistencybycriteriaPK = processFahpconsistencybycriteriaPK;
    }

    public BigDecimal getIndexConsistency() {
        return indexConsistency;
    }

    public void setIndexConsistency(BigDecimal indexConsistency) {
        this.indexConsistency = indexConsistency;
    }

    public BigDecimal getRatioConsistency() {
        return ratioConsistency;
    }

    public void setRatioConsistency(BigDecimal ratioConsistency) {
        this.ratioConsistency = ratioConsistency;
    }

    public BigDecimal getConsistency() {
        return consistency;
    }

    public void setConsistency(BigDecimal consistency) {
        this.consistency = consistency;
    }

    public String getNameperson() {
        return nameperson;
    }

    public void setNameperson(String nameperson) {
        this.nameperson = nameperson;
    }
    
    
}
