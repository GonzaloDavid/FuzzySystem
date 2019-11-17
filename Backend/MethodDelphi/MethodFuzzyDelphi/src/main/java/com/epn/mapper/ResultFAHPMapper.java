/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.mapper;

import com.epn.dtos.ResultFAHPContainer;
import com.epn.entities.ResultFAHP;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 *
 * @author david
 */
@Mapper
public interface ResultFAHPMapper {

    @Mapping(target = "namequiz", expression = "java(source.getQuiz().getNameQuiz())")
    @Mapping(target = "namequestion", expression = "java(source.getQuestions().getQuestion())")
    @Mapping(target = "nameitem", expression = "java(source.getQuestionItem().getItemLabel())")
    @Mapping(target = "description", expression = "java(source.getQuestions().getDescription())")
    ResultFAHPContainer sourceToDestination(ResultFAHP source);

    List<ResultFAHPContainer> sourceListToDestination(List<ResultFAHP> source);
}
