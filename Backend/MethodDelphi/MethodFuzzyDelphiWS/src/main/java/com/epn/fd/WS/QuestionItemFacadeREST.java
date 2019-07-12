/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.WS;

import com.epn.entities.QuestionItem;
import com.epn.entities.QuestionItemPK;
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
@Path("com.epn.entities.questionitem")
public class QuestionItemFacadeREST extends AbstractFacade<QuestionItem> {

    @PersistenceContext(unitName = "com.epn.fuzzydelphi_MethodFuzzyDelphiWS_war_1.0PU")
    private EntityManager em;

    private QuestionItemPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;codeQuizItem=codeQuizItemValue;codeQuestions=codeQuestionsValue;codeQuiz=codeQuizValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.epn.entities.QuestionItemPK key = new com.epn.entities.QuestionItemPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> codeQuizItem = map.get("codeQuizItem");
        if (codeQuizItem != null && !codeQuizItem.isEmpty()) {
            key.setCodeQuizItem(new java.lang.Long(codeQuizItem.get(0)));
        }
        java.util.List<String> codeQuestions = map.get("codeQuestions");
        if (codeQuestions != null && !codeQuestions.isEmpty()) {
            key.setCodeQuestions(new java.lang.Long(codeQuestions.get(0)));
        }
        java.util.List<String> codeQuiz = map.get("codeQuiz");
        if (codeQuiz != null && !codeQuiz.isEmpty()) {
            key.setCodeQuiz(new java.lang.Long(codeQuiz.get(0)));
        }
        return key;
    }

    public QuestionItemFacadeREST() {
        super(QuestionItem.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(QuestionItem entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, QuestionItem entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        com.epn.entities.QuestionItemPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public QuestionItem find(@PathParam("id") PathSegment id) {
        com.epn.entities.QuestionItemPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<QuestionItem> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<QuestionItem> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
