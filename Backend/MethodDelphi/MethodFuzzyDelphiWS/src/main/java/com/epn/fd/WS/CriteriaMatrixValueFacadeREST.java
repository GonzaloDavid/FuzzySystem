/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.WS;

import com.epn.dtos.CriteriaMatrixValueContainer;
import com.epn.dtos.CriteriabycodefahpContainer;
import com.epn.entities.CriteriaMatrixValue;
import com.epn.entities.CriteriaMatrixValuePK;
import com.epn.fd.dao.CriteriaMatrixValueDAO;
import com.epn.fd.dao.UserDAO;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
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
@Path("com.epn.entities.criteriamatrixvalue")
public class CriteriaMatrixValueFacadeREST extends AbstractFacade<CriteriaMatrixValue> {

    @Inject()
    UserDAO userDAO;

    @Inject()
    CriteriaMatrixValueDAO criteriaMatrixValueDAO;

    @PersistenceContext(unitName = "com.epn.fuzzydelphi_MethodFuzzyDelphiWS_war_1.0PU")
    private EntityManager em;

    private CriteriaMatrixValuePK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;codefahp=codefahpValue;codePerson=codePersonValue;codeCriteria=codeCriteriaValue;codeCriteriaCouple=codeCriteriaCoupleValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.epn.entities.CriteriaMatrixValuePK key = new com.epn.entities.CriteriaMatrixValuePK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> codefahp = map.get("codefahp");
        if (codefahp != null && !codefahp.isEmpty()) {
            key.setCodefahp(new java.lang.Long(codefahp.get(0)));
        }
        java.util.List<String> codePerson = map.get("codePerson");
        if (codePerson != null && !codePerson.isEmpty()) {
            key.setCodePerson(new java.lang.Long(codePerson.get(0)));
        }
        java.util.List<String> codeCriteria = map.get("codeCriteria");
        if (codeCriteria != null && !codeCriteria.isEmpty()) {
            key.setCodeCriteria(new java.lang.Long(codeCriteria.get(0)));
        }
        java.util.List<String> codeCriteriaCouple = map.get("codeCriteriaCouple");
        if (codeCriteriaCouple != null && !codeCriteriaCouple.isEmpty()) {
            key.setCodeCriteriaCouple(new java.lang.Long(codeCriteriaCouple.get(0)));
        }
        return key;
    }

    public CriteriaMatrixValueFacadeREST() {
        super(CriteriaMatrixValue.class);
    }

    @GET
    @Path("criteriamatrixdata")
    @Transactional
    @Produces({MediaType.APPLICATION_JSON})
    public List<CriteriaMatrixValueContainer> getcriteriamatrixdata(
            @QueryParam("codefahp") Long codefahp,
            @QueryParam("codeperson") Long codeperson,
            @HeaderParam("authorization") String authString
    ) throws JsonProcessingException {
        List<CriteriaMatrixValueContainer> criteriadatamatrix = new ArrayList();
        if (userDAO.existToken(authString) == true) {
            criteriadatamatrix = criteriaMatrixValueDAO.getMatrixvaluelist(codefahp, codeperson);
        }
        return criteriadatamatrix;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
