/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

import com.epn.entities.Criteriabycodefahp;
import com.epn.entities.Fahp;
import com.epn.entities.Surveybycodefahp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author david
 */
public class FahpSaveContainer {
    
    Fahp fahp=new Fahp();
    List<Criteriabycodefahp> criteriabycodefahp= new ArrayList();
    List<Surveybycodefahp> surveybycodefahp=new ArrayList();

    public FahpSaveContainer() {
    }

    public List<Criteriabycodefahp> getCriteriabycodefahp() {
        return criteriabycodefahp;
    }

    public void setCriteriabycodefahp(List<Criteriabycodefahp> criteriabycodefahp) {
        this.criteriabycodefahp = criteriabycodefahp;
    }

    public List<Surveybycodefahp> getSurveybycodefahp() {
        return surveybycodefahp;
    }

    public void setSurveybycodefahp(List<Surveybycodefahp> surveybycodefahp) {
        this.surveybycodefahp = surveybycodefahp;
    }   

    public Fahp getFahp() {
        return fahp;
    }

    public void setFahp(Fahp fahp) {
        this.fahp = fahp;
    }
    
}
