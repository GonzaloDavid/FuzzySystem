/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.dtos.FahpContainer;
import com.epn.dtos.FahpSaveContainer;
import com.epn.entities.Criteriabycodefahp;
import com.epn.entities.Fahp;
import com.epn.entities.FahpPK;
import com.epn.entities.FilterTypes;
import com.epn.entities.SearchObject;
import com.epn.entities.Surveybycodefahp;
import com.epn.exception.AppException;
import com.epn.mapper.FahpMapper;
import com.epn.mapper.ItemCommentMapper;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author david
 */
@Stateless
public class FahpDAO extends GenericDAO<Fahp> {

    @Inject()
    SurveybycodefahpDAO surveybycodefahpDAO;

    @Inject()
    CriteriabycodefahpDAO criteriabycodefahpDAO;
    
    private final FahpMapper fahpMapper = Mappers.getMapper(FahpMapper.class);

    public FahpDAO() {
        super(Fahp.class);
    }

    public Fahp getFahpbycode(Long codefahp) {
        SearchObject search = new SearchObject("fahpPK");
        search.addParameter("fahpPK.codefahp", FilterTypes.EQUAL, codefahp);
        List<Fahp> resultList = search(search);
        return resultList.get(0);
    }

    public FahpContainer getFahpbycodeContainer(Long codefahp) {
        SearchObject search = new SearchObject("fahpPK");
        search.addParameter("fahpPK.codefahp", FilterTypes.EQUAL, codefahp);
        List<Fahp> resultList = search(search);
        List<FahpContainer> fahplist=fahpMapper.sourceListToDestination(resultList);
        return fahplist.get(0);
    }

    public void updatestatus(FahpPK fahpPK, String status) {
        Fahp exist = find(fahpPK);
        if (exist != null) {
            exist.setStatusfahp(status);
            update(exist);
        }
    }

    public long savefahp(Fahp fahp) {
        update(fahp);
        long codefahp = fahp.getFahpPK().getCodefahp();
        return codefahp;
    }

    public long saveSurveyandCriteriabycode(FahpSaveContainer container) {
        Fahp fahp = new Fahp();
        fahp = container.getFahp();
        long codefahp = savefahp(fahp);
        List<Surveybycodefahp> surveybycodefahplist = container.getSurveybycodefahp();
        surveybycodefahplist.forEach(surveybyfahp -> {
            surveybyfahp.getSurveybycodefahpPK().setCodefahp(codefahp);
        });
        surveybycodefahpDAO.savesurveybycodefahp(surveybycodefahplist);

        List<Criteriabycodefahp> criteriabycodefahp = container.getCriteriabycodefahp();
        criteriabycodefahp.forEach(criteriabyfahp -> {
            criteriabyfahp.getCriteriabycodefahpPK().setCodefahp(codefahp);
        });
        criteriabycodefahpDAO.savecriteriafahp(criteriabycodefahp);
        return codefahp;
    }

    public void deletedfahp(FahpPK fahpPK) {
        Fahp foundelement = find(fahpPK);

        try {
            if (foundelement != null) {
                remove(foundelement);
            }
        } catch (Exception e) {
            throw new AppException(e.toString(),e.toString(), "mysql_forenkey","PROBLEMA DE DEPENDENCIAS");
        }
    }

}
