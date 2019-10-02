/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.mapper;

import com.epn.dtos.SentemailbycodefahpContainer;
import com.epn.entities.Sentemailbycodefahp;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 *
 * @author david
 */
@Mapper
public interface SentemailbycodefahpMapper {
    @Mapping(target = "nameperson", expression = "java(source.getPerson().getName())")
     SentemailbycodefahpContainer sourceToDestination(Sentemailbycodefahp source);
    List<SentemailbycodefahpContainer> sourceListToDestination(List<Sentemailbycodefahp> source);
}
