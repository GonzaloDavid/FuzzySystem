/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.dtos.ProcessFahpatributebycriteriaContainer;
import com.epn.dtos.ProcessFahpweightbycriteriaContainer;
import com.epn.entities.FilterTypes;
import com.epn.entities.ProcessFahpatributebycriteria;
import com.epn.entities.ProcessFahpweightbycriteria;
import com.epn.entities.SearchObject;
import com.epn.mapper.ProcessFahpweightbycriteriaMapper;
import java.util.List;
import javax.ejb.Stateless;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author david
 */
@Stateless
public class ProcessFahpweightbycriteriaDAO extends GenericDAO<ProcessFahpweightbycriteria> {

    private final ProcessFahpweightbycriteriaMapper mapper = Mappers.getMapper(ProcessFahpweightbycriteriaMapper.class);

    public ProcessFahpweightbycriteriaDAO() {
        super(ProcessFahpweightbycriteria.class);
    }

    public List<ProcessFahpweightbycriteriaContainer> getprocesslistbycodefahp(Long codefahp) {
        SearchObject search = new SearchObject("processFahpweightbycriteriaPK");
        search.addParameter("processFahpweightbycriteriaPK.codefahp", FilterTypes.EQUAL, codefahp);
        search.setOrderPropertyName("processFahpweightbycriteriaPK.codefahp");
        search.asc();

        List<ProcessFahpweightbycriteria> resultList = search(search);
        List<ProcessFahpweightbycriteriaContainer> processcontainer = mapper.sourceListToDestination(resultList);
        return processcontainer;
    }
}
