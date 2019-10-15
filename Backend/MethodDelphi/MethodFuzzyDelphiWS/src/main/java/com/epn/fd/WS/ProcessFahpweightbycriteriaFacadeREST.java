/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.WS;

import com.epn.dtos.ProcessFahpatributebycriteriaContainer;
import com.epn.dtos.ProcessFahpweightbycriteriaContainer;
import com.epn.dtos.QuizContainer;
import com.epn.dtos.QuizSave;
import com.epn.entities.ProcessFahpweightbycriteria;
import com.epn.entities.ProcessFahpweightbycriteriaPK;
import com.epn.fd.dao.ProcessFahpweightbycriteriaDAO;
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
@Path("com.epn.entities.processfahpweightbycriteria")
public class ProcessFahpweightbycriteriaFacadeREST extends AbstractFacade<ProcessFahpweightbycriteria> {

    @Inject()
    ProcessFahpweightbycriteriaDAO processFahpweightbycriteriaDAO;

    @PersistenceContext(unitName = "com.epn.fuzzydelphi_MethodFuzzyDelphiWS_war_1.0PU")
    private EntityManager em;

    private ProcessFahpweightbycriteriaPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;codefahp=codefahpValue;codePerson=codePersonValue;codeCriteria=codeCriteriaValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.epn.entities.ProcessFahpweightbycriteriaPK key = new com.epn.entities.ProcessFahpweightbycriteriaPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> codefahp = map.get("codefahp");
        if (codefahp != null && !codefahp.isEmpty()) {
            key.setCodefahp(new java.lang.Long(codefahp.get(0)));
        }
        java.util.List<String> codeCriteria = map.get("codeCriteria");
        if (codeCriteria != null && !codeCriteria.isEmpty()) {
            key.setCodeCriteria(new java.lang.Long(codeCriteria.get(0)));
        }
        return key;
    }

    public ProcessFahpweightbycriteriaFacadeREST() {
        super(ProcessFahpweightbycriteria.class);
    }

    @GET
    @Path("getattributeprocess")
    @Produces({MediaType.APPLICATION_JSON})
    public List<ProcessFahpweightbycriteriaContainer> getattributeprocessbycodefahp(
            @QueryParam("codefahp") Long codefahp,
            @HeaderParam("authorization") String authString
    ) {
        List<ProcessFahpweightbycriteriaContainer> processcontainer = processFahpweightbycriteriaDAO.getprocesslistbycodefahp(codefahp);
        return processcontainer;
    }

    @GET
    @Path("executefahp")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public void executeFAHP(
            @QueryParam("codefahp") Long codefahp,
            @HeaderParam("authorization") String authString) {
      //  if (userDAO.existToken(authString) == true) {
            processFahpweightbycriteriaDAO.executeFAHP(codefahp);
       // }
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
