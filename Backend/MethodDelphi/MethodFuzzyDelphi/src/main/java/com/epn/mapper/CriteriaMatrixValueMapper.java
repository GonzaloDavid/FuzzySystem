/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.mapper;

import com.epn.dtos.CriteriaMatrixValueContainer;
import com.epn.entities.CriteriaMatrixValue;
import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author david
 */
@Mapper
public interface CriteriaMatrixValueMapper {

    CriteriaMatrixValueContainer sourceToDestination(CriteriaMatrixValue source);

    List<CriteriaMatrixValueContainer> sourceListToDestination(List<CriteriaMatrixValue> source);
}
