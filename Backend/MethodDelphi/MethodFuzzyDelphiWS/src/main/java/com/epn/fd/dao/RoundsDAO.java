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

    public boolean validateRoundbytoken(String token) throws JsonProcessingException {
        boolean valid = false;
        if (!token.equals("") && token != null) {
            if (validateJWT(token) == true) {
                valid = true;
            } else {
                valid = false;
                //throw new AppException(460, 1, "Token no valido", "Usuario no logeado", "www.google.com", "PERSONUNAUTHORIZED");
            }
        } else {
            valid = false;
            //throw new AppException(460, 1, "No contiene token", "Usuario no logeado", "www.google.com", "USERNOTSIGNIN");
        }
        return valid;
    }

    public boolean validateJWT(String token) throws JsonProcessingException {
        boolean valid;
        RoundsPK payloadRoundPK = getpayloadJWT(token);
        if (payloadRoundPK != null) {
            List<Rounds> round = getRoundbyroundPK(payloadRoundPK.getCodeQuiz(), payloadRoundPK.getRoundNumber(), payloadRoundPK.getCodePerson());
            if (round.size() > 0) {
                if (round.get(0).getToken().equals(token)) {
                    valid = true;
                } else {
                    valid = false;
                    // throw new AppException("TOKEN NO VALIDO", "Los tokens no son iguales");
                }
            } else {
                valid = false;
                // throw new AppException("TOKEN NO VALIDO", "Email no registrado");
            }
        } else {
            valid = false;
        }

        return valid;
    }

    public RoundsPK getpayloadJWT(String token) throws JsonProcessingException {
        RoundsPK pk = null;
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary("FuzziDelphiKey"))
                .parseClaimsJws(token).getBody();
        if (claims.get("roundPK") != null) {
            Object obj = claims.get("roundPK");
            ObjectMapper mapper = new ObjectMapper();
            String jsonstring=mapper.writeValueAsString(obj);
            JSONObject json = new JSONObject(jsonstring);
            
            Long codequiz = Long.parseLong(json.get("codeQuiz").toString());
            Long roundNumber = Long.parseLong(json.get("roundNumber").toString());
            Long codePerson = Long.parseLong(json.get("codePerson").toString());
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
