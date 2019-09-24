/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.entities.Criteriabycodefahp;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author david
 */
@Stateless
public class CriteriabycodefahpDAO extends GenericDAO<Criteriabycodefahp> {
    
     public CriteriabycodefahpDAO() {
        super(Criteriabycodefahp.class);
    }
     public void savecriteriafahp(List<Criteriabycodefahp> criterialist)
     {
         updateList(criterialist);
     }

}
