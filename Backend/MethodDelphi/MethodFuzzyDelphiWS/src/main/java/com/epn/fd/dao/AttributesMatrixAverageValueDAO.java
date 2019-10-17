/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.entities.AttributesMatrixAverageValue;
import com.epn.entities.FilterTypes;
import com.epn.entities.SearchObject;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author david
 */
@Stateless
public class AttributesMatrixAverageValueDAO extends GenericDAO<AttributesMatrixAverageValue> {

    public AttributesMatrixAverageValueDAO() {
        super(AttributesMatrixAverageValue.class);
    }

    public List<AttributesMatrixAverageValue> getAverageData(Long codefahp) {
        SearchObject search = new SearchObject("attributesMatrixAverageValuePK");
        search.addParameter("attributesMatrixAverageValuePK.codefahp", FilterTypes.EQUAL, codefahp);
        search.setOrderPropertyName("attributesMatrixAverageValuePK.codefahp");
        search.asc();

        List<AttributesMatrixAverageValue> resultList = search(search);
        return resultList;
    }
     public void save(AttributesMatrixAverageValue averageValue)
    {
        update(averageValue);
    }
}
