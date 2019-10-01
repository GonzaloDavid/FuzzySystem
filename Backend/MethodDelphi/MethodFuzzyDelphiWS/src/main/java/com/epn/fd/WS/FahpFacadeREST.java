/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.WS;

import com.epn.dtos.FahpSaveContainer;
import com.epn.entities.Fahp;
import com.epn.entities.FahpPK;
import com.epn.fd.dao.FahpDAO;
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

/**
 *
 * @author david
 */
@Stateless
@Path("com.epn.entities.fahp")
public class FahpFacadeREST extends AbstractFacade<Fahp> {

    @Inject()
    FahpDAO fahpDAO;
    @PersistenceContext(unitName = "com.epn.fuzzydelphi_MethodFuzzyDelphiWS_war_1.0PU")
    private EntityManager em;

    public FahpFacadeREST() {
        super(Fahp.class);
    }

    @POST
    @Path("delete")
    @Consumes({MediaType.APPLICATION_JSON})
    public void delete(FahpPK fahpPK, @HeaderParam("authorization") String authString) {
       // if (userDAO.existToken(authString) == true) {
            fahpDAO.deletedfahp(fahpPK);
       // }
    }

    @POST
    @Path("save")
    @Transactional
    @Consumes({MediaType.APPLICATION_JSON})
    public void savefahp(FahpSaveContainer fahpSaveContainer,
            @HeaderParam("authorization") String authString) {
        // if (userDAO.existToken(authString) == true) {
        fahpDAO.saveSurveyandCriteriabycode(fahpSaveContainer);
        //}
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
