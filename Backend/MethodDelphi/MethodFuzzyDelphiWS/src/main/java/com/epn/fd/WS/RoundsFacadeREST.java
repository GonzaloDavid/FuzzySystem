/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.WS;

import com.epn.entities.Rounds;
import com.epn.entities.RoundsPK;
import com.epn.fd.dao.RoundsDAO;
import com.epn.fd.dao.UserDAO;
import com.fasterxml.jackson.core.JsonProcessingException;
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
@Path("com.epn.entities.rounds")
public class RoundsFacadeREST extends AbstractFacade<Rounds> {

    @Inject()
    RoundsDAO roundsDAO;

    @Inject()
    UserDAO userDAO;
    @PersistenceContext(unitName = "com.epn.fuzzydelphi_MethodFuzzyDelphiWS_war_1.0PU")
    private EntityManager em;

    private RoundsPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;roundNumber=roundNumberValue;codeQuiz=codeQuizValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.epn.entities.RoundsPK key = new com.epn.entities.RoundsPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> roundNumber = map.get("roundNumber");
        if (roundNumber != null && !roundNumber.isEmpty()) {
            key.setRoundNumber(new java.lang.Long(roundNumber.get(0)));
        }
        java.util.List<String> codeQuiz = map.get("codeQuiz");
        if (codeQuiz != null && !codeQuiz.isEmpty()) {
            key.setCodeQuiz(new java.lang.Long(codeQuiz.get(0)));
        }
        java.util.List<String> codePerson = map.get("codePerson");
        if (codePerson != null && !codePerson.isEmpty()) {
            key.setCodePerson(new java.lang.Long(codePerson.get(0)));
        }
        return key;
    }

    public RoundsFacadeREST() {
        super(Rounds.class);
    }

    @GET
    @Path("getround")
    @Transactional
    @Produces({MediaType.APPLICATION_JSON})
    public String getLastRound(
            @QueryParam("codequiz") Long codequiz,
            @QueryParam("roundNumber") Long roundNumber,
            @HeaderParam("authorization") String authString
    ) throws JsonProcessingException {
        String response = "";
        if (userDAO.existToken(authString) == true) {
            response = roundsDAO.getLastRoundbycodeQuiz(codequiz, roundNumber);
        }
        return response;
    }

    @POST
    @Path("save")
    @Transactional
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public void saveRound(
            Rounds round,
            @HeaderParam("authorization") String authString) {
        if (userDAO.existToken(authString) == true) {
            roundsDAO.save(round);
        }
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
