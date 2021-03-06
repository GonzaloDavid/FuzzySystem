/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.WS;

import com.epn.dtos.CriteriabycodefahpContainer;
import com.epn.dtos.SentemailbycodefahpContainer;
import com.epn.dtos.SentemailbycodefahpSaveContainer;
import com.epn.dtos.SentemailbycodefahpSavefowardContainer;
import com.epn.entities.Sentemailbycodefahp;
import com.epn.entities.SentemailbycodefahpPK;
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
@Path("com.epn.entities.sentemailbycodefahp")
public class SentemailbycodefahpFacadeREST extends AbstractFacade<Sentemailbycodefahp> {

    @Inject()
    SentemailbycodefahpDAO sentemailbycodefahpDAO;

    @Inject()
    UserDAO userDAO;

    @PersistenceContext(unitName = "com.epn.fuzzydelphi_MethodFuzzyDelphiWS_war_1.0PU")
    private EntityManager em;

    private SentemailbycodefahpPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;codefahp=codefahpValue;codePerson=codePersonValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.epn.entities.SentemailbycodefahpPK key = new com.epn.entities.SentemailbycodefahpPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> codefahp = map.get("codefahp");
        if (codefahp != null && !codefahp.isEmpty()) {
            key.setCodefahp(new java.lang.Long(codefahp.get(0)));
        }
        java.util.List<String> codePerson = map.get("codePerson");
        if (codePerson != null && !codePerson.isEmpty()) {
            key.setCodePerson(new java.lang.Long(codePerson.get(0)));
        }
        return key;
    }

    public SentemailbycodefahpFacadeREST() {
        super(Sentemailbycodefahp.class);
    }

    @GET
    @Path("person")
    @Transactional
    @Produces({MediaType.APPLICATION_JSON})
    public List<SentemailbycodefahpContainer> getpersonsbycodefahp(
            @QueryParam("codefahp") Long codefahp,
            @QueryParam("statussentfahpCat") String statussentfahpCatt,
            @QueryParam("statussentfahp") String statussentfahp,
            @HeaderParam("authorization") String authString
    ) throws JsonProcessingException {
        List<SentemailbycodefahpContainer> personlist = new ArrayList();
        if (userDAO.existToken(authString) == true) {
            personlist = sentemailbycodefahpDAO.searchbycodefahp(
                    codefahp, statussentfahpCatt, statussentfahp);
        }
        return personlist;
    }

    @POST
    @Path("sentemail")
    @Transactional
    @Consumes({MediaType.APPLICATION_JSON})
    public void sentemailFAHP(
            SentemailbycodefahpSaveContainer saveContainer,
            @HeaderParam("authorization") String authString) {
        if (userDAO.existToken(authString) == true) {
            sentemailbycodefahpDAO.sendprocess(
                    saveContainer.getPersonsselectedlist(),
                    saveContainer.getDescriptionMail());
        }
    }

    @POST
    @Path("forwardemail")
    @Transactional
    @Consumes({MediaType.APPLICATION_JSON})
    public void sentemailFAHP(
            SentemailbycodefahpSavefowardContainer saveContainer,
            @HeaderParam("authorization") String authString) {
        if (userDAO.existToken(authString) == true) {
            sentemailbycodefahpDAO.forwardemail(
                    saveContainer.getSentemailbycodefahp(),
                    saveContainer.getMessageMail());
        }
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
