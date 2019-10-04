/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.dtos.CriteriaMatrixValueContainer;
import com.epn.entities.CriteriaMatrixValue;
import com.epn.entities.FilterTypes;
import com.epn.entities.SearchObject;
import com.epn.mapper.CriteriaMatrixValueMapper;
import java.util.List;
import javax.ejb.Stateless;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author david
 */
@Stateless
public class CriteriaMatrixValueDAO extends GenericDAO<CriteriaMatrixValue> {

    private final CriteriaMatrixValueMapper personMapper = Mappers.getMapper(CriteriaMatrixValueMapper.class);

    public CriteriaMatrixValueDAO() {
        super(CriteriaMatrixValue.class);
    }

    public List<CriteriaMatrixValueContainer> getMatrixvaluelist(Long codefahp,Long codePerson) {
        SearchObject search = new SearchObject("criteriaMatrixValuePK");
        search.addParameter("criteriaMatrixValuePK.codefahp", FilterTypes.EQUAL, codefahp);
        search.addParameter("criteriaMatrixValuePK.codePerson", FilterTypes.EQUAL, codePerson);
        List<CriteriaMatrixValue> resultList = search(search);
        List<CriteriaMatrixValueContainer> containers = personMapper.sourceListToDestination(resultList);
        return containers;
    }

    public void save(List<CriteriaMatrixValue> criteriaMatrixlist) {
        updateList(criteriaMatrixlist);
    }

}
