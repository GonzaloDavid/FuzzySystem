/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.mapper;

import com.epn.dtos.CriteriaContainer;
import com.epn.entities.Criteria;
import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author david
 */
@Mapper
public interface CriteriaMapper {

    CriteriaContainer sourceToDestination(Criteria source);

    List<CriteriaContainer> sourceListToDestination(List<Criteria> source);
}
