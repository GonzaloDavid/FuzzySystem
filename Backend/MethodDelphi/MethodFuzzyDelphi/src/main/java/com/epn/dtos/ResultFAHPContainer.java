/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

import com.epn.entities.ResultFAHPPK;
import java.math.BigDecimal;

/**
 *
 * @author david
 */
public class ResultFAHPContainer {
    private ResultFAHPPK resultFAHPPK;
    private BigDecimal weight;
    private String namequiz;
    private String namequestion;
    private String nameitem;
    private String description;

    public ResultFAHPContainer() {
    }

    public ResultFAHPPK getResultFAHPPK() {
        return resultFAHPPK;
    }

    public void setResultFAHPPK(ResultFAHPPK resultFAHPPK) {
        this.resultFAHPPK = resultFAHPPK;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getNamequiz() {
        return namequiz;
    }

    public void setNamequiz(String namequiz) {
        this.namequiz = namequiz;
    }

    public String getNamequestion() {
        return namequestion;
    }

    public void setNamequestion(String namequestion) {
        this.namequestion = namequestion;
    }

    public String getNameitem() {
        return nameitem;
    }

    public void setNameitem(String nameitem) {
        this.nameitem = nameitem;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
