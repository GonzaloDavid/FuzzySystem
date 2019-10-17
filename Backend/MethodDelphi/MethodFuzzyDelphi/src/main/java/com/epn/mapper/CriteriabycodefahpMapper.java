/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.mapper;

import com.epn.dtos.CriteriabycodefahpContainer;
import com.epn.entities.Criteriabycodefahp;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 *
 * @author david
 */
@Mapper
public interface CriteriabycodefahpMapper {

    @Mapping(target = "namecriteria", expression = "java(source.getCriteria().getNameCriteria())")
    @Mapping(target = "criteriaDescription", expression = "java(source.getCriteria().getDescriptionCriteria())")
    CriteriabycodefahpContainer sourceToDestination(Criteriabycodefahp source);

    List<CriteriabycodefahpContainer> sourceListToDestination(List<Criteriabycodefahp> source);
}
