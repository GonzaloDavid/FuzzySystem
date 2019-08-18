/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.WS;

import com.epn.dtos.Login;
import com.epn.entities.User;
import com.epn.entities.UserPK;
import com.epn.fd.dao.UserDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonObject;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author david
 */
@Stateless
@Path("com.epn.entities.user")
public class UserFacadeREST extends AbstractFacade<User> {

    @Inject()
    UserDAO userDAO;
    @PersistenceContext(unitName = "com.epn.fuzzydelphi_MethodFuzzyDelphiWS_war_1.0PU")
    private EntityManager em;

    private UserPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;codeuser=codeuserValue;email=emailValue;username=usernameValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.epn.entities.UserPK key = new com.epn.entities.UserPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> codeuser = map.get("codeuser");
        if (codeuser != null && !codeuser.isEmpty()) {
            key.setCodeuser(new java.lang.Long(codeuser.get(0)));
        }
        java.util.List<String> email = map.get("email");
        if (email != null && !email.isEmpty()) {
            key.setEmail(email.get(0));
        }
        java.util.List<String> username = map.get("username");
        if (username != null && !username.isEmpty()) {
            key.setUsername(username.get(0));
        }
        return key;
    }

    public UserFacadeREST() {
        super(User.class);
    }

    @POST
    @Path("signup")
    @Transactional
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public void login(User user) {
         userDAO.SignUp(user);
    }
    
    
    @POST
    @Path("login")
    @Transactional
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public JsonObject login(Login login) {
        return userDAO.comparePassword(login.getEmail(), login.getPassword());
    }

    @GET
    @Path("logout")
    @Consumes({MediaType.APPLICATION_JSON})
    public void LogOut(
            @QueryParam("email") String email,
            @HeaderParam("authorization") String authString
    ) {
        if (userDAO.existToken(authString) == true) {
        userDAO.logout(email);
        }
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(User entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, User entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        com.epn.entities.UserPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public User find(@PathParam("id") PathSegment id) {
        com.epn.entities.UserPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<User> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<User> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
