/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.entities.AttributesMatrixValue;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author david
 */
@Stateless
public class AttributesMatrixValueDAO extends GenericDAO<AttributesMatrixValue> {

    public AttributesMatrixValueDAO() {
        super(AttributesMatrixValue.class);
    }
    public void save(List<AttributesMatrixValue> attributesMatrixlist)
    {
        updateList(attributesMatrixlist);
    }
}
