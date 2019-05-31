/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.dtos.ListAndCountContainer;
import com.epn.dtos.PersonContainer;
import com.epn.entities.Person;
import com.epn.entities.SearchObject;
import com.epn.mapper.PersonMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import javax.ejb.Stateless;
import org.mapstruct.factory.Mappers;



/**
 *
 * @author david
 */
@Stateless
public class PersonDAO extends GenericDAO<Person> {

    public PersonDAO() {
        super(Person.class);
    }
   private final PersonMapper personMapper = Mappers.getMapper(PersonMapper.class);

    public String getallperson(Integer from, Integer to) throws JsonProcessingException {
        SearchObject search = new SearchObject("codePerson");
        //search.addParameter("codePerson.codeCompany", FilterTypes.EQUAL, codeCompany);
        //search.addParameter("regularPhrase", FilterTypes.LIKE, regularPhrase);
        search.setOrderPropertyName("codePerson");
        search.desc();
        long count = search(search).size();
        search.setFrom(from);
        search.setTo(to);

        List<Person> resultList = search(search);
        List<PersonContainer> personContainer = personMapper.sourceListToDestination(resultList);
        ListAndCountContainer patientlistandcount = new ListAndCountContainer(count, personContainer);

        ObjectMapper mapper = new ObjectMapper();
        String response = mapper.writeValueAsString(patientlistandcount);
        return response;
    }
    public Person savePerson(Person person)
    {
        Person p=new Person();
        update(person);
         em.flush();
         p=person;
         return p;
         
    }
}
