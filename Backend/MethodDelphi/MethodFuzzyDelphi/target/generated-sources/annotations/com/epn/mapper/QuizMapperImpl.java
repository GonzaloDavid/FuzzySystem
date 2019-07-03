package com.epn.mapper;

import com.epn.dtos.QuestionContainer;

import com.epn.dtos.QuizContainer;

import com.epn.entities.Quiz;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Generated;

import org.mapstruct.factory.Mappers;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2019-07-03T14:31:13-0500",

    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"

)

public class QuizMapperImpl implements QuizMapper {

    private final QuestionMapper questionMapper = Mappers.getMapper( QuestionMapper.class );

    @Override

    public QuizContainer sourceToDestination(Quiz source) {

        if ( source == null ) {

            return null;
        }

        QuizContainer quizContainer = new QuizContainer();

        List<QuestionContainer> list = questionMapper.sourceListToDestination( source.getQuestionsList() );

        if ( list != null ) {

            quizContainer.setQuestionsList( list );
        }

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

