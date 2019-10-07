/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.dtos.ProcessFahpatributebycriteriaContainer;
import com.epn.entities.FilterTypes;
import com.epn.entities.ProcessFahpatributebycriteria;
import com.epn.entities.SearchObject;
import com.epn.mapper.ProcessFahpatributebycriteriaMapper;
import java.util.List;
import javax.ejb.Stateless;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author david
 */
@Stateless
public class ProcessFahpatributebycriteriaDAO extends GenericDAO<ProcessFahpatributebycriteria> {

    private final ProcessFahpatributebycriteriaMapper mapper = Mappers.getMapper(ProcessFahpatributebycriteriaMapper.class);

    public ProcessFahpatributebycriteriaDAO() {
        super(ProcessFahpatributebycriteria.class);
    }

    public List<ProcessFahpatributebycriteriaContainer> getprocesslistbycodefahp(Long codefahp) {
        SearchObject search = new SearchObject("processFahpatributebycriteriaPK");
        search.addParameter("processFahpatributebycriteriaPK.codefahp", FilterTypes.EQUAL, codefahp);
        search.setOrderPropertyName("processFahpatributebycriteriaPK.codefahp");
        search.asc();

        List<ProcessFahpatributebycriteria> resultList = search(search);
        List<ProcessFahpatributebycriteriaContainer> processcontainer = mapper.sourceListToDestination(resultList);
        return processcontainer;
    }
}
