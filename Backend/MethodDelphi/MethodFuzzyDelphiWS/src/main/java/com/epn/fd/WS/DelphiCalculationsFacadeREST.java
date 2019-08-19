/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.WS;

import com.epn.dtos.DelphiCalculationsContainer;
import com.epn.dtos.Item;
import com.epn.entities.DelphiCalculations;
import com.epn.entities.DelphiCalculationsPK;
import com.epn.fd.dao.DelphiCalculationDAO;
import com.epn.fd.dao.UserDAO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author ka
 */
@Stateless
@Path("com.epn.entities.delphicalculations")
public class DelphiCalculationsFacadeREST extends AbstractFacade<DelphiCalculations> {

    @Inject()
    DelphiCalculationDAO delphiCalculationDAO;

    @Inject()
    UserDAO userDAO;

    @PersistenceContext(unitName = "com.epn.fuzzydelphi_MethodFuzzyDelphiWS_war_1.0PU")
    private EntityManager em;

    private DelphiCalculationsPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;codeQuiz=codeQuizValue;codeQuestions=codeQuestionsValue;codeQuizItem=codeQuizItemValue;codePerson=codePersonValue;roundNumber=roundNumberValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.epn.entities.DelphiCalculationsPK key = new com.epn.entities.DelphiCalculationsPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> codeQuiz = map.get("codeQuiz");
        if (codeQuiz != null && !codeQuiz.isEmpty()) {
            key.setCodeQuiz(new java.lang.Long(codeQuiz.get(0)));
        }
        java.util.List<String> codeQuestions = map.get("codeQuestions");
        if (codeQuestions != null && !codeQuestions.isEmpty()) {
            key.setCodeQuestions(new java.lang.Long(codeQuestions.get(0)));
        }
        java.util.List<String> codeQuizItem = map.get("codeQuizItem");
        if (codeQuizItem != null && !codeQuizItem.isEmpty()) {
            key.setCodeQuizItem(new java.lang.Long(codeQuizItem.get(0)));
        }
        java.util.List<String> roundNumber = map.get("roundNumber");
        if (roundNumber != null && !roundNumber.isEmpty()) {
            key.setRoundNumber(new java.lang.Long(roundNumber.get(0)));
        }
        return key;
    }

    public DelphiCalculationsFacadeREST() {
        super(DelphiCalculations.class);
    }

//    @GET
//    @Path("calculate")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Item> calculate(
//            @QueryParam("roundNumber") Long roundNumber,
//            @QueryParam("codeQuiz") Long codeQuiz,
//            @QueryParam("codeQuestions") Long codeQuestions
//    ) {
//
//        return delphiCalculationDAO.runFuzzyDelphiByQuestion(codeQuiz, roundNumber, codeQuestions);
//    }
    @GET
    @Path("calculate")
    @Transactional
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public String calculate(
            @QueryParam("roundNumber") Long roundNumber,
            @QueryParam("codeQuiz") Long codeQuiz,
            @QueryParam("codeQuestions") Long codeQuestions,
            @HeaderParam("authorization") String authString
    ) throws JsonProcessingException {
        String response = null;
        if (userDAO.existToken(authString) == true) {
            List<Item> itemList = delphiCalculationDAO.runFuzzyDelphiByQuestion(codeQuiz, roundNumber, codeQuestions);
            ObjectMapper mapper = new ObjectMapper();
            response = mapper.writeValueAsString(itemList);

        }
        return response;
    }

    @POST
    @Path("save")
    @Transactional
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public String save(
            @QueryParam("roundNumber") Long roundNumber,
            @QueryParam("codeQuiz") Long codeQuiz,
            @QueryParam("codeQuestions") Long codeQuestions,
            @HeaderParam("authorization") String authString
    ) throws JsonProcessingException {
        String response = null;
        if (userDAO.existToken(authString) == true) {

            List<DelphiCalculations> delphiCalculations = delphiCalculationDAO.saveDelphiCalculations(codeQuiz, roundNumber, codeQuestions);
            ObjectMapper mapper = new ObjectMapper();
            response = mapper.writeValueAsString(delphiCalculations);
        }
        return response;
    }

    @GET
    @Path("getdelphicalculation")
    @Produces({MediaType.APPLICATION_JSON})
    public List<DelphiCalculationsContainer> getdelphicalculation(
            @QueryParam("codequiz") Long codequiz,
            @QueryParam("roundNumber") Long roundNumber,
            @HeaderParam("authorization") String authString
    ) throws JsonProcessingException {
        List<DelphiCalculationsContainer> containers = null;
        if (userDAO.existToken(authString) == true) {
            containers = delphiCalculationDAO.getdelphicalculationbycodequiz(codequiz, roundNumber);
        }
        return containers;
    }

    @GET
    @Path("results")
    @Produces({MediaType.APPLICATION_JSON})
    public String getQuizvalues(
            @QueryParam("codeQuiz") Long codeQuiz,
            @QueryParam("codeQuestions") Long codeQuestions,
            @QueryParam("roundNumber") Long roundNumber,
            @QueryParam("codeQuizItem") Long codeQuizItem,
            @HeaderParam("authorization") String authString
    ) throws JsonProcessingException {
        String response = null;
        if (userDAO.existToken(authString) == true) {

            List<DelphiCalculationsContainer> delphiCalculations = delphiCalculationDAO.getDelphiCalculations(codeQuiz, codeQuestions, codeQuizItem, roundNumber);
            ObjectMapper mapper = new ObjectMapper();
            response = mapper.writeValueAsString(delphiCalculations);
        }
        return response;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
