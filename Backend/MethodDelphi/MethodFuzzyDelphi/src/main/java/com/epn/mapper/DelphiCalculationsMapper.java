/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.mapper;

import com.epn.dtos.DelphiCalculationsContainer;
import com.epn.entities.DelphiCalculations;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 *
 * @author david
 */
@Mapper
public interface DelphiCalculationsMapper {

    @Mapping(target = "namestatusresultcat", expression = "java(source.getCatalogueitem().getNameItem())")
    @Mapping(target = "quizlabel", expression = "java(source.getQuiz().getNameQuiz())")
    @Mapping(target = "questionlabel", expression = "java(source.getQuestions().getQuestion())")
    @Mapping(target = "itemquestionlabel", expression = "java(source.getQuestionItem().getItemLabel())")
    @Mapping(target = "classification", expression = "java(source.getQuestionItem().getClassification())")
    DelphiCalculationsContainer sourceToDestination(DelphiCalculations source);

    List<DelphiCalculationsContainer> sourceListToDestination(List<DelphiCalculations> source);
}
