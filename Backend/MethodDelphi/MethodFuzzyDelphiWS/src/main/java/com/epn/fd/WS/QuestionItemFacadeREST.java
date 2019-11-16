/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.WS;

import com.epn.entities.QuestionItem;
import com.epn.entities.QuestionItemPK;
import com.epn.fd.dao.UserDAO;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author david
 */
@Stateless
@Path("com.epn.entities.questionitem")
public class QuestionItemFacadeREST extends AbstractFacade<QuestionItem> {

    @Inject()
    UserDAO userDAO;
    
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

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
