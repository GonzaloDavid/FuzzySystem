/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.dtos;

import com.epn.entities.RoundsPK;

/**
 *
 * @author david
 */
public class RoundsContainer {

    private RoundsPK roundsPK;

    public RoundsContainer() {
    }

    public RoundsContainer(RoundsPK roundsPK) {
        this.roundsPK = roundsPK;
    }

    public RoundsPK getRoundsPK() {
        return roundsPK;
    }

    public void setRoundsPK(RoundsPK roundsPK) {
        this.roundsPK = roundsPK;
    }
}
