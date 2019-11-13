/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.WS;

import com.epn.dtos.CatalogueSaveContainer;
import com.epn.entities.Catalogue;
import com.epn.fd.dao.CatalogueDAO;
import com.epn.fd.dao.CatalogueItemDAO;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author david
 */
@Stateless
@Path("com.epn.entities.catalogue")
public class CatalogueFacadeREST extends AbstractFacade<Catalogue> {

    @Inject()
    CatalogueDAO catalogueDAO;
        
    @Inject()
    CatalogueItemDAO catalogueItemDAO;
    
    @PersistenceContext(unitName = "com.epn.fuzzydelphi_MethodFuzzyDelphiWS_war_1.0PU")
    private EntityManager em;

    public CatalogueFacadeREST() {
        super(Catalogue.class);
    }

    @GET
    @Path("getcatalogue")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public String getCatalogue(
            @QueryParam("from") Integer from,
            @QueryParam("to") Integer to,
            @HeaderParam("authorization") String authString
    ) throws JsonProcessingException {
        String allperson = null;
        // if (userDAO.existToken(authString) == true) {
        allperson = catalogueDAO.getCatalogueList(from, to);
        // }
        return allperson;
    }

    @POST
    @Path("save")
    @Transactional
    @Consumes({MediaType.APPLICATION_JSON})
    public void saveCatalogue(
            CatalogueSaveContainer catalogueobject,
            @HeaderParam("authorization") String authString) {

        catalogueDAO.saveCatalogueanCatalogueItem(catalogueobject.getCatalogueobject());
        catalogueItemDAO.deleteCatalogueItem(catalogueobject.getCatalogueItemdeleteList());
        
    }

    @POST
    @Path("delete")
    @Transactional
    @Consumes({MediaType.APPLICATION_JSON})
    public void deleteCatalogue(
            Catalogue catalogueobject,
            @HeaderParam("authorization") String authString) {

        catalogueDAO.deleteCatalogue(catalogueobject);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
