/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.dtos.ListAndCountContainer;
import com.epn.dtos.PersonContainer;
import com.epn.entities.FilterTypes;
import com.epn.entities.Person;
import com.epn.entities.SearchObject;
import com.epn.exception.AppException;
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
        search.setOrderPropertyName("codePerson");
        search.asc();
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

    public String getpersonbycode(Long codeperson) throws JsonProcessingException {
        SearchObject search = new SearchObject("codePerson");
        search.addParameter("codePerson", FilterTypes.EQUAL, codeperson);

        List<Person> resultList = search(search);
        List<PersonContainer> personContainer = personMapper.sourceListToDestination(resultList);

        ObjectMapper mapper = new ObjectMapper();
        String response = mapper.writeValueAsString(personContainer);
        return response;
    }

    public Person getpersonbycodeperson(Long codeperson) {
        Person person=new Person();
        SearchObject search = new SearchObject("codePerson");
        search.addParameter("codePerson", FilterTypes.EQUAL, codeperson);
        List<Person> resultList = search(search);
        if(resultList.size()>0)
        {
        person=resultList.get(0);
        }
        return person;
    }

    public Person savePerson(Person person) {
        Person p = new Person();
        try {
            update(person);
            p = person;
        } catch (Exception e) {
            throw new AppException(e.toString(), "NO SE GUARDO EXPERTO");
        }
        return p;
    }

    public void deletePerson(List<Person> idlist) {
        idlist.forEach(elementremove -> {
            Person foundelement = new Person();
            foundelement = find(elementremove.getCodePerson());
            try {
                if (foundelement != null) {
                    remove(foundelement);
                }
            } catch (Exception e) {
                throw new AppException(e.toString(), "NO SE ELIMINÓ EXPERTO");
            }

        });

    }

}
