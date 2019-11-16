/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.WS;

import com.epn.dtos.AttributeMatrixvalueSaveContainer;
import com.epn.dtos.AttributesMatrixValueContainer;
import com.epn.entities.AttributesMatrixValue;
import com.epn.entities.AttributesMatrixValuePK;
import com.epn.entities.FahpPK;
import com.epn.fd.dao.AttributesMatrixValueDAO;
import com.epn.fd.dao.CriteriaMatrixValueDAO;
import com.epn.fd.dao.FahpDAO;
import com.epn.fd.dao.SentemailbycodefahpDAO;
import com.epn.fd.dao.UserDAO;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.ArrayList;
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
@Path("com.epn.entities.attributesmatrixvalue")
public class AttributesMatrixValueFacadeREST extends AbstractFacade<AttributesMatrixValue> {

    @Inject()
    AttributesMatrixValueDAO attributesMatrixValueDAO;

    @Inject()
    CriteriaMatrixValueDAO criteriaMatrixValueDAO;

    @Inject()
    SentemailbycodefahpDAO sentemailbycodefahpDAO;

    @Inject()
    FahpDAO fahpDAO;

    @Inject()
    UserDAO userDAO;

    @PersistenceContext(unitName = "com.epn.fuzzydelphi_MethodFuzzyDelphiWS_war_1.0PU")
    private EntityManager em;

    private AttributesMatrixValuePK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;codefahp=codefahpValue;codePerson=codePersonValue;codeQuiz=codeQuizValue;codeQuestions=codeQuestionsValue;itemLabel=itemLabelValue;itemLabelCouple=itemLabelCoupleValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.epn.entities.AttributesMatrixValuePK key = new com.epn.entities.AttributesMatrixValuePK();
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
        java.util.List<String> itemLabel = map.get("itemLabel");
        if (itemLabel != null && !itemLabel.isEmpty()) {
            key.setItemLabel(new java.lang.Long(itemLabel.get(0)));
        }
        java.util.List<String> itemLabelCouple = map.get("itemLabelCouple");
        if (itemLabelCouple != null && !itemLabelCouple.isEmpty()) {
            key.setItemLabelCouple(new java.lang.Long(itemLabelCouple.get(0)));
        }
        return key;
    }

    public AttributesMatrixValueFacadeREST() {
        super(AttributesMatrixValue.class);
    }

    @GET
    @Path("attributematrixdata")
    @Transactional
    @Produces({MediaType.APPLICATION_JSON})
    public List<AttributesMatrixValueContainer> getcriteriamatrixdata(
            @QueryParam("codefahp") Long codefahp,
            @QueryParam("codeperson") Long codeperson,
            @HeaderParam("authorization") String authString
    ) throws JsonProcessingException {
        List<AttributesMatrixValueContainer> criteriadatamatrix = new ArrayList();
        // if (userDAO.existToken(authString) == true) {
        criteriadatamatrix = attributesMatrixValueDAO.getMatrixvaluelist(codefahp, codeperson);
        //   }
        return criteriadatamatrix;
    }

    @POST
    @Path("save")
    @Transactional
    @Consumes({MediaType.APPLICATION_JSON})
    public void save(AttributeMatrixvalueSaveContainer saveContainer,
            @HeaderParam("authorization") String authString) {
        if (sentemailbycodefahpDAO.validateJWT(saveContainer.getSentemailbycodefahp(),authString) == true) {
            FahpPK fahpPK = new FahpPK();
            fahpPK.setCodefahp(saveContainer.getSentemailbycodefahp().getCodefahp());

            fahpDAO.updatestatus(fahpPK, "answered");
            sentemailbycodefahpDAO.updatestatus(saveContainer.getSentemailbycodefahp());
            attributesMatrixValueDAO.save(saveContainer.getAttributesMatrixlist());
            criteriaMatrixValueDAO.save(saveContainer.getCriteriaMatrixlist());
        }
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
