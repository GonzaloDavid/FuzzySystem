/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.WS;

import com.epn.dtos.ProcessFahpconsistencybycriteriaContainer;
import com.epn.entities.ProcessFahpconsistencybycriteria;
import com.epn.entities.ProcessFahpconsistencybycriteriaPK;
import com.epn.fd.dao.ProcessFahpconsistencybycriteriaDAO;
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
@Path("com.epn.entities.processfahpconsistencybycriteria")
public class ProcessFahpconsistencybycriteriaFacadeREST extends AbstractFacade<ProcessFahpconsistencybycriteria> {

    @Inject()
    ProcessFahpconsistencybycriteriaDAO fahpconsistencybycriteriaDAO;

    @Inject()
    UserDAO userDAO;

    @PersistenceContext(unitName = "com.epn.fuzzydelphi_MethodFuzzyDelphiWS_war_1.0PU")
    private EntityManager em;

    private ProcessFahpconsistencybycriteriaPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;codefahp=codefahpValue;codePerson=codePersonValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.epn.entities.ProcessFahpconsistencybycriteriaPK key = new com.epn.entities.ProcessFahpconsistencybycriteriaPK();
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

    public ProcessFahpconsistencybycriteriaFacadeREST() {
        super(ProcessFahpconsistencybycriteria.class);
    }

    @GET
    @Path("getconsistency")
    @Produces({MediaType.APPLICATION_JSON})
    public List<ProcessFahpconsistencybycriteriaContainer> getconsistencybycodefahp(
            @QueryParam("codefahp") Long codefahp,
            @HeaderParam("authorization") String authString
    ) {
        List<ProcessFahpconsistencybycriteriaContainer> processcontainer = new ArrayList();
        if (userDAO.existToken(authString) == true) {
            processcontainer = fahpconsistencybycriteriaDAO.getconsistencybycodefahp(codefahp);
        }
        return processcontainer;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
