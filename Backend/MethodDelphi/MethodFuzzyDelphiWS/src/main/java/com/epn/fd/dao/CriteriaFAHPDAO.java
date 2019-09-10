/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.dtos.ListAndCountContainer;
import com.epn.entities.CriteriaFAHP;
import com.epn.entities.FilterTypes;
import com.epn.entities.Person;
import com.epn.entities.SearchObject;
import com.epn.exception.AppException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author david
 */
@Stateless
public class CriteriaFAHPDAO extends GenericDAO<CriteriaFAHP> {

    public CriteriaFAHPDAO() {
        super(CriteriaFAHP.class);
    }

    public String getcriteriabycode(Long codeCriteria, Integer from, Integer to) throws JsonProcessingException {
        SearchObject search = new SearchObject("criterialFAHPPK");
        search.addParameter("criterialFAHPPK.codeCriteria", FilterTypes.EQUAL, codeCriteria);
        search.setOrderPropertyName("criterialFAHPPK.codeCriteria");
        search.asc();
        List<CriteriaFAHP> resultList = search(search);
        long count = search(search).size();
        search.setFrom(from);
        search.setTo(to);
        ListAndCountContainer countContainer = new ListAndCountContainer(count, resultList);

        ObjectMapper mapper = new ObjectMapper();
        String response = mapper.writeValueAsString(countContainer);
        return response;
    }

    public List<CriteriaFAHP> save(List<CriteriaFAHP> fAHP) {
        List<CriteriaFAHP> cfahps = new ArrayList();
        updateList(fAHP);
        cfahps = fAHP;
        return cfahps;
    }

    public void deleteCriteria(List<CriteriaFAHP> idlist) {
        idlist.forEach(elementremove -> {
            CriteriaFAHP foundelement = new CriteriaFAHP();
            foundelement = find(elementremove.getCriterialFAHPPK());
            if (foundelement != null) {
                try {
                    remove(foundelement);
                } catch (Exception e) {
                    throw new AppException(e.toString(), "PROBLEMA DE DEPENDENCIAS");
                }
            }
        });
    }
}
