/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.mapper;

import com.epn.dtos.QuizContainer;
import com.epn.dtos.QuizContainerList;
import com.epn.entities.Quiz;
import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author david
 */
@Mapper(uses = {QuestionMapper.class})
public interface QuizMapper {

    QuizContainer sourceToDestination(Quiz source); //Mapear objetos

    List<QuizContainer> sourceListToDestination(List<Quiz> source); //Mapear lista

    QuizContainerList sourceToDestinationList(Quiz source); //Mapear objetos

    List<QuizContainerList> sourceListToDestinationList(List<Quiz> source); //Mapear lista
}
