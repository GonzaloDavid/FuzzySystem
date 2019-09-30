/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

import com.epn.entities.SurveybycodefahpPK;
import java.util.List;

/**
 *
 * @author david
 */
public class SurveybycodefahpContainer {
    private SurveybycodefahpPK surveybycodefahpPK;
    private String namequiz;
    private String namequestion;
    private String statusfahp;
    private String statusfahpCat;
    private String namestatusfahp;
    private List<ItemQuestionContainer> itemquestioncontainer;

    public SurveybycodefahpContainer() {
    }

    public SurveybycodefahpContainer(SurveybycodefahpPK surveybycodefahpPK, String namequiz) {
        this.surveybycodefahpPK = surveybycodefahpPK;
        this.namequiz = namequiz;
    }

    public SurveybycodefahpPK getSurveybycodefahpPK() {
        return surveybycodefahpPK;
    }

    public void setSurveybycodefahpPK(SurveybycodefahpPK surveybycodefahpPK) {
        this.surveybycodefahpPK = surveybycodefahpPK;
    }

    public String getNamequiz() {
        return namequiz;
    }

    public void setNamequiz(String namequiz) {
        this.namequiz = namequiz;
    }

    public String getStatusfahp() {
        return statusfahp;
    }

    public void setStatusfahp(String statusfahp) {
        this.statusfahp = statusfahp;
    }

    public String getStatusfahpCat() {
        return statusfahpCat;
    }

    public void setStatusfahpCat(String statusfahpCat) {
        this.statusfahpCat = statusfahpCat;
    }

    public String getNamestatusfahp() {
        return namestatusfahp;
    }

    public void setNamestatusfahp(String namestatusfahp) {
        this.namestatusfahp = namestatusfahp;
    }

    public String getNamequestion() {
        return namequestion;
    }

    public void setNamequestion(String namequestion) {
        this.namequestion = namequestion;
    }

    public List<ItemQuestionContainer> getItemquestioncontainer() {
        return itemquestioncontainer;
    }

    public void setItemquestioncontainer(List<ItemQuestionContainer> itemquestioncontainer) {
        this.itemquestioncontainer = itemquestioncontainer;
    }
    
}
