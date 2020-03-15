/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.entities.Environment;
import com.epn.entities.FilterTypes;
import com.epn.entities.SearchObject;
import com.epn.exception.AppException;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author david
 */
@Stateless
public class EnvironmentDAO extends GenericDAO<Environment> {

    public EnvironmentDAO() {
        super(Environment.class);
    }
    public List<Environment>  getenvironmentbyuseplace(String placeofuse,String typeenvironment)
    {
        SearchObject search = new SearchObject("environmentPK");
        search.addParameter("placeofuse", FilterTypes.EQUAL, placeofuse);
        search.addParameter("typeenvironment", FilterTypes.EQUAL, typeenvironment);
        List<Environment> resultList = search(search);
        return resultList;
    }
    public List<Environment> save(List<Environment> enviromentList)
    {
        updateList(enviromentList);
        flush();
        return enviromentList;
    }
       public void deleteEnvironment(List<Environment> idlist) {
        idlist.forEach(elementremove -> {
            Environment foundelement = new Environment();
            foundelement = find(elementremove.getEnvironmentPK());
            try {
                if (foundelement != null) {
                    remove(foundelement);
                }
            } catch (Exception e) {
                throw new AppException(e.toString(),e.toString(), "mysql_forenkey","PROBLEMA DE DEPENDENCIAS");
            }

        });

    }

}
