/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.mapper;

import com.epn.dtos.ItemQuestionContainer;
import com.epn.entities.QuestionItem;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 *
 * @author david
 */
@Mapper
public interface ItemQuestionMapper {

    @Mapping(target = "codeQuestions", expression = "java(source.getCodeQuestions().getCodeQuestions())")
    @Mapping(target = "codeQuiz", expression = "java(source.getCodeQuestions().getCodeQuiz().getCodeQuiz())")
    ItemQuestionContainer sourceToDestination(QuestionItem source);

    List<ItemQuestionContainer> sourceListToDestination(List<QuestionItem> source);
}
