/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.entities.CriteriaMatrixValue;
import javax.ejb.Stateless;

/**
 *
 * @author david
 */
@Stateless
public class CriteriaMatrixValueDAO extends GenericDAO<CriteriaMatrixValue> {
    
     public CriteriaMatrixValueDAO() {
        super(CriteriaMatrixValue.class);
    }
}
