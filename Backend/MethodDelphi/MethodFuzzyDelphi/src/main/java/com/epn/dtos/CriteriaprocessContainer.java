/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author david
 */
public class CriteriaprocessContainer {
    
    List<Double> triangularNumber=new ArrayList();
    List<Double> triangularNumberNormalized=new ArrayList();
    Long codefahp;
    Long codecriteria;
    //Long codeperson;
    double defusification;
    double weigth;

    public CriteriaprocessContainer() {
    }

    public List<Double> getTriangularNumber() {
        return triangularNumber;
    }

    public void setTriangularNumber(List<Double> triangularNumber) {
        this.triangularNumber = triangularNumber;
    }

    public Long getCodecriteria() {
        return codecriteria;
    }

    public void setCodecriteria(Long codecriteria) {
        this.codecriteria = codecriteria;
    }

    public List<Double> getTriangularNumberNormalized() {
        return triangularNumberNormalized;
    }

    public void setTriangularNumberNormalized(List<Double> triangularNumberNormalized) {
        this.triangularNumberNormalized = triangularNumberNormalized;
    }

    public double getDefusification() {
        return defusification;
    }

    public void setDefusification(double defusification) {
        this.defusification = defusification;
    }

    public double getWeigth() {
        return weigth;
    }

    public void setWeigth(double weigth) {
        this.weigth = weigth;
    }

    public Long getCodefahp() {
        return codefahp;
    }

    public void setCodefahp(Long codefahp) {
        this.codefahp = codefahp;
    }
    
}
