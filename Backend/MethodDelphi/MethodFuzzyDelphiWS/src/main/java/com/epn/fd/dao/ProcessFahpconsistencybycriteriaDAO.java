/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.dtos.ProcessFahpconsistencybycriteriaContainer;
import com.epn.entities.FilterTypes;
import com.epn.entities.ProcessFahpconsistencybycriteria;
import com.epn.entities.SearchObject;
import com.epn.mapper.ProcessFahpconsistencybycriteriaMapper;
import java.util.List;
import javax.ejb.Stateless;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author david
 */
@Stateless
public class ProcessFahpconsistencybycriteriaDAO extends GenericDAO<ProcessFahpconsistencybycriteria> {

    private final ProcessFahpconsistencybycriteriaMapper mapper = Mappers.getMapper(ProcessFahpconsistencybycriteriaMapper.class);

    public ProcessFahpconsistencybycriteriaDAO() {
        super(ProcessFahpconsistencybycriteria.class);
    }

    public List<ProcessFahpconsistencybycriteriaContainer> getconsistencybycodefahp(Long codefahp) {
        SearchObject search = new SearchObject("processFahpconsistencybycriteriaPK");
        search.addParameter("processFahpconsistencybycriteriaPK.codefahp", FilterTypes.EQUAL, codefahp);
        search.setOrderPropertyName("processFahpconsistencybycriteriaPK.codefahp");
        search.asc();

        List<ProcessFahpconsistencybycriteria> resultList = search(search);
        List<ProcessFahpconsistencybycriteriaContainer> container = mapper.sourceListToDestination(resultList);
        return container;
    }
}
