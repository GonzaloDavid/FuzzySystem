/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.WS;

import com.epn.dtos.Item;
import com.epn.entities.DelphiCalculations;
import com.epn.entities.DelphiCalculationsPK;
import com.epn.fd.dao.DelphiCalculationDAO;
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
        java.util.List<String> codePerson = map.get("codePerson");
        if (codePerson != null && !codePerson.isEmpty()) {
            key.setCodePerson(new java.lang.Long(codePerson.get(0)));
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
//            @QueryParam("codeQuiz") Long codeQuiz
//    ) {
//        return delphiCalculationDAO.getItemsByQuizAndRound(codeQuiz, roundNumber);
//    }
    @GET
    @Path("calculate")
    @Transactional
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public String calculate(
            @QueryParam("roundNumber") Long roundNumber,
            @QueryParam("codeQuiz") Long codeQuiz,
            @QueryParam("codeQuestions") Long codeQuestions
    ) throws JsonProcessingException {

        Item item = delphiCalculationDAO.runFuzzyDelphiByItem(roundNumber, codeQuiz, codeQuestions, (long) 11, (float) 70);

        ObjectMapper mapper = new ObjectMapper();

        String response = mapper.writeValueAsString(item);
        return response;
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(DelphiCalculations entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, DelphiCalculations entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        com.epn.entities.DelphiCalculationsPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public DelphiCalculations find(@PathParam("id") PathSegment id) {
        com.epn.entities.DelphiCalculationsPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<DelphiCalculations> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<DelphiCalculations> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
