/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.mapper;

import com.epn.dtos.FahpContainer;
import com.epn.entities.Fahp;
import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author david
 */
@Mapper
public interface FahpMapper {

    FahpContainer sourceToDestination(Fahp source);

    List<FahpContainer> sourceListToDestination(List<Fahp> source);
}
