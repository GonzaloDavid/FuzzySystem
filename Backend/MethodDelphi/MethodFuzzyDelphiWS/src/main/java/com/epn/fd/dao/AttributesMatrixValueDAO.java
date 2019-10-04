/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.dtos.AttributesMatrixValueContainer;
import com.epn.entities.AttributesMatrixValue;
import com.epn.entities.FilterTypes;
import com.epn.entities.SearchObject;
import com.epn.mapper.AttributesMatrixValueMapper;
import java.util.List;
import javax.ejb.Stateless;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author david
 */
@Stateless
public class AttributesMatrixValueDAO extends GenericDAO<AttributesMatrixValue> {

    private final AttributesMatrixValueMapper matrixValueMapper = Mappers.getMapper(AttributesMatrixValueMapper.class);
    
    public AttributesMatrixValueDAO() {
        super(AttributesMatrixValue.class);
    }
    public List<AttributesMatrixValueContainer> getMatrixvaluelist(Long codefahp,Long codePerson) {
        SearchObject search = new SearchObject("attributesMatrixValuePK");
        search.addParameter("attributesMatrixValuePK.codefahp", FilterTypes.EQUAL, codefahp);
        search.addParameter("attributesMatrixValuePK.codePerson", FilterTypes.EQUAL, codePerson);
        List<AttributesMatrixValue> resultList = search(search);
        List<AttributesMatrixValueContainer> containers = matrixValueMapper.sourceListToDestination(resultList);
        return containers;
    }
    public void save(List<AttributesMatrixValue> attributesMatrixlist)
    {
        updateList(attributesMatrixlist);
    }
}
