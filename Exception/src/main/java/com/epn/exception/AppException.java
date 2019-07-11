/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.exception;

import com.epn.response.contant.Constant;
import javax.ejb.ApplicationException;

/**
 *
 * @author david
 */
@ApplicationException(rollback = true)
public class AppException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    Integer status;
    int code;
    String link;
    String developerMessage;
    String stackMessage;
    String errorMessageCode;
    String customMessage;

    public AppException(int status, int code, String developerMessage, String errorMessageCode, String link, String stackMessage) {
        super(stackMessage);
        this.status = status;
        this.code = code;
        this.link = link;
        this.developerMessage = developerMessage;
        this.errorMessageCode = errorMessageCode;
        this.stackMessage = stackMessage;
    }

    public AppException(String stackMessage, String errorMessageCode) {
        super(errorMessageCode);
        this.status = Constant.ErrorMessage.CUSTOM_ERROR_CODE;
        this.code = 0;
        this.developerMessage = "Hi, developer. Probably you have an error :(";
        this.link = Constant.Links.LINK_GENERAL;

        this.stackMessage = stackMessage;
        this.errorMessageCode = errorMessageCode;
    }

    public AppException(String developerMessage, String stackMessage, String errorMessageCode) {
        super(errorMessageCode);
        this.status = Constant.ErrorMessage.CUSTOM_ERROR_CODE;
        this.code = 0;
        this.link = Constant.Links.LINK_GENERAL;

        this.developerMessage = developerMessage;
        this.stackMessage = stackMessage;
        this.errorMessageCode = errorMessageCode;
    }

    public AppException(String developerMessage, String stackMessage, String errorMessageCode, String customMessage) {
        super(errorMessageCode);
        this.status = Constant.ErrorMessage.CUSTOM_ERROR_CODE;
        this.code = 0;
        this.link = Constant.Links.LINK_GENERAL;

        this.developerMessage = developerMessage;
        this.stackMessage = stackMessage;
        this.errorMessageCode = errorMessageCode;
        this.customMessage = customMessage;
    }

    public AppException() {
        super("App Exception");
        this.status = Constant.ErrorMessage.CUSTOM_ERROR_CODE;
        this.code = 0;
        this.developerMessage = "Hi, developer. Probably you have an error :(";
        this.link = Constant.Links.LINK_GENERAL;
        this.errorMessageCode = Constant.Message.SERVERERROR;
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

    public String getErrorMessageCode() {
        return errorMessageCode;
    }

    public void setErrorMessageCode(String errorMessageCode) {
        this.errorMessageCode = errorMessageCode;
    }

    public void setStackTrace(String stackTrace) {
        this.stackMessage = stackTrace;
    }

    public String getCustomMessage() {
        return customMessage;
    }

    public void setCustomMessage(String customMessage) {
        this.customMessage = customMessage;
    }

}
