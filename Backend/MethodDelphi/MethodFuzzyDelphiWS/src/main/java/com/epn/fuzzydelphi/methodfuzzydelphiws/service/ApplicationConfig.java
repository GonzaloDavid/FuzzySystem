/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fuzzydelphi.methodfuzzydelphiws.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author desarrollador
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
        resources.add(com.epn.fuzzydelphi.methodfuzzydelphiws.service.AdminisEmailFacadeREST.class);
        resources.add(com.epn.fuzzydelphi.methodfuzzydelphiws.service.CatalogueFacadeREST.class);
        resources.add(com.epn.fuzzydelphi.methodfuzzydelphiws.service.CatalogueitemFacadeREST.class);
        resources.add(com.epn.fuzzydelphi.methodfuzzydelphiws.service.DelphiCalculationsFacadeREST.class);
        resources.add(com.epn.fuzzydelphi.methodfuzzydelphiws.service.GraphicsDataFacadeREST.class);
        resources.add(com.epn.fuzzydelphi.methodfuzzydelphiws.service.GraphicsParamFacadeREST.class);
        resources.add(com.epn.fuzzydelphi.methodfuzzydelphiws.service.MenuFacadeREST.class);
        resources.add(com.epn.fuzzydelphi.methodfuzzydelphiws.service.PersonFacadeREST.class);
        resources.add(com.epn.fuzzydelphi.methodfuzzydelphiws.service.QuestionItemFacadeREST.class);
        resources.add(com.epn.fuzzydelphi.methodfuzzydelphiws.service.QuestionsFacadeREST.class);
        resources.add(com.epn.fuzzydelphi.methodfuzzydelphiws.service.QuizFacadeREST.class);
    }
    
}
