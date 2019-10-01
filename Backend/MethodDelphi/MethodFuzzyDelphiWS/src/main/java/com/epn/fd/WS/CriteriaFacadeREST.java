/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.WS;

import com.epn.dtos.CriteriaSaveContainer;
import com.epn.entities.Criteria;
import com.epn.fd.dao.CriteriaFAHPDAO;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author david
 */
@Stateless
@Path("com.epn.entities.criteria")
public class CriteriaFacadeREST extends AbstractFacade<Criteria> {

    @Inject()
    CriteriaFAHPDAO fAHPDAO;
    
    @PersistenceContext(unitName = "com.epn.fuzzydelphi_MethodFuzzyDelphiWS_war_1.0PU")
    private EntityManager em;

    public CriteriaFacadeREST() {
        super(Criteria.class);
    }

    @GET
    @Path("criteria")
    @Produces({MediaType.APPLICATION_JSON})
    public String getPersonbycode(
            @QueryParam("from") Integer from,
            @QueryParam("to") Integer to,
            @QueryParam("codeCriteria") Long codeCriteria,
            @HeaderParam("authorization") String authString
    ) throws JsonProcessingException {
        String response = fAHPDAO.getcriteriabycode(codeCriteria, from, to);
        return response;
    }

    @POST
    @Path("save")
    @Transactional
    @Consumes({MediaType.APPLICATION_JSON})
    public List<Criteria> savecriteria(
            CriteriaSaveContainer criteriacontainer,
            @HeaderParam("authorization") String authString) {

        List<Criteria> cfahps = fAHPDAO.save(criteriacontainer.getCriterialist());
        fAHPDAO.deleteCriteria(criteriacontainer.getCriteriadeletedlist());
        return cfahps;

    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
