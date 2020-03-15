/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dto;

import com.epn.entities.Environment;
import java.util.List;

/**
 *
 * @author david
 */
public class EnvironmentSaveContainer {
    List<Environment> enviromentlist;
    List<Environment> enviromentdeletelist;

    public EnvironmentSaveContainer() {
    }

    public List<Environment> getEnviromentlist() {
        return enviromentlist;
    }

    public void setEnviromentlist(List<Environment> enviromentlist) {
        this.enviromentlist = enviromentlist;
    }

    public List<Environment> getEnviromentdeletelist() {
        return enviromentdeletelist;
    }

    public void setEnviromentdeletelist(List<Environment> enviromentdeletelist) {
        this.enviromentdeletelist = enviromentdeletelist;
    }
    
    
    
}
