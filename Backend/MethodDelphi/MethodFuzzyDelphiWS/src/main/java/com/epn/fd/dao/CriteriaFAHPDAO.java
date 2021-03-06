/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.dtos.CriteriaContainer;
import com.epn.dtos.ListAndCountContainer;
import com.epn.entities.Criteria;
import com.epn.entities.FilterTypes;
import com.epn.entities.SearchObject;
import com.epn.exception.AppException;
import com.epn.mapper.CriteriaMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author david
 */
@Stateless
public class CriteriaFAHPDAO extends GenericDAO<Criteria> {

    private final CriteriaMapper mapper = Mappers.getMapper(CriteriaMapper.class);
    public CriteriaFAHPDAO() {
        super(Criteria.class);
    }

    public String getcriteriabycode(Long codeCriteria, Integer from, Integer to) throws JsonProcessingException {
        SearchObject search = new SearchObject("criteriaPK");
        search.addParameter("criteriaPK.codeCriteria", FilterTypes.EQUAL, codeCriteria);
        search.setOrderPropertyName("criteriaPK.codeCriteria");
        search.asc();
        long count = search(search).size();
        search.setFrom(from);
        search.setTo(to);
        List<Criteria> resultList = search(search);
        List<CriteriaContainer> criteriaContainer = mapper.sourceListToDestination(resultList);
        ListAndCountContainer countContainer = new ListAndCountContainer(count, criteriaContainer);

        ObjectMapper mapper = new ObjectMapper();
        String response = mapper.writeValueAsString(countContainer);
        return response;
    }

    public List<Criteria> save(List<Criteria> fAHP) {
        List<Criteria> cfahps = new ArrayList();
        updateList(fAHP);
        cfahps = fAHP;
        return cfahps;
    }

    public void deleteCriteria(List<Criteria> idlist) {
        idlist.forEach(elementremove -> {
            Criteria foundelement = new Criteria();
            foundelement = find(elementremove.getCriteriaPK());
            if (foundelement != null) {
                try {
                    remove(foundelement);
                } catch (Exception e) {
                    throw new AppException(e.toString(),e.toString(), "mysql_forenkey","PROBLEMA DE DEPENDENCIAS");
                }
            }
        });
    }
}
