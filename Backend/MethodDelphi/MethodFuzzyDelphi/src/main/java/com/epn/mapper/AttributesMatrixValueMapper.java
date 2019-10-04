/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.mapper;

import com.epn.dtos.AttributesMatrixValueContainer;
import com.epn.entities.AttributesMatrixValue;
import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author david
 */
@Mapper
public interface AttributesMatrixValueMapper {

    AttributesMatrixValueContainer sourceToDestination(AttributesMatrixValue source);

    List<AttributesMatrixValueContainer> sourceListToDestination(List<AttributesMatrixValue> source);
}
