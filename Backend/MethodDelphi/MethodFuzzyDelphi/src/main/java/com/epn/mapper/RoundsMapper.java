/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.mapper;


import com.epn.dtos.RoundsContainer;
import com.epn.entities.Rounds;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 *
 * @author david
 */
@Mapper
public interface RoundsMapper {
    @Mapping(target = "name", expression = "java(source.getPerson().getName())")
    RoundsContainer sourceToDestination(Rounds source); 

    List<RoundsContainer> sourceListToDestination(List<Rounds> source);
}
