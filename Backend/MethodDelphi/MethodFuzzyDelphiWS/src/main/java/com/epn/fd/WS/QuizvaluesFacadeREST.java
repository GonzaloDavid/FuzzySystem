/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.WS;

import com.epn.dtos.QuizValueSaveContainer;
import com.epn.dtos.QuizValuesContainer;
import com.epn.entities.Quizvalues;
import com.epn.entities.QuizvaluesPK;
import com.epn.fd.dao.QuizValuesDAO;
import com.epn.fd.dao.RoundsDAO;
import com.epn.fd.dao.UserDAO;
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
@Path("com.epn.entities.quizvalues")
public class QuizvaluesFacadeREST extends AbstractFacade<Quizvalues> {

    @Inject()
    QuizValuesDAO quizValuesDAO;
    @Inject()
    RoundsDAO roundsDAO;
    @Inject
    UserDAO userDAO;
    @PersistenceContext(unitName = "com.epn.fuzzydelphi_MethodFuzzyDelphiWS_war_1.0PU")
    private EntityManager em;

    private QuizvaluesPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;roundNumber=roundNumberValue;codePerson=codePersonValue;codeQuiz=codeQuizValue;codeQuestions=codeQuestionsValue;codeQuizItem=codeQuizItemValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.epn.entities.QuizvaluesPK key = new com.epn.entities.QuizvaluesPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> roundNumber = map.get("roundNumber");
        if (roundNumber != null && !roundNumber.isEmpty()) {
            key.setRoundNumber(new java.lang.Long(roundNumber.get(0)));
        }
        java.util.List<String> codePerson = map.get("codePerson");
        if (codePerson != null && !codePerson.isEmpty()) {
            key.setCodePerson(new java.lang.Long(codePerson.get(0)));
        }
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
        return key;
    }

    public QuizvaluesFacadeREST() {
        super(Quizvalues.class);
    }

    @POST
    @Path("quizvalues")
    @Transactional
    @Consumes({MediaType.APPLICATION_JSON})
    public void customerquizvalues(QuizValueSaveContainer quizvalues, @HeaderParam("authorization") String authString) {
        if (userDAO.existToken(authString) == true) {
            roundsDAO.setsentstatus(quizvalues);
            quizValuesDAO.savequizvalues(quizvalues.getQuiz(), quizvalues.getCodeperson(), quizvalues.getRoundNumber());
        }
    }

    @GET
    @Path("getquizvalues")
    @Produces({MediaType.APPLICATION_JSON})
    public List<QuizValuesContainer> getQuizvalues(
            @QueryParam("codePerson") Long codePerson,
            @QueryParam("codeQuiz") Long codeQuiz,
            @QueryParam("codeQuestions") Long codeQuestions,
            @QueryParam("roundNumber") Long roundNumber,
            @QueryParam("codeQuizItem") Long codeQuizItem,
            @HeaderParam("authorization") String authString
    ) {
        List<QuizValuesContainer> containers = null;
        if (userDAO.existToken(authString) == true) {
            containers = quizValuesDAO.getquizvalues(codeQuiz, codeQuestions, codeQuizItem, codePerson, roundNumber);
        }
        return containers;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
