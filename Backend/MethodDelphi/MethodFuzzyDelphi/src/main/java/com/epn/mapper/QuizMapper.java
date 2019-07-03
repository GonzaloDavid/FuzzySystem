/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.mapper;

import com.epn.dtos.QuizContainer;
import com.epn.entities.Quiz;
import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author david
 */
@Mapper(uses = {QuestionMapper.class}) 
public interface QuizMapper {

   // @Mapping(target = "questionlist", expression = "java(source.getQuestions())")
 //   @Mapping(target = "questionItemList", expression = "java(source.getQuestions().questionItemList())")
   QuizContainer sourceToDestination(Quiz source);
    List<QuizContainer> sourceListToDestination(List<Quiz> source);
}
