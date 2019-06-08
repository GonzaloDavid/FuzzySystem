/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.WS;

import com.epn.entities.Catalogueitem;
import com.epn.entities.CatalogueitemPK;
import com.epn.fd.dao.CatalogueItemDAO;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author desarrollador
 */
@Stateless
@Path("com.epn.entities.catalogueitem")
public class CatalogueitemFacadeREST extends AbstractFacade<Catalogueitem> {

    @Inject CatalogueItemDAO catalogueItemDAO;
    @PersistenceContext(unitName = "com.epn.fuzzydelphi_MethodFuzzyDelphiWS_war_1.0PU")
    private EntityManager em;

    private CatalogueitemPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;codeCatalogue=codeCatalogueValue;codeItem=codeItemValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.epn.entities.CatalogueitemPK key = new com.epn.entities.CatalogueitemPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> codeCatalogue = map.get("codeCatalogue");
        if (codeCatalogue != null && !codeCatalogue.isEmpty()) {
            key.setCodeCatalogue(codeCatalogue.get(0));
        }
        java.util.List<String> codeItem = map.get("codeItem");
        if (codeItem != null && !codeItem.isEmpty()) {
            key.setCodeItem(codeItem.get(0));
        }
        return key;
    }

    public CatalogueitemFacadeREST() {
        super(Catalogueitem.class);
    }

    @GET
    @Path("catalogue")
    @Produces({MediaType.APPLICATION_JSON})
    public String getPerson(
            @QueryParam("codeCat") String codeCat
    )throws JsonProcessingException
    {

        return catalogueItemDAO.getCatalogueItembyCodeCat(codeCat);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Catalogueitem entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, Catalogueitem entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        com.epn.entities.CatalogueitemPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Catalogueitem find(@PathParam("id") PathSegment id) {
        com.epn.entities.CatalogueitemPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Catalogueitem> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Catalogueitem> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
