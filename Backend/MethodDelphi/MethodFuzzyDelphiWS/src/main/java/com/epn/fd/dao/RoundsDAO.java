/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.dtos.QuizValueSaveContainer;
import com.epn.dtos.RoundsContainer;
import com.epn.entities.FilterTypes;
import com.epn.entities.Rounds;
import com.epn.entities.RoundsPK;
import com.epn.entities.SearchObject;
import com.epn.exception.AppException;
import com.epn.mapper.RoundsMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.xml.bind.DatatypeConverter;
import org.json.JSONObject;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author david
 */
@Stateless
public class RoundsDAO extends GenericDAO<Rounds> {

    private final RoundsMapper roundsMapper = Mappers.getMapper(RoundsMapper.class);

    public RoundsDAO() {
        super(Rounds.class);
    }

    public String getLastRoundbycodeQuiz(Long codequiz, Long roundNumber) throws JsonProcessingException {
        SearchObject search = new SearchObject("roundsPK");
        search.addParameter("roundsPK.codeQuiz", FilterTypes.EQUAL, codequiz);
        search.addParameter("roundsPK.roundNumber", FilterTypes.EQUAL, roundNumber);
        search.addOrderBy("roundsPK.roundNumber", Boolean.FALSE);

        List<Rounds> resultList = search(search);
        List<RoundsContainer> roundsContainers = roundsMapper.sourceListToDestination(resultList);
        ObjectMapper mapper = new ObjectMapper();
        String response = mapper.writeValueAsString(roundsContainers);

        return response;
    }

    public List<Rounds> getRoundbyroundPK(Long codequiz, Long roundNumber, Long codePerson) {
        SearchObject search = new SearchObject("roundsPK");
        search.addParameter("roundsPK.codeQuiz", FilterTypes.EQUAL, codequiz);
        search.addParameter("roundsPK.roundNumber", FilterTypes.EQUAL, roundNumber);
        search.addParameter("roundsPK.codePerson", FilterTypes.EQUAL, codePerson);
        search.addOrderBy("roundsPK.roundNumber", Boolean.FALSE);

        List<Rounds> resultList = search(search);

        return resultList;
    }

    public void save(Rounds round) {
        update(round);
    }

    public Rounds getRoundbypk(RoundsPK roundpk) {
        Rounds foundelement = foundelement = find(roundpk);
        return foundelement;
    }

    public void setsentstatus(QuizValueSaveContainer quizvalues) {
        RoundsPK roundPK = new RoundsPK();
        roundPK.setCodeQuiz(quizvalues.getQuiz().getQuizPK().getCodeQuiz());
        roundPK.setRoundNumber(quizvalues.getRoundNumber());
        roundPK.setCodePerson(quizvalues.getCodeperson());
        //Rounds round = new Rounds(roundPK);
        //round.setRoundsPK(roundPK);
        //round.setSentstatusCatalogue("SENTSTATUSCAT");
        Rounds existround = getRoundbypk(roundPK);
        existround.setToken(existround.getToken());
        if (existround.getSentstatus().equals("sent")) {
            existround.setSentstatus("sentAndAnswered");
        }
        if (existround.getSentstatus().equals("forwardedAndAnswered")) {
            existround.setSentstatus("forwardedAndAnswered");
        }
        if (existround.getSentstatus().equals("sentAndAnswered")) {
            existround.setSentstatus("sentAndAnswered");
        }
        if (existround.getSentstatus().equals("forwarded")) {
            existround.setSentstatus("forwardedAndAnswered");
        }
        save(existround);
    }

    public boolean validateRoundbytoken(String token, Long codeQuiz, Long codeperson, Long roundNumber) {
        boolean valid = false;
        if (token != null) {
            if (!token.equals("")) {
                if (validateJWT(token, codeQuiz, codeperson, roundNumber) == true) {
                    valid = true;
                } else {
                    valid = false;
                    throw new AppException(401, 1, "Token no valido", "Usuario no autorizado", "www.google.com", "PERSONUNAUTHORIZED");
                }
            } else {
                valid = false;
                throw new AppException(401, 1, "No contiene token", "Usuario no autorizado", "www.google.com", "PERSONUNAUTHORIZED");
            }
        } else {
            valid = false;
            throw new AppException(401, 1, "No contiene token", "Usuario no autorizado", "www.google.com", "PERSONUNAUTHORIZED");
        }
        return valid;
    }

    public boolean validateJWT(String token, Long codeQuiz, Long codeperson, Long roundNumber) {
        boolean valid = false;
        RoundsPK payloadRoundPK = getpayloadJWT(token);
        if (payloadRoundPK != null) {
            List<Rounds> round = getRoundbyroundPK(payloadRoundPK.getCodeQuiz(), payloadRoundPK.getRoundNumber(), payloadRoundPK.getCodePerson());
            if (round.size() > 0) {
                if (round.get(0).getToken().equals(token)) {
                    Long codepersontoken = round.get(0).getRoundsPK().getCodePerson();
                    Long roundNumbertoken = round.get(0).getRoundsPK().getRoundNumber();
                    Long codequiztoken = round.get(0).getRoundsPK().getCodeQuiz();
                    if (codepersontoken.compareTo(codeperson) == 0 && codequiztoken.compareTo(codeQuiz) == 0) {
                        valid = true;
                        // throw new AppException("TOKEN NO VALIDO", "Los tokens no son iguales");
                    }
                }
            }
        }
        return valid;
    }

    public RoundsPK getpayloadJWT(String token) {
        RoundsPK pk = null;
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary("FuzziDelphiKey"))
                .parseClaimsJws(token).getBody();
        if (claims.get("codeQuiz") != null && claims.get("roundNumber") != null && claims.get("codePerson") != null) {

            Long codequiz = Long.parseLong(claims.get("codeQuiz").toString());
            Long roundNumber = Long.parseLong(claims.get("roundNumber").toString());
            Long codePerson = Long.parseLong(claims.get("codePerson").toString());
            pk = new RoundsPK();
            pk.setCodePerson(codePerson);
            pk.setRoundNumber(roundNumber);
            pk.setCodeQuiz(codequiz);
        }
        return pk;
    }

    public JsonObject generateJWT(String key, String subject,
            RoundsPK roundPK, long expirationTime) {

        long time = System.currentTimeMillis();
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, key)
                .setSubject(subject)
                .setIssuedAt(new Date(time))
                .setExpiration(new Date(time + expirationTime))
                .claim("codeQuiz", roundPK.getCodeQuiz())
                .claim("roundNumber", roundPK.getRoundNumber())
                .claim("codePerson", roundPK.getCodePerson())
                .compact();

        JsonObject json = Json.createObjectBuilder().
                add("JWT", jwt).build();
        return json;
    }

}
