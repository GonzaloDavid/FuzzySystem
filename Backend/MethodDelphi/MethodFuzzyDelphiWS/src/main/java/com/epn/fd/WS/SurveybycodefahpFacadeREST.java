/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.WS;

import com.epn.dtos.SurveybycodefahpContainer;
import com.epn.entities.Surveybycodefahp;
import com.epn.entities.SurveybycodefahpPK;
import com.epn.fd.dao.SurveybycodefahpDAO;
import com.epn.fd.dao.UserDAO;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
 * @author david
 */
@Stateless
@Path("com.epn.entities.surveybycodefahp")
public class SurveybycodefahpFacadeREST extends AbstractFacade<Surveybycodefahp> {

    @Inject()
    SurveybycodefahpDAO surveybycodefahpDAO;

    @Inject()
    UserDAO userDAO;

    @PersistenceContext(unitName = "com.epn.fuzzydelphi_MethodFuzzyDelphiWS_war_1.0PU")
    private EntityManager em;

    private SurveybycodefahpPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;codefahp=codefahpValue;codeQuiz=codeQuizValue;codeQuestions=codeQuestionsValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.epn.entities.SurveybycodefahpPK key = new com.epn.entities.SurveybycodefahpPK();
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
        return key;
    }

    public SurveybycodefahpFacadeREST() {
        super(Surveybycodefahp.class);
    }

    @GET
    @Path("fahplist")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public String getfahplist(
            @QueryParam("codefahp") Long codefahp,
            @QueryParam("codequiz") Long codequiz,
            @QueryParam("namequiz") String namequiz,
            @QueryParam("from") Integer from,
            @QueryParam("to") Integer to,
            @HeaderParam("authorization") String authString
    ) throws JsonProcessingException {
        String fahplist = null;
        if (userDAO.existToken(authString) == true) {
            fahplist = surveybycodefahpDAO.getfahplist(codefahp, codequiz, namequiz, from, to);
        }
        return fahplist;
    }

    @GET
    @Path("suveybycodefahp")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public List<SurveybycodefahpContainer> getsurveybycodefahp(
            @QueryParam("codefahp") Long codefahp,
            @HeaderParam("authorization") String authString
    ) {
        List<SurveybycodefahpContainer> containers = new ArrayList();
       // if (userDAO.existToken(authString) == true) {
            containers = surveybycodefahpDAO.getquizbycodefahp(codefahp);
       // }
        return containers;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
