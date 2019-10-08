/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.mapper;

import com.epn.dtos.ProcessFahpconsistencybycriteriaContainer;
import com.epn.entities.ProcessFahpconsistencybycriteria;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 *
 * @author david
 */
@Mapper
public interface ProcessFahpconsistencybycriteriaMapper {

    @Mapping(target = "nameperson", expression = "java(source.getPerson().getName())")
    ProcessFahpconsistencybycriteriaContainer sourceToDestination(ProcessFahpconsistencybycriteria source);

    List<ProcessFahpconsistencybycriteriaContainer> sourceListToDestination(List<ProcessFahpconsistencybycriteria> source);
}
