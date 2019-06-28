package com.epn.mapper;

import com.epn.dtos.ItemQuestionContainer;

import com.epn.entities.QuestionItem;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Generated;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2019-06-28T08:57:14-0500",

    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"

)

public class ItemQuestionMapperImpl implements ItemQuestionMapper {

    @Override

    public ItemQuestionContainer sourceToDestination(QuestionItem source) {

        if ( source == null ) {

            return null;
        }

        ItemQuestionContainer itemQuestionContainer = new ItemQuestionContainer();

        itemQuestionContainer.setCodeQuizItem( source.getCodeQuizItem() );

        itemQuestionContainer.setItemLabel( source.getItemLabel() );

        itemQuestionContainer.setMaximunValue( source.getMaximunValue() );

        itemQuestionContainer.setMinimumValue( source.getMinimumValue() );

        itemQuestionContainer.setAverageValue( source.getAverageValue() );

        itemQuestionContainer.setMaximumParameterSetting( source.getMaximumParameterSetting() );

        itemQuestionContainer.setMinimumParameterSetting( source.getMinimumParameterSetting() );

        itemQuestionContainer.setJumpNext( source.getJumpNext() );

        itemQuestionContainer.setUserCreate( source.getUserCreate() );

        itemQuestionContainer.setUserLastModify( source.getUserLastModify() );

        itemQuestionContainer.setCodeQuestions( source.getCodeQuestions() );

        return itemQuestionContainer;
    }

    @Override

    public List<ItemQuestionContainer> sourceListToDestination(List<QuestionItem> source) {

        if ( source == null ) {

            return null;
        }

        List<ItemQuestionContainer> list = new ArrayList<ItemQuestionContainer>();

        for ( QuestionItem questionItem : source ) {

            list.add( sourceToDestination( questionItem ) );
        }

        return list;
    }
}

