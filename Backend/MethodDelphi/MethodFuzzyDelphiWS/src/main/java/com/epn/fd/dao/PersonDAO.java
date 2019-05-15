/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.dtos.ListAndCountContainer;
import com.epn.entities.Person;
import com.epn.entities.SearchObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author david
 */
@Stateless
public class PersonDAO extends GenericDAO<Person> {

    public PersonDAO() {
        super(Person.class);
    }

    public String getallperson(Integer to, Integer from)  throws JsonProcessingException {
                    
        SearchObject search = new SearchObject("codePerson");
 //     search.addParameter("codePerson.codeCompany", FilterTypes.EQUAL, codeCompany);
 //     search.addParameter("regularPhrase", FilterTypes.LIKE, regularPhrase);
        search.setOrderPropertyName("codePerson");
        search.desc();
        long count = search(search).size();
        search.setFrom(from);
        search.setTo(to);

        List<Person> resultList = search(search);
        
        ListAndCountContainer patientlistandcount = new ListAndCountContainer(count, resultList);
        ObjectMapper mapper = new ObjectMapper();
        String response = mapper.writeValueAsString(patientlistandcount);
        return response;

    }
}
