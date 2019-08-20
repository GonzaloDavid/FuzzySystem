/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.WS;

import com.epn.dtos.ItemCommentContainer;
import com.epn.entities.ItemComment;
import com.epn.entities.ItemCommentPK;
import com.epn.fd.dao.ItemCommentDAO;
import com.epn.fd.dao.UserDAO;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author david
 */
@Stateless
@Path("com.epn.entities.itemcomment")
public class ItemCommentFacadeREST extends AbstractFacade<ItemComment> {

    @Inject()
    ItemCommentDAO itemCommentDAO;

    @Inject()
    UserDAO userDAO;
    @PersistenceContext(unitName = "com.epn.fuzzydelphi_MethodFuzzyDelphiWS_war_1.0PU")
    private EntityManager em;

    private ItemCommentPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;codeQuizItem=codeQuizItemValue;codeQuestions=codeQuestionsValue;codeQuiz=codeQuizValue;codePerson=codePersonValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.epn.entities.ItemCommentPK key = new com.epn.entities.ItemCommentPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> codeQuizItem = map.get("codeQuizItem");
        if (codeQuizItem != null && !codeQuizItem.isEmpty()) {
            key.setCodeQuizItem(new java.lang.Long(codeQuizItem.get(0)));
        }
        java.util.List<String> codeQuestions = map.get("codeQuestions");
        if (codeQuestions != null && !codeQuestions.isEmpty()) {
            key.setCodeQuestions(new java.lang.Long(codeQuestions.get(0)));
        }
        java.util.List<String> codeQuiz = map.get("codeQuiz");
        if (codeQuiz != null && !codeQuiz.isEmpty()) {
            key.setCodeQuiz(new java.lang.Long(codeQuiz.get(0)));
        }
        java.util.List<String> codePerson = map.get("codePerson");
        if (codePerson != null && !codePerson.isEmpty()) {
            key.setCodePerson(new java.lang.Long(codePerson.get(0)));
        }
        java.util.List<String> roundNumber = map.get("roundNumber");
        if (roundNumber != null && !roundNumber.isEmpty()) {
            key.setRoundNumber(new java.lang.Long(roundNumber.get(0)));
        }
        return key;
    }

    public ItemCommentFacadeREST() {
        super(ItemComment.class);
    }

    @GET
    @Path("getcommentbyitem")
    @Produces({MediaType.APPLICATION_JSON})
    public List<ItemCommentContainer> getCommentbyquiz(
            @QueryParam("codeperson") Long codeperson,
            @QueryParam("codeQuiz") Long codeQuiz,
            @QueryParam("codeQuestion") Long codeQuestion,
            @QueryParam("roundNumber") Long roundNumber,
            @QueryParam("codeItem") Long codeItem
    ) {
        List<ItemCommentContainer> commentContainers = null;

        commentContainers = itemCommentDAO.getcommentbyquiz(codeQuiz, codeQuestion, codeItem, roundNumber, codeperson);

        return commentContainers;
    }

    @POST
    @Path("save")
    @Transactional
    @Consumes({MediaType.APPLICATION_JSON})
    public void saveperson(ItemComment comment) {

        itemCommentDAO.saveItemComment(comment);

    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
