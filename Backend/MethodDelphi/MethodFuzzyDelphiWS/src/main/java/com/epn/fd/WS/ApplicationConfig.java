/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.WS;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author david
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {

        resources.add(com.epn.fd.WS.CatalogueFacadeREST.class);
        resources.add(com.epn.fd.WS.CatalogueitemFacadeREST.class);
        resources.add(com.epn.fd.WS.CriteriaFAHPFacadeREST.class);
        resources.add(com.epn.fd.WS.DelphiCalculationsFacadeREST.class);
        resources.add(com.epn.fd.WS.EnvironmentFacadeREST.class);
        resources.add(com.epn.fd.WS.ItemCommentFacadeREST.class);
        resources.add(com.epn.fd.WS.MenuFacadeREST.class);
        resources.add(com.epn.fd.WS.NewCrossOriginResourceSharingFilter.class);
        resources.add(com.epn.fd.WS.PersonFacadeREST.class);
        resources.add(com.epn.fd.WS.ProcessFAHPFacadeREST.class);
        resources.add(com.epn.fd.WS.QuestionItemFacadeREST.class);
        resources.add(com.epn.fd.WS.QuestionsFacadeREST.class);
        resources.add(com.epn.fd.WS.QuizFacadeREST.class);
        resources.add(com.epn.fd.WS.QuizvaluesFacadeREST.class);
        resources.add(com.epn.fd.WS.ResultFAHPFacadeREST.class);
        resources.add(com.epn.fd.WS.RoundsFacadeREST.class);
        resources.add(com.epn.fd.WS.UserFacadeREST.class);
    }
    
}
