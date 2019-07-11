/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.exception;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.exception.ExceptionUtils;


/**
 *
 * @author david
 */
public class HandleException {
    
    public AppException handleException(String className, Exception e, String message) {
        String causes = discoverCauses(e);
        
        Logger.getLogger(className).log(Level.SEVERE, message + ": " + causes, e);
        return  new AppException(message + ": " + causes, causes, "SERVERERROR");
    }
    
    private String discoverCauses(Throwable e) {
        if (e == null) {
            return "";
        }
        if (e.getMessage()== null) {
            return ExceptionUtils.getStackTrace(e);
        }
        return  e.getMessage() + " ///" + discoverCauses(e.getCause());
    }
    
}