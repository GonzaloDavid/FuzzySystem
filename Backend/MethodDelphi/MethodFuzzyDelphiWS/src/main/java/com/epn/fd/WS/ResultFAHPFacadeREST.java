/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.WS;

import com.epn.dtos.ResultFAHPContainer;
import com.epn.entities.ResultFAHP;
import com.epn.entities.ResultFAHPPK;
import com.epn.fd.dao.ResultFAHPDAO;
import com.epn.fd.dao.UserDAO;
import java.util.ArrayList;
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
@Path("com.epn.entities.resultfahp")
public class ResultFAHPFacadeREST extends AbstractFacade<ResultFAHP> {

    @Inject()
    ResultFAHPDAO rfahpdao;

    @Inject()
    UserDAO userDAO;

    @PersistenceContext(unitName = "com.epn.fuzzydelphi_MethodFuzzyDelphiWS_war_1.0PU")
    private EntityManager em;

    private ResultFAHPPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;codefahp=codefahpValue;codeQuiz=codeQuizValue;codeQuestions=codeQuestionsValue;codeQuizItem=codeQuizItemValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.epn.entities.ResultFAHPPK key = new com.epn.entities.ResultFAHPPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> codefahp = map.get("codefahp");
        if (codefahp != null && !codefahp.isEmpty()) {
            key.setCodefahp(new java.lang.Long(codefahp.get(0)));
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

    public ResultFAHPFacadeREST() {
        super(ResultFAHP.class);
    }

    @GET
    @Path("getresultbyfahpcode")
    @Produces({MediaType.APPLICATION_JSON})
    public List<ResultFAHPContainer> getResultbyfahpcode(
            @QueryParam("codefahp") Long codefahp,
            @HeaderParam("authorization") String authString
    ) {
        List<ResultFAHPContainer> resultfahp = new ArrayList();
        if (userDAO.existToken(authString) == true) {
            resultfahp = rfahpdao.getresultbycode(codefahp);
        }
        return resultfahp;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
