/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.mapper;

import com.epn.dtos.CatalogueContainer;
import com.epn.entities.Catalogue;
import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author david
 */
@Mapper(uses = {CatalogueItemMapper.class})
public interface CatalogueMapper {

    CatalogueContainer sourceToDestination(Catalogue source);

    List<CatalogueContainer> sourceListToDestination(List<Catalogue> source);
}
