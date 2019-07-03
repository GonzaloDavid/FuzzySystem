package com.epn.mapper;

import com.epn.dtos.ItemQuestionContainer;

import com.epn.dtos.QuestionContainer;

import com.epn.entities.Questions;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Generated;

import org.mapstruct.factory.Mappers;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2019-07-03T14:31:13-0500",

    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"

)

public class QuestionMapperImpl implements QuestionMapper {

    private final ItemQuestionMapper itemQuestionMapper = Mappers.getMapper( ItemQuestionMapper.class );

    @Override

    public QuestionContainer sourceToDestination(Questions source) {

        if ( source == null ) {

            return null;
        }

        QuestionContainer questionContainer = new QuestionContainer();

        questionContainer.setCodeQuestions( source.getCodeQuestions() );

        questionContainer.setQuestion( source.getQuestion() );

        questionContainer.setDescription( source.getDescription() );

        questionContainer.setStatusCat( source.getStatusCat() );

        questionContainer.setStatus( source.getStatus() );

        questionContainer.setUserCreate( source.getUserCreate() );

        questionContainer.setUserLastModify( source.getUserLastModify() );

        List<ItemQuestionContainer> list = itemQuestionMapper.sourceListToDestination( source.getQuestionItemList() );

        if ( list != null ) {

            questionContainer.setQuestionItemList( list );
        }

        questionContainer.setCodeQuiz( source.getCodeQuiz().getCodeQuiz() );

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

