package com.epn.mapper;

import com.epn.dtos.QuizContainer;

import com.epn.entities.Quiz;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Generated;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2019-06-24T16:45:01-0500",

    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"

)

public class QuizMapperImpl implements QuizMapper {

    @Override

    public QuizContainer sourceToDestination(Quiz source) {

        if ( source == null ) {

            return null;
        }

        QuizContainer quizContainer = new QuizContainer();

        quizContainer.setCodeQuiz( source.getCodeQuiz() );

        quizContainer.setNameQuiz( source.getNameQuiz() );

        quizContainer.setShortNameQuiz( source.getShortNameQuiz() );

        quizContainer.setDescription( source.getDescription() );

        quizContainer.setStatus( source.getStatus() );

        quizContainer.setStatusCat( source.getStatusCat() );

        quizContainer.setUserCreate( source.getUserCreate() );

        quizContainer.setUserLastModify( source.getUserLastModify() );

        return quizContainer;
    }

    @Override

    public List<QuizContainer> sourceListToDestination(List<Quiz> source) {

        if ( source == null ) {

            return null;
        }

        List<QuizContainer> list = new ArrayList<QuizContainer>();

        for ( Quiz quiz : source ) {

            list.add( sourceToDestination( quiz ) );
        }

        return list;
    }
}

