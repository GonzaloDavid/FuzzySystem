package com.epn.mapper;

import com.epn.dtos.CatalogueItemContainer;

import com.epn.entities.Catalogueitem;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Generated;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2019-07-03T14:31:13-0500",

    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"

)

public class CatalogueItemMapperImpl implements CatalogueItemMapper {

    @Override

    public CatalogueItemContainer sourceToDestination(Catalogueitem source) {

        if ( source == null ) {

            return null;
        }

        CatalogueItemContainer catalogueItemContainer = new CatalogueItemContainer();

        catalogueItemContainer.setCatalogueitemPK( source.getCatalogueitemPK() );

        catalogueItemContainer.setNameItem( source.getNameItem() );

        return catalogueItemContainer;
    }

    @Override

    public List<CatalogueItemContainer> sourceListToDestination(List<Catalogueitem> source) {

        if ( source == null ) {

            return null;
        }

        List<CatalogueItemContainer> list = new ArrayList<CatalogueItemContainer>();

        for ( Catalogueitem catalogueitem : source ) {

            list.add( sourceToDestination( catalogueitem ) );
        }

        return list;
    }
}

