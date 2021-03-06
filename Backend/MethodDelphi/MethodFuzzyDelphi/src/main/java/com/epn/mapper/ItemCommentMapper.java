/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.mapper;

import com.epn.dtos.ItemCommentContainer;
import com.epn.entities.ItemComment;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 *
 * @author david
 */
@Mapper
public interface ItemCommentMapper {
    
    @Mapping(target = "nameperson", expression = "java(source.getPerson().getName())")
    ItemCommentContainer sourceToDestination(ItemComment source);

    List<ItemCommentContainer> sourceListToDestination(List<ItemComment> source);
}
