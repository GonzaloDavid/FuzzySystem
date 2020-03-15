/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.WS;

import com.epn.entities.Environment;
import com.epn.entities.EnvironmentPK;
import com.epn.fd.dao.EnvironmentDAO;
import com.epn.fd.dao.UserDAO;
import com.epn.fd.dto.EnvironmentSaveContainer;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author david
 */
@Stateless
@Path("com.epn.entities.environment")
public class EnvironmentFacadeREST extends AbstractFacade<Environment> {

    @Inject()
    EnvironmentDAO environmentDAO;

    @Inject()
    UserDAO userDAO;

    @PersistenceContext(unitName = "com.epn.fuzzydelphi_MethodFuzzyDelphiWS_war_1.0PU")
    private EntityManager em;

    private EnvironmentPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;seqenvironment=seqenvironmentValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.epn.entities.EnvironmentPK key = new com.epn.entities.EnvironmentPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> seqenvironment = map.get("seqenvironment");
        if (seqenvironment != null && !seqenvironment.isEmpty()) {
            key.setSeqenvironment(new java.lang.Long(seqenvironment.get(0)));
        }
        return key;
    }

    public EnvironmentFacadeREST() {
        super(Environment.class);
    }

    @GET
    @Path("getenviroment")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public List<Environment> getEnviromentList(
            @HeaderParam("authorization") String authString
    ) throws JsonProcessingException {
        List<Environment> enviromentList = new ArrayList();
        if (userDAO.existToken(authString) == true) {
            enviromentList = environmentDAO.getenvironmentbyuseplace(null, null);
        }
        return enviromentList;
    }

    @POST
    @Path("save")
    @Transactional
    @Consumes({MediaType.APPLICATION_JSON})
    public List<Environment> saveEnviromentList(
            EnvironmentSaveContainer saveContainer,
            @HeaderParam("authorization") String authString) {
        List<Environment> environmentListSaved = new ArrayList();
        if (userDAO.existToken(authString) == true) {
            environmentListSaved = environmentDAO.save(saveContainer.getEnviromentlist());
            environmentDAO.deleteEnvironment(saveContainer.getEnviromentdeletelist());
        }
        return environmentListSaved;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
