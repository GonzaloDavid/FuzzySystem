/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.WS;

import com.epn.entities.ProcessFahpweightbycriteria;
import com.epn.entities.ProcessFahpweightbycriteriaPK;
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
@Path("com.epn.entities.processfahpweightbycriteria")
public class ProcessFahpweightbycriteriaFacadeREST extends AbstractFacade<ProcessFahpweightbycriteria> {

    @PersistenceContext(unitName = "com.epn.fuzzydelphi_MethodFuzzyDelphiWS_war_1.0PU")
    private EntityManager em;

    private ProcessFahpweightbycriteriaPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;codefahp=codefahpValue;codePerson=codePersonValue;codeCriteria=codeCriteriaValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.epn.entities.ProcessFahpweightbycriteriaPK key = new com.epn.entities.ProcessFahpweightbycriteriaPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> codefahp = map.get("codefahp");
        if (codefahp != null && !codefahp.isEmpty()) {
            key.setCodefahp(new java.lang.Long(codefahp.get(0)));
        }
        java.util.List<String> codePerson = map.get("codePerson");
        if (codePerson != null && !codePerson.isEmpty()) {
            key.setCodePerson(new java.lang.Long(codePerson.get(0)));
        }
        java.util.List<String> codeCriteria = map.get("codeCriteria");
        if (codeCriteria != null && !codeCriteria.isEmpty()) {
            key.setCodeCriteria(new java.lang.Long(codeCriteria.get(0)));
        }
        return key;
    }

    public ProcessFahpweightbycriteriaFacadeREST() {
        super(ProcessFahpweightbycriteria.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(ProcessFahpweightbycriteria entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, ProcessFahpweightbycriteria entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        com.epn.entities.ProcessFahpweightbycriteriaPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public ProcessFahpweightbycriteria find(@PathParam("id") PathSegment id) {
        com.epn.entities.ProcessFahpweightbycriteriaPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ProcessFahpweightbycriteria> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ProcessFahpweightbycriteria> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
