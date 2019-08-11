/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.WS;

import com.epn.dtos.EmailContainer;
import com.epn.dtos.QuizContainer;
import com.epn.dtos.QuizSave;
import com.epn.entities.QuestionItem;
import com.epn.entities.Questions;
import com.epn.entities.Quiz;
import com.epn.entities.QuizPK;
import com.epn.entities.Rounds;
import com.epn.entities.RoundsPK;
import com.epn.fd.dao.QuizDAO;
import com.epn.fd.dao.RoundsDAO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
@Path("com.epn.entities.quiz")
public class QuizFacadeREST extends AbstractFacade<Quiz> {

    @Inject
    QuizDAO quizDAO;
    @Inject
    RoundsDAO roundsDAO;
    @PersistenceContext(unitName = "com.epn.fuzzydelphi_MethodFuzzyDelphiWS_war_1.0PU")
    private EntityManager em;

    private QuizPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;codeQuestions=codeQuestionsValue;codeQuiz=codeQuizValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.epn.entities.QuizPK key = new com.epn.entities.QuizPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> codeQuestions = map.get("codeQuiz");
        if (codeQuestions != null && !codeQuestions.isEmpty()) {
            key.setCodeQuiz(new java.lang.Long(codeQuestions.get(0)));
        }
        return key;
    }

    public QuizFacadeREST() {
        super(Quiz.class);
    }

    @GET
    @Path("getquiz")
    @Transactional
    @Produces({MediaType.APPLICATION_JSON})
    public String getQuizbycode(@QueryParam("codeQuiz") Long codeQuiz) throws JsonProcessingException {
        List<QuizContainer> containers = new ArrayList<>();
        containers = quizDAO.getQuizbycode(codeQuiz);
        ObjectMapper mapper = new ObjectMapper();
        String response = mapper.writeValueAsString(containers);
        return response;

    }

    @GET
    @Path("getSurveys")
    @Transactional
    @Produces({MediaType.APPLICATION_JSON})
    public String getSurveys(
            @QueryParam("from") Integer from,
            @QueryParam("to") Integer to
    ) throws JsonProcessingException {
        String listSurveys = quizDAO.getSurveys(from, to);
        return listSurveys;
    }

    @POST
    @Path("save")
    @Transactional
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public QuizContainer saveQuiz(QuizSave quizcontainer) {

        return quizDAO.saveQuiz(quizcontainer);

    }

    @POST
    @Path("delete")
    @Transactional
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public void deleteQuiz(Quiz quiz) {

        quizDAO.deletequiz(quiz);

    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Quiz entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Quiz entity) {
        super.edit(entity);
    }

    @POST
    @Path("sendmail")
    @Transactional
    @Consumes({MediaType.APPLICATION_JSON})
    public void sendMail(EmailContainer emailcontainer) {

        emailcontainer.getPersons().forEach(person -> {
            RoundsPK roundPK = new RoundsPK();
            roundPK.setCodeQuiz(emailcontainer.getQuiz().getQuizPK().getCodeQuiz());
            roundPK.setRoundNumber(emailcontainer.getRoundNumber());
            roundPK.setCodePerson(person.getCodePerson());
            Rounds round = new Rounds(roundPK);
            round.setRoundsPK(roundPK);
            round.setSentstatusCatalogue("SENTSTATUSCAT");
            round.setSentstatus(emailcontainer.getSentstatus());
            roundsDAO.save(round);
        });
        List<Questions> questiondeleted = new ArrayList();
        List<QuestionItem> questionItemdeleted = new ArrayList();

        QuizSave quizSave = new QuizSave();
        quizSave.setQuiz(emailcontainer.getQuiz());
        quizSave.setQuestiondeleted(questiondeleted);
        quizSave.setQuestionItemdeleted(questionItemdeleted);
        quizDAO.saveQuiz(quizSave);
        quizDAO.sendquiz(emailcontainer);

    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Quiz find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Quiz> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Quiz> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
