/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.dtos.CatalogueItemContainer;
import com.epn.dtos.ListAndCountContainer;
import com.epn.entities.Catalogueitem;
import com.epn.entities.FilterTypes;
import com.epn.entities.SearchObject;
import com.epn.mapper.CatalogueItemMapper;
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
public class CatalogueItemDAO extends GenericDAO<Catalogueitem> {

    private final CatalogueItemMapper catalogueItemMapper = Mappers.getMapper(CatalogueItemMapper.class);
    public CatalogueItemDAO() {
        super(Catalogueitem.class);
    }
    
    public String getCatalogueItembyCodeCat(String codeCat)throws JsonProcessingException {
        SearchObject search = new SearchObject("catalogueitemPK");
        search.addParameter("catalogueitemPK.codeCatalogue", FilterTypes.EQUAL, codeCat);
        search.setOrderPropertyName("catalogueitemPK.codeCatalogue");
        search.desc();

        List<Catalogueitem> resultList = search(search);
        List<CatalogueItemContainer> catalogueItemContainers = catalogueItemMapper.sourceListToDestination(resultList);
        ListAndCountContainer cataloguecontainer = new ListAndCountContainer(null, catalogueItemContainers);

        ObjectMapper mapper = new ObjectMapper();
        String response = mapper.writeValueAsString(cataloguecontainer);
        return response;

    }
}
