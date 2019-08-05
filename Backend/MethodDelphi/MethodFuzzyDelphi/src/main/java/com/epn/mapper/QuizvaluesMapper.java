/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.mapper;

import com.epn.dtos.QuizValuesContainer;
import com.epn.entities.Quizvalues;
import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author david
 */
@Mapper
public interface QuizvaluesMapper {

    QuizValuesContainer sourceToDestination(Quizvalues source);

    List<QuizValuesContainer> sourceListToDestination(List<Quizvalues> source);
}
