/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.dtos.CatalogueContainer;
import com.epn.dtos.ListAndCountContainer;
import com.epn.entities.Catalogue;
import com.epn.entities.Catalogueitem;
import com.epn.entities.CatalogueitemPK;
import com.epn.entities.FilterTypes;
import com.epn.entities.SearchObject;
import com.epn.exception.AppException;
import com.epn.mapper.CatalogueMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author david
 */
@Stateless
public class CatalogueDAO extends GenericDAO<Catalogue> {

    @Inject()
    CatalogueItemDAO catalogueItemDAO;

    public CatalogueDAO() {
        super(Catalogue.class);
    }
    private final CatalogueMapper catalogueMapper = Mappers.getMapper(CatalogueMapper.class);

    public String getCatalogueList(Integer from, Integer to) throws JsonProcessingException {
        SearchObject search = new SearchObject("code");
        search.setOrderPropertyName("code");
        search.asc();
        long count = search(search).size();
        search.setFrom(from);
        search.setTo(to);

        List<Catalogue> resultList = search(search);

        List<CatalogueContainer> catalogueContainers = catalogueMapper.sourceListToDestination(resultList);
        /* catalogueContainers.forEach(catalogue -> {
         catalogue.setCatalogueitemList(catalogueItemDAO.getCatalogueItembyCodeCatalogue(codeCat));
         });*/
        ListAndCountContainer patientlistandcount = new ListAndCountContainer(count, catalogueContainers);

        ObjectMapper mapper = new ObjectMapper();
        String response = mapper.writeValueAsString(patientlistandcount);
        return response;
    }
      public List<CatalogueContainer> getCatalogueListbyvalueFAHP(String valueFAHP) {
        SearchObject search = new SearchObject("code");
        search.addParameter("code", FilterTypes.LIKE_RIGHT, valueFAHP);
        List<Catalogue> resultList = search(search);
        List<CatalogueContainer> catalogueContainers = catalogueMapper.sourceListToDestination(resultList);
        return catalogueContainers;
    }

    public void saveCatalogueanCatalogueItem(Catalogue catalogue) {
        Catalogue catalogueNEW = new Catalogue();
        catalogueNEW.setCode(catalogue.getCode());
        catalogueNEW.setName(catalogue.getName());
        catalogueNEW.setDescripcion(catalogue.getDescripcion());
        //GUARDA CATALOGO
        save(catalogueNEW);
        catalogue.getCatalogueitemList().forEach(catalogueItem -> {
            CatalogueitemPK catalogueitemPK = new CatalogueitemPK();
            catalogueitemPK.setCodeCatalogue(catalogueNEW.getCode());
            catalogueitemPK.setCodeItem(catalogueItem.getCatalogueitemPK().getCodeItem());
            Catalogueitem catalogueitemNEW = new Catalogueitem(catalogueitemPK);
            catalogueitemNEW.setNameItem(catalogueItem.getNameItem());
            //GUARDA ITEM DE CADA CATALOGO
            catalogueItemDAO.save(catalogueitemNEW);
        });
    }

    public void save(Catalogue catalogue) {
        update(catalogue);
    }

    public void deleteCatalogue(Catalogue id) {
        Catalogue foundelement = new Catalogue();
        foundelement = find(id.getCode());
        if (foundelement != null) {
            try {
                remove(foundelement);
            } catch (Exception e) {
                throw new AppException(e.toString(),e.toString(), "mysql_forenkey","PROBLEMA DE DEPENDENCIAS");
            }
        }
    }
}
