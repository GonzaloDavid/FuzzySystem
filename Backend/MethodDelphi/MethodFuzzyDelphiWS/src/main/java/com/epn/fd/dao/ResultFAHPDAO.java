/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.dtos.ResultFAHPContainer;
import com.epn.entities.FilterTypes;
import com.epn.entities.ResultFAHP;
import com.epn.entities.SearchObject;
import com.epn.mapper.ResultFAHPMapper;
import java.util.List;
import javax.ejb.Stateless;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author david
 */
@Stateless
public class ResultFAHPDAO extends GenericDAO<ResultFAHP> {

    private final ResultFAHPMapper rfahpm = Mappers.getMapper(ResultFAHPMapper.class);

    public ResultFAHPDAO() {
        super(ResultFAHP.class);
    }

    public List<ResultFAHPContainer> getresultbycode(Long codefahp) {
        SearchObject search = new SearchObject("resultFAHPPK");
        search.addParameter("resultFAHPPK.codefahp", FilterTypes.EQUAL, codefahp);
        search.setOrderPropertyName("resultFAHPPK.codefahp");
        search.asc();

        List<ResultFAHP> resultList = search(search);
        List<ResultFAHPContainer> fAHPContainers = rfahpm.sourceListToDestination(resultList);
        return fAHPContainers;
    }
    public void save(ResultFAHP resultFAHP){
        update(resultFAHP);
    }
}
