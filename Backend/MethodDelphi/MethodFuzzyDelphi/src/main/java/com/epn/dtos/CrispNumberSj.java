/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

import java.math.BigInteger;

/**
 *
 * @author ka
 */
public class CrispNumberSj {

    private Integer idItem;
    private BigInteger codeQuestions;
    private Double indiceSj;
    private Double determinante;
    private Integer estado;
    private String mensaje;

    protected static String ACEPTADO = "ACEPTADO";
    protected static String DESCARTADO = "DESCARTADO";

    // Constructores =====================
    public CrispNumberSj() {

    }

    public CrispNumberSj(Integer idItem, Double indiceSj, Double determinante) {
        this.idItem = idItem;
        this.indiceSj = indiceSj;
        this.determinante = determinante;
    }

    public CrispNumberSj(Integer idItem, Double indiceSj, Double determinante, Integer estado, String mensaje) {
        this.idItem = idItem;
        this.indiceSj = indiceSj;
        this.determinante = determinante;
        this.estado = estado;
        this.mensaje = mensaje;
    }
    // Getters and Setters ======================

    public BigInteger getCodeQuestions() {
        return codeQuestions;
    }

    public void setCodeQuestions(BigInteger codeQuestions) {
        this.codeQuestions = codeQuestions;
    }

    public Integer getIdItem() {
        return this.idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public Double getIndiceSj() {
        return this.indiceSj;
    }

    public void setIndiceSj(Double indiceSj) {
        this.indiceSj = indiceSj;
    }

    public Double getDeterminante() {
        return this.determinante;
    }

    public void setDeterminante(Double determinante) {
        this.determinante = determinante;
    }

    public Integer getEstado() {
        if (getIndiceSj() >= getDeterminante()) {
            this.estado = 1;
        } else {
            this.estado = 0;
        }
        return this.estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getMensaje() {
        if (this.estado == 1) {
            this.mensaje = ACEPTADO;
        } else {
            this.mensaje = DESCARTADO;
        }
        return this.mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "{" + " idItem='" + getIdItem() + "'" + ", indiceSj='" + getIndiceSj() + "'" + ", determinante='"
                + getDeterminante() + "'" + ", estado='" + getEstado() + "'" + ", mensaje='" + getMensaje() + "'" + "}";
    }
}
