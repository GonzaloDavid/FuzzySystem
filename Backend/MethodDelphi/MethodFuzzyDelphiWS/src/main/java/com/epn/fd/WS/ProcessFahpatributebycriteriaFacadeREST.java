/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.WS;

import com.epn.dtos.ProcessFahpatributebycriteriaContainer;
import com.epn.dtos.ResultFAHPContainer;
import com.epn.entities.ProcessFahpatributebycriteria;
import com.epn.entities.ProcessFahpatributebycriteriaPK;
import com.epn.fd.dao.ProcessFahpatributebycriteriaDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
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
@Path("com.epn.entities.processfahpatributebycriteria")
public class ProcessFahpatributebycriteriaFacadeREST extends AbstractFacade<ProcessFahpatributebycriteria> {

    @Inject()
    ProcessFahpatributebycriteriaDAO fahpatributebycriteriaDAO;

    @PersistenceContext(unitName = "com.epn.fuzzydelphi_MethodFuzzyDelphiWS_war_1.0PU")
    private EntityManager em;

    private ProcessFahpatributebycriteriaPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;codefahp=codefahpValue;codePerson=codePersonValue;codeQuiz=codeQuizValue;codeQuestions=codeQuestionsValue;codeQuizItem=codeQuizItemValue;codeCriteria=codeCriteriaValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.epn.entities.ProcessFahpatributebycriteriaPK key = new com.epn.entities.ProcessFahpatributebycriteriaPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> codefahp = map.get("codefahp");
        if (codefahp != null && !codefahp.isEmpty()) {
            key.setCodefahp(new java.lang.Long(codefahp.get(0)));
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
        java.util.List<String> codeCriteria = map.get("codeCriteria");
        if (codeCriteria != null && !codeCriteria.isEmpty()) {
            key.setCodeCriteria(new java.lang.Long(codeCriteria.get(0)));
        }
        return key;
    }

    public ProcessFahpatributebycriteriaFacadeREST() {
        super(ProcessFahpatributebycriteria.class);
    }

    @GET
    @Path("getattributeprocess")
    @Produces({MediaType.APPLICATION_JSON})
    public List<ProcessFahpatributebycriteriaContainer> getattributeprocessbycodefahp(
            @QueryParam("codefahp") Long codefahp,
            @HeaderParam("authorization") String authString
    ) {
        List<ProcessFahpatributebycriteriaContainer> processcontainer = fahpatributebycriteriaDAO.getprocesslistbycodefahp(codefahp);
        return processcontainer;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
