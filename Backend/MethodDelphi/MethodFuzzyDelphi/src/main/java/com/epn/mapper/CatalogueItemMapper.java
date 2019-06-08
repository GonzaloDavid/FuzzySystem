/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.mapper;

import com.epn.dtos.CatalogueItemContainer;
import com.epn.entities.Catalogueitem;
import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author david
 */
@Mapper
public interface CatalogueItemMapper {
    CatalogueItemContainer sourceToDestination(Catalogueitem source);

    List<CatalogueItemContainer> sourceListToDestination(List<Catalogueitem> source);
}
