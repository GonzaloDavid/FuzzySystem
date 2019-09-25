/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.dtos.CriteriabycodefahpContainer;
import com.epn.entities.Criteriabycodefahp;
import com.epn.entities.Fahp;
import com.epn.entities.FilterTypes;
import com.epn.entities.SearchObject;
import com.epn.mapper.CriteriabycodefahpMapper;
import java.util.List;
import javax.ejb.Stateless;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author david
 */
@Stateless
public class CriteriabycodefahpDAO extends GenericDAO<Criteriabycodefahp> {

    private final CriteriabycodefahpMapper mapper = Mappers.getMapper(CriteriabycodefahpMapper.class);

    public CriteriabycodefahpDAO() {
        super(Criteriabycodefahp.class);
    }

    public void savecriteriafahp(List<Criteriabycodefahp> criterialist) {
        updateList(criterialist);
    }

    public List<CriteriabycodefahpContainer> getcriteriabycodefahp(Long codefahp) {
        SearchObject search = new SearchObject("criteriabycodefahpPK");
        search.addParameter("criteriabycodefahpPK.codefahp", FilterTypes.EQUAL, codefahp);
        List<Criteriabycodefahp> resultList = search(search);
        List<CriteriabycodefahpContainer> criteriaContainer = mapper.sourceListToDestination(resultList);
        return criteriaContainer;
    }

}
