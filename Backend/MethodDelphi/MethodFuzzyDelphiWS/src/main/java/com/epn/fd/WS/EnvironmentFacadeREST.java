/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.WS;

import com.epn.entities.Environment;
import com.epn.entities.EnvironmentPK;
import java.util.List;
import javax.ejb.Stateless;
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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author david
 */
@Stateless
@Path("com.epn.entities.environment")
public class EnvironmentFacadeREST extends AbstractFacade<Environment> {

    @PersistenceContext(unitName = "com.epn.fuzzydelphi_MethodFuzzyDelphiWS_war_1.0PU")
    private EntityManager em;

    private EnvironmentPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;uri=uriValue;typeenvironment=typeenvironmentValue;placeofuse=placeofuseValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.epn.entities.EnvironmentPK key = new com.epn.entities.EnvironmentPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> uri = map.get("uri");
        if (uri != null && !uri.isEmpty()) {
            key.setUri(uri.get(0));
        }
        java.util.List<String> typeenvironment = map.get("typeenvironment");
        if (typeenvironment != null && !typeenvironment.isEmpty()) {
            key.setTypeenvironment(typeenvironment.get(0));
        }
        java.util.List<String> placeofuse = map.get("placeofuse");
        if (placeofuse != null && !placeofuse.isEmpty()) {
            key.setPlaceofuse(placeofuse.get(0));
        }
        return key;
    }

    public EnvironmentFacadeREST() {
        super(Environment.class);
    }
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Environment entity) {
        super.create(entity);
    }
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
