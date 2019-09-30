/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.mapper;

import com.epn.dtos.SurveybycodefahpContainer;
import com.epn.entities.Surveybycodefahp;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 *
 * @author david
 */
@Mapper
public interface SurveybycodefahpMapper {

    @Mapping(target = "namequiz", expression = "java(source.getQuiz().getNameQuiz())")
    @Mapping(target = "namequestion", expression = "java(source.getQuestions().getQuestion())")
    SurveybycodefahpContainer sourceToDestination(Surveybycodefahp source); //Mapear objetos

    List<SurveybycodefahpContainer> sourceListToDestination(List<Surveybycodefahp> source); //Mapear lista

}
