/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

/**
 *
 * @author ka
 */
public class TriangularFuzzyNumber {
    
   private Long roundNumber;
    
    private Double lowerValue;
    private Double middleValue;
    private Double upperValue;

    public TriangularFuzzyNumber() {
    }

    public TriangularFuzzyNumber(Long roundNumber, Double lowerValue, Double middleValue, Double upperValue) {
        this.roundNumber = roundNumber;
        this.lowerValue = lowerValue;
        this.middleValue = middleValue;
        this.upperValue = upperValue;
    }
    
    public Long getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(Long roundNumber) {
        this.roundNumber = roundNumber;
    }

    public Double getLowerValue() {
        return lowerValue;
    }

    public void setLowerValue(Double lowerValue) {
        this.lowerValue = lowerValue;
    }

    public Double getMiddleValue() {
        return middleValue;
    }

    public void setMiddleValue(Double middleValue) {
        this.middleValue = middleValue;
    }

    public Double getUpperValue() {
        return upperValue;
    }

    public void setUpperValue(Double upperValue) {
        this.upperValue = upperValue;
    }
    
    
    
}
