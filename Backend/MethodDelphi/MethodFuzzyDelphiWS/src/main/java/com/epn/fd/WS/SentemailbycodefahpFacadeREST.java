/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.WS;

import com.epn.dtos.SentemailbycodefahpSaveContainer;
import com.epn.entities.Sentemailbycodefahp;
import com.epn.entities.SentemailbycodefahpPK;
import com.epn.fd.dao.SentemailbycodefahpDAO;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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

    @POST
    @Path("sentemail")
    @Transactional
    @Consumes({MediaType.APPLICATION_JSON})
    public void sentemailFAHP(
            SentemailbycodefahpSaveContainer saveContainer,
            @HeaderParam("authorization") String authString) {
        // if (userDAO.existToken(authString) == true) {
        sentemailbycodefahpDAO.sendprocess(
                saveContainer.getPersonsselectedlist(),
                saveContainer.getDescriptionMail());
        // }
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
