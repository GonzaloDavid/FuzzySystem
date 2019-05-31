/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.entities.Catalogueitem;
import com.epn.entities.FilterTypes;
import com.epn.entities.SearchObject;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author david
 */
@Stateless
public class CatalogueItemDAO extends GenericDAO<Catalogueitem> {

    public CatalogueItemDAO() {
        super(Catalogueitem.class);
    }

    public List<Catalogueitem> getCatalogueItembyCodeCat(String codeCat) {
        SearchObject search = new SearchObject("catalogueitemPK");
        search.addParameter("catalogueitemPK.codeCatalogue", FilterTypes.EQUAL, codeCat);
        search.setOrderPropertyName("catalogueitemPK.codeCatalogue");
        search.desc();
 
        List<Catalogueitem> resultList = search(search);
        
        return resultList;
    }
}
