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
public class Item {

    private Integer idExperto; // id del criterio
    private Integer idItem; // id del criterio
    private Double min; // mij
    private Double med; // lij
    private Double max; // uij
    // Validacion de Items o Criterios´
    private Double valorMenor; // Lj
    private Double valorMedio; // Mj
    private Double rangoG; // G(=Uij - Lj)
    private Integer estadoRangoG; // Verdadero o Falso 1 o 0;
    private Double rangoC; // valorAbsoluto(Mj-mij)
    private Integer consensoGC; // Verdadero o Falso 1 o 0;

    // Constructores ===========================================================
    public Item(Integer idExperto, Integer idItem, Double min, Double med, Double max) {
        this.idExperto = idExperto;
        this.idItem = idItem;
        this.min = min;
        this.med = med;
        this.max = max;
    }

    public Integer getIdExperto() {
        return this.idExperto;
    }

    public void setIdExperto(Integer idExperto) {
        this.idExperto = idExperto;
    }

    public Integer getIdItem() {
        return this.idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public Double getMin() {
        return this.min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getMed() {
        return this.med;
    }

    public void setMed(Double med) {
        this.med = med;
    }

    public Double getMax() {
        return this.max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public Double getValorMenor() {
        return this.valorMenor;
    }

    public void setValorMenor(Double valorMenor) {
        this.valorMenor = valorMenor;
    }

    public Double getValorMedio() {
        return this.valorMedio;
    }

    public void setValorMedio(Double valorMedio) {
        this.valorMedio = valorMedio;
    }

    public Double getRangoG() {
        this.rangoG = this.getMax() - this.getMin();
        return this.rangoG;
    }

    public void setRangoG(Double valorRangoG) {
        this.rangoG = valorRangoG;
    }

    public Integer getEstadoRangoG() {
        if (this.getRangoG() > 0) {
            this.estadoRangoG = 1;
        } else {
            this.estadoRangoG = 0;
        }
        return this.estadoRangoG;
    }

    public void setEstadoRangoG(Integer estadoRangoG) {
        this.estadoRangoG = estadoRangoG;
    }

    public Double getRangoC() {
        this.rangoC = Math.abs((this.getMed() - this.getValorMedio()));
        return this.rangoC;
    }

    public void setRangoC(Double rangoC) {
        this.rangoC = rangoC;
    }

    public Integer getConsensoGC() {

        if (this.getRangoG() > this.getRangoC()) {
            this.consensoGC = 1;
        } else {

            this.consensoGC = 0;
        }

        return this.consensoGC;
    }

    public void setConsensoGC(Integer consensoGC) {
        this.consensoGC = consensoGC;
    }

    @Override
    public String toString() {
        return "{" + " idExperto='" + getIdExperto() + "'" + ", idItem='" + getIdItem() + "'" + ", min='" + getMin()
                + "'" + ", med='" + getMed() + "'" + ", max='" + getMax() + "'" + ", valorMenor='" + getValorMenor()
                + "'" + ", valorMedio='" + getValorMedio() + "'" + ", rangoG='" + getRangoG() + "'" + ", estadoRangoG='"
                + getEstadoRangoG() + "'" + ", rangoC='" + getRangoC() + "'" + ", consensoGC='" + getConsensoGC() + "'"
                + "}";
    }

}
