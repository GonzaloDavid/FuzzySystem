/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.WS;

import com.epn.dtos.CriteriaSaveContainer;
import com.epn.entities.CriteriaFAHP;
import com.epn.entities.CriterialFAHPPK;
import com.epn.entities.Person;
import com.epn.entities.QuizPK;
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
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author david
 */
@Stateless
@Path("com.epn.entities.criteriafahp")
public class CriteriaFAHPFacadeREST extends AbstractFacade<CriteriaFAHP> {

    @Inject()
    CriteriaFAHPDAO fAHPDAO;

    @PersistenceContext(unitName = "com.epn.fuzzydelphi_MethodFuzzyDelphiWS_war_1.0PU")
    private EntityManager em;

     private CriterialFAHPPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;codeQuestions=codeQuestionsValue;codeQuiz=codeQuizValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.epn.entities.CriterialFAHPPK key = new com.epn.entities.CriterialFAHPPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> codeQuestions = map.get("codeCriteria");
        if (codeQuestions != null && !codeQuestions.isEmpty()) {
            key.setCodeCriteria(new java.lang.Long(codeQuestions.get(0)));
        }
        return key;
    }
    public CriteriaFAHPFacadeREST() {
        super(CriteriaFAHP.class);
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
    public List<CriteriaFAHP> savecriteria(
            CriteriaSaveContainer criteriacontainer,
            @HeaderParam("authorization") String authString) {
       
        List<CriteriaFAHP> cfahps =fAHPDAO.save(criteriacontainer.getCriterialist());
        fAHPDAO.deleteCriteria(criteriacontainer.getCriteriadeletedlist());
        return cfahps;
        
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
