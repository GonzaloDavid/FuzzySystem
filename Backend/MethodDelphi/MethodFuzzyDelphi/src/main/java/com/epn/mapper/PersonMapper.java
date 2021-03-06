/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.mapper;

import com.epn.dtos.PersonContainer;
import com.epn.entities.Person;
import java.util.List;
import org.mapstruct.Mapper;


/**
 *
 * @author david
 */
@Mapper
public interface PersonMapper {
   
    PersonContainer sourceToDestination(Person source);

    List<PersonContainer> sourceListToDestination(List<Person> source);
}
