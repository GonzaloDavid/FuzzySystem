/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.dtos.RoundsContainer;
import com.epn.entities.FilterTypes;
import com.epn.entities.Rounds;
import com.epn.entities.SearchObject;
import com.epn.mapper.RoundsMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import javax.ejb.Stateless;
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

    public String getLastRoundbycodeQuiz(Long codequiz,Long roundNumber) throws JsonProcessingException {
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

    public void save(Rounds round) {
        update(round);
    }
}
