/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.mapper;

import com.epn.dtos.ProcessFahpatributebycriteriaContainer;
import com.epn.entities.ProcessFahpatributebycriteria;
import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author david
 */
@Mapper
public interface ProcessFahpatributebycriteriaMapper {

    ProcessFahpatributebycriteriaContainer sourceToDestination(ProcessFahpatributebycriteria source);

    List<ProcessFahpatributebycriteriaContainer> sourceListToDestination(List<ProcessFahpatributebycriteria> source);
}
