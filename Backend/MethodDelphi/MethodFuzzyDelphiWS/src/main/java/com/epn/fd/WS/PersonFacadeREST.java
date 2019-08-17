/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.WS;

import com.epn.dtos.EmailContainer;
import com.epn.entities.Person;
import com.epn.exception.AppException;
import com.epn.fd.dao.Mail;
import com.epn.fd.dao.PersonDAO;
import com.epn.fd.dao.UserDAO;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletResponse;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author desarrollador
 */
@Stateless
@Path("com.epn.entities.person")
public class PersonFacadeREST extends AbstractFacade<Person> {

    @Inject()
    PersonDAO personDAO;

    @Inject()
    UserDAO userDAO;

    @PersistenceContext(unitName = "com.epn.fuzzydelphi_MethodFuzzyDelphiWS_war_1.0PU")
    private EntityManager em;

    public PersonFacadeREST() {
        super(Person.class);
    }

    @GET
    @Path("person")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public String getPerson(
            @QueryParam("from") Integer from,
            @QueryParam("to") Integer to,
            @HeaderParam("authorization") String authString
    ) throws JsonProcessingException {
        String allperson = null;
        if (userDAO.existToken(authString) == true) {
            allperson = personDAO.getallperson(from, to);
        }
        return allperson;
    }

    @GET
    @Path("personbycode")
    @Produces({MediaType.APPLICATION_JSON})
    public String getPersonbycode(
            @QueryParam("codeperson") Long codeperson,
            @HeaderParam("authorization") String authString
    ) throws JsonProcessingException {
        String personbycode = null;
        if (userDAO.existToken(authString) == true) {
            personbycode = personDAO.getpersonbycode(codeperson);
        }
        return personbycode;
    }

    @POST
    @Path("save")
    @Transactional
    @Consumes({MediaType.APPLICATION_JSON})
    public Person saveperson(
            Person person,
            @HeaderParam("authorization") String authString) {
        Person personsaved = new Person();
        if (userDAO.existToken(authString) == true) {
            personsaved = personDAO.savePerson(person);
        }

        return personsaved;
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Person entity) {
        super.create(entity);
    }

    @POST
    @Path("delete")
    @Consumes({MediaType.APPLICATION_JSON})
    public void delete(List<Person> idlist,@HeaderParam("authorization") String authString) {
        if (userDAO.existToken(authString) == true) {
           personDAO.deletePerson(idlist);
        }
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Person entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Person find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Person> findAll() {
        return super.findAll();

    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Person> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
