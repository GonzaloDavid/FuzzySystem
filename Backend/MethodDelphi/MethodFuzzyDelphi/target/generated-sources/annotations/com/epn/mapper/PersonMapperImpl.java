package com.epn.mapper;

import com.epn.dtos.PersonContainer;

import com.epn.entities.AdminisEmail;

import com.epn.entities.Person;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Generated;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2019-05-30T19:21:20-0500",

    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"

)

public class PersonMapperImpl implements PersonMapper {

    @Override

    public PersonContainer sourceToDestination(Person source) {

        if ( source == null ) {

            return null;
        }

        PersonContainer personContainer = new PersonContainer();

        List<AdminisEmail> list = source.getAdminisEmailList();

        if ( list != null ) {

            personContainer.setAdminisEmailList(       new ArrayList<AdminisEmail>( list )

            );
        }

        personContainer.setTypePersonCat( source.getTypePersonCat() );

        personContainer.setTypePerson( source.getTypePerson() );

        personContainer.setTypeIdentifyCat( source.getTypeIdentifyCat() );

        personContainer.setTypeIdentify( source.getTypeIdentify() );

        personContainer.setAcademicDegreeCat( source.getAcademicDegreeCat() );

        personContainer.setAcademicDegree( source.getAcademicDegree() );

        personContainer.setCountryCat( source.getCountryCat() );

        personContainer.setCountry( source.getCountry() );

        personContainer.setStatusCat( source.getStatusCat() );

        personContainer.setStatus( source.getStatus() );

        personContainer.setCodePerson( source.getCodePerson() );

        personContainer.setIdentify( source.getIdentify() );

        personContainer.setFirstName( source.getFirstName() );

        personContainer.setMiddleName( source.getMiddleName() );

        personContainer.setLastName( source.getLastName() );

        personContainer.setLastNameMatern( source.getLastNameMatern() );

        personContainer.setName( source.getName() );

        personContainer.setEmail( source.getEmail() );

        personContainer.setBirthday( source.getBirthday() );

        personContainer.setSex( source.getSex() );

        personContainer.setDateCreate( source.getDateCreate() );

        personContainer.setDateLastModify( source.getDateLastModify() );

        personContainer.setUserCreate( source.getUserCreate() );

        personContainer.setUserLastModify( source.getUserLastModify() );

        return personContainer;
    }

    @Override

    public List<PersonContainer> sourceListToDestination(List<Person> source) {

        if ( source == null ) {

            return null;
        }

        List<PersonContainer> list = new ArrayList<PersonContainer>();

        for ( Person person : source ) {

            list.add( sourceToDestination( person ) );
        }

        return list;
    }
}

