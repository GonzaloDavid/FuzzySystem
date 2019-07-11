/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author david
 */
@Provider
public class AppExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception ex) {
        
        
        AppException error = null;
        if (ex instanceof AppException) {
            ex.printStackTrace();
            error = (AppException) ex;
            
        } else {
            HandleException handleException = new HandleException();
            error = handleException.handleException(AppExceptionMapper.class.getName(), ex, "Error encontrado");
        }
        
        return Response.status(error.getStatus())
                .entity(new ErrorMessage(error))
                .type(MediaType.APPLICATION_JSON)
                .build();
        
    }

}
