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
import com.epn.exception.AppException;
import com.epn.fd.dao.EnvironmentDAO;
import com.epn.fd.dao.QuizDAO;
import com.epn.fd.dao.RoundsDAO;
import com.epn.fd.dao.UserDAO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonObject;
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
@Path("com.epn.entities.quiz")
public class QuizFacadeREST extends AbstractFacade<Quiz> {

    @Inject()
    QuizDAO quizDAO;
    
    @Inject()
    RoundsDAO roundsDAO;
    
    @Inject()
    UserDAO userDAO;
    
    @Inject()
    EnvironmentDAO environmentDAO;
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
    public String getQuizbycode(
            @QueryParam("codeQuiz") Long codeQuiz,
            @HeaderParam("authorization") String authString
    )
            throws JsonProcessingException {
        String response = null;
        List<QuizContainer> containers = new ArrayList<>();
        containers = quizDAO.getQuizbycode(codeQuiz);
        ObjectMapper mapper = new ObjectMapper();
        response = mapper.writeValueAsString(containers);
        return response;

    }

    @GET
    @Path("getSurveys")
    @Transactional
    @Produces({MediaType.APPLICATION_JSON})
    public String getSurveys(
            @QueryParam("from") Integer from,
            @QueryParam("to") Integer to,
            @HeaderParam("authorization") String authString
    ) throws JsonProcessingException {
        String listSurveys = null;
        if (userDAO.existToken(authString) == true) {
            listSurveys = quizDAO.getSurveys(from, to);
        }
        return listSurveys;
    }

    @POST
    @Path("save")
    @Transactional
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public QuizContainer saveQuiz(QuizSave quizcontainer, @HeaderParam("authorization") String authString) {
        QuizContainer container = null;
        if (userDAO.existToken(authString) == true) {
            container = quizDAO.saveQuiz(quizcontainer);
        }
        return container;
    }

    @POST
    @Path("delete")
    @Transactional
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public void deleteQuiz(Quiz quiz, @HeaderParam("authorization") String authString) {
        if (userDAO.existToken(authString) == true) {
            quizDAO.deletequiz(quiz);
        }
    }

    @POST
    @Path("sendmail")
    @Transactional
    @Consumes({MediaType.APPLICATION_JSON})
    public void sendMail(
            EmailContainer emailcontainer,
            @HeaderParam("authorization") String authString) {

        if (userDAO.existToken(authString) == true) {

            String uribase = environmentDAO.getenvironmentbyuseplace("quizclient", "frontend").get(0).getEnvironmentPK().getUri();
            Quiz quiz = quizDAO.getQuizbycodes(emailcontainer.getQuiz().getQuizPK().getCodeQuiz());

            List<Questions> questiondeleted = new ArrayList();
            List<QuestionItem> questionItemdeleted = new ArrayList();

            QuizSave quizSave = new QuizSave();
            quizSave.setQuiz(quiz);
            quizSave.setQuestiondeleted(questiondeleted);
            quizSave.setQuestionItemdeleted(questionItemdeleted);
            quizDAO.saveQuiz(quizSave);

            emailcontainer.getPersons().forEach(person -> {
                String key = "FuzziDelphiKey";
                String subject = "FuzziDelphiSystemClient";
                //  String namejson = "roundPK";
                long expirationTime = System.currentTimeMillis() + 604800000;

                RoundsPK roundPK = new RoundsPK();
                roundPK.setCodeQuiz(emailcontainer.getQuiz().getQuizPK().getCodeQuiz());
                roundPK.setRoundNumber(emailcontainer.getRoundNumber());
                roundPK.setCodePerson(person.getCodePerson());
                Rounds round = new Rounds(roundPK);
                round.setRoundsPK(roundPK);

                JsonObject jwt = roundsDAO.generateJWT(key, subject, roundPK, expirationTime);
                round.setToken(jwt.getString("JWT"));
                round.setSentstatusCatalogue("SENTSTATUSCAT");
                round.setSentstatus(emailcontainer.getSentstatus());
                roundsDAO.save(round);
                quizDAO.sendquiz(quiz, person, uribase, emailcontainer.getRoundNumber(), jwt.getString("JWT"));
            });
        }
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
