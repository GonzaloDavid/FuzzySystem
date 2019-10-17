/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.entities.CriteriaMatrixAverageValue;
import com.epn.entities.FilterTypes;
import com.epn.entities.SearchObject;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author david
 */
@Stateless
public class CriteriaMatrixAverageValueDAO extends GenericDAO<CriteriaMatrixAverageValue> {

    public CriteriaMatrixAverageValueDAO() {
        super(CriteriaMatrixAverageValue.class);
    }

    public List<CriteriaMatrixAverageValue> getAverageData(Long codefahp) {
        SearchObject search = new SearchObject("criteriaMatrixAverageValuePK");
        search.addParameter("criteriaMatrixAverageValuePK.codefahp", FilterTypes.EQUAL, codefahp);
        search.setOrderPropertyName("criteriaMatrixAverageValuePK.codefahp");
        search.asc();

        List<CriteriaMatrixAverageValue> resultList = search(search);
        return resultList;
    }
    public void save(CriteriaMatrixAverageValue averageValue)
    {
        update(averageValue);
    }
}
