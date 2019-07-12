/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.mapper;

import com.epn.dtos.QuestionContainer;
import com.epn.entities.Questions;
import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author david
 */
@Mapper(uses = {ItemQuestionMapper.class})
public interface QuestionMapper {

//    @Mapping(target = "codeQuiz", expression = "java(source.getCodeQuiz().getCodeQuiz())")
    QuestionContainer sourceToDestination(Questions source);

    List<QuestionContainer> sourceListToDestination(List<Questions> source);
    // List<Questions> sourceListQuestionContainertoQuestion(List<QuestionContainer> source);
}
