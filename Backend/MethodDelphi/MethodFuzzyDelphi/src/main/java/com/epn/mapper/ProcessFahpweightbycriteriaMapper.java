/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.mapper;

import com.epn.dtos.ProcessFahpweightbycriteriaContainer;
import com.epn.entities.ProcessFahpweightbycriteria;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 *
 * @author david
 */
@Mapper
public interface ProcessFahpweightbycriteriaMapper {

    @Mapping(target = "namecriteria", expression = "java(source.getCriteria().getNameCriteria())")
    @Mapping(target = "criteriadescription", expression = "java(source.getCriteria().getDescriptionCriteria())")
    ProcessFahpweightbycriteriaContainer sourceToDestination(ProcessFahpweightbycriteria source);

    List<ProcessFahpweightbycriteriaContainer> sourceListToDestination(List<ProcessFahpweightbycriteria> source);
}
