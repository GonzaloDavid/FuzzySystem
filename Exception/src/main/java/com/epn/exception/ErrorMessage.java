/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.exception;


import com.fasterxml.jackson.annotation.JsonProperty;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;

/**
 *
 * @author david
 */
public class ErrorMessage {

    /**
     * Codigo http de error. Se envia tambien el cuerpo para no tener que
     * inspeccionar el header de la llamada
     */
    @JsonProperty Integer status;

    /**
     * Codigo de error especifico de la aplicacion. POR IMPLEMENTAR
     */
    @JsonProperty int code;

    /**
     * Link a documentacion del error. POR IMPLEMENTAR
     */
    @JsonProperty String link;

    /**
     * Mensaje para el desarrollador con el error
     */
    @JsonProperty String developerMessage;

    /**
     * stacktrace del error(no recomendado, se publica logica del negocio)
     */
    @JsonProperty String stackMessage;

    /**
     * Codigo del Mensage de error para hacer peticion a MessageREST
     */
    @JsonProperty String errorMessageCode;
    
    /**
     * Codigo de un mensaje personalizado para el usuario
     */
    @JsonProperty String customMessage;

    public ErrorMessage(AppException ex) {
        this.status = ex.status;
        this.code = ex.code;
        this.link = ex.link;
        this.developerMessage = ex.developerMessage;
        this.stackMessage = ex.getMessage();
        this.errorMessageCode = ex.errorMessageCode;
        this.customMessage = ex.customMessage;
    }

    public ErrorMessage(NotFoundException ex) {
        this.code = 0;
        this.developerMessage = "Error 404. Not Found. :(";
        this.errorMessageCode = "NOT_FOUND";
        this.status = Response.Status.NOT_FOUND.getStatusCode();
        this.stackMessage = ex.getMessage();
        this.link = "https://jersey.java.net/apidocs/2.8/jersey/javax/ws/rs/NotFoundException.html";
    }

    public ErrorMessage() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }

    public String getStackMessage() {
        return stackMessage;
    }

    public void setStackMessage(String stackMessage) {
        this.stackMessage = stackMessage;
    }

    public String getErrorMessageCode() {
        return errorMessageCode;
    }

    public void setErrorMessageCode(String errorMessageCode) {
        this.errorMessageCode = errorMessageCode;
    }

    public String getCustomMessage() {
        return customMessage;
    }

    public void setCustomMessage(String customMessage) {
        this.customMessage = customMessage;
    }
    
}
