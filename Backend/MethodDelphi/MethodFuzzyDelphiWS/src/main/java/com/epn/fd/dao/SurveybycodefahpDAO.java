/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.dtos.ListAndCountContainer;
import com.epn.dtos.SurveybycodefahpContainer;
import com.epn.entities.Fahp;
import com.epn.entities.FilterTypes;
import com.epn.entities.SearchObject;
import com.epn.entities.Surveybycodefahp;
import com.epn.mapper.SurveybycodefahpMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author david
 */
@Stateless
public class SurveybycodefahpDAO extends GenericDAO<Surveybycodefahp> {

    @Inject()
    FahpDAO fahpDAO;

    @Inject()
    ItemQuestionDAO itemQuestionDAO;

    private final SurveybycodefahpMapper mapper = Mappers.getMapper(SurveybycodefahpMapper.class);

    public SurveybycodefahpDAO() {
        super(Surveybycodefahp.class);
    }

    public String getfahplist(Long codefahp, Long codequiz, String namequiz, Integer from, Integer to) throws JsonProcessingException {
        SearchObject search = new SearchObject("surveybycodefahpPK");
        search.addParameter("surveybycodefahpPK.codefahp", FilterTypes.EQUAL, codefahp);
        search.addParameter("surveybycodefahpPK.codeQuiz", FilterTypes.EQUAL, codequiz);
        search.addParameter("quiz.nameQuiz", FilterTypes.LIKE, namequiz);
        search.asc();
        long count = search(search).size();
        search.setFrom(from);
        search.setTo(to);
        List<Surveybycodefahp> resultList = search(search);
        List<SurveybycodefahpContainer> surveybycodefahpContainers = mapper.sourceListToDestination(resultList);
        surveybycodefahpContainers.forEach(item -> {
            Fahp fahp = fahpDAO.getFahpbycode(item.getSurveybycodefahpPK().getCodefahp());
            item.setStatusfahpCat(fahp.getStatusfahpCatt());
            item.setStatusfahp(fahp.getStatusfahp());
            item.setNamestatusfahp(fahp.getCatalogueitem().getNameItem());
            item.setComparison_mechanism(fahp.getValueFAHPCat());
        });
        ListAndCountContainer countContainer = new ListAndCountContainer(count, surveybycodefahpContainers);

        ObjectMapper mapper = new ObjectMapper();
        String response = mapper.writeValueAsString(countContainer);
        return response;
    }

    public void savesurveybycodefahp(List<Surveybycodefahp> surveybycodefahp) {
        updateList(surveybycodefahp);
    }

    public List<SurveybycodefahpContainer> getquizbycodefahp(Long codefahp) {
        SearchObject search = new SearchObject("surveybycodefahpPK");
        search.addParameter("surveybycodefahpPK.codefahp", FilterTypes.EQUAL, codefahp);
        List<Surveybycodefahp> resultList = search(search);
        List<SurveybycodefahpContainer> surveybycodefahpContainers = mapper.sourceListToDestination(resultList);
        surveybycodefahpContainers.forEach(item -> {
            item.setItemquestioncontainer(itemQuestionDAO.getItembyCodeQuizAndCodeQuestion(
                    item.getSurveybycodefahpPK().getCodeQuiz(),
                    item.getSurveybycodefahpPK().getCodeQuestions()));
         /*   item.getItemquestioncontainer().forEach(itemcontainer -> {
                if (itemcontainer.getImageUrl() != null) {
                    String imagebase64 = itemQuestionDAO.getImage(
                            itemcontainer.getQuestionItemPK().getCodeQuiz(),
                            itemcontainer.getQuestionItemPK().getCodeQuestions(),
                            itemcontainer.getQuestionItemPK().getCodeQuizItem());
                    itemcontainer.setImageUrl(imagebase64);
                }
            });*/
        });

        return surveybycodefahpContainers;
    }

    public String getnamequizbycodefahp(Long codefahp) {
        String namequiz = "";
        SearchObject search = new SearchObject("surveybycodefahpPK");
        search.addParameter("surveybycodefahpPK.codefahp", FilterTypes.EQUAL, codefahp);
        List<Surveybycodefahp> resultList = search(search);
        if (resultList.size() > 0) {
            namequiz = resultList.get(0).getQuiz().getNameQuiz();
        }
        return namequiz;
    }
}
