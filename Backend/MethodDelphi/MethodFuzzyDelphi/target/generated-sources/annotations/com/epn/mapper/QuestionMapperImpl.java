package com.epn.mapper;

import com.epn.dtos.QuestionContainer;

import com.epn.entities.Questions;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Generated;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2019-06-24T16:45:02-0500",

    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"

)

public class QuestionMapperImpl implements QuestionMapper {

    @Override

    public QuestionContainer sourceToDestination(Questions source) {

        if ( source == null ) {

            return null;
        }

        QuestionContainer questionContainer = new QuestionContainer();

        questionContainer.setCodeQuestions( source.getCodeQuestions() );

        questionContainer.setCodeQuiz( source.getCodeQuiz() );

        questionContainer.setQuestion( source.getQuestion() );

        questionContainer.setDescription( source.getDescription() );

        questionContainer.setStatusCat( source.getStatusCat() );

        questionContainer.setStatus( source.getStatus() );

        questionContainer.setUserCreate( source.getUserCreate() );

        questionContainer.setUserLastModify( source.getUserLastModify() );

        return questionContainer;
    }

    @Override

    public List<QuestionContainer> sourceListToDestination(List<Questions> source) {

        if ( source == null ) {

            return null;
        }

        List<QuestionContainer> list = new ArrayList<QuestionContainer>();

        for ( Questions questions : source ) {

            list.add( sourceToDestination( questions ) );
        }

        return list;
    }
}

