/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.mapper;

import com.epn.dtos.DelphiCalculationsContainer;
import com.epn.entities.DelphiCalculations;
import java.util.List;
import org.mapstruct.Mapper;

/**
 *
 * @author ka
 */
@Mapper
public interface DelphiCalculationsMapper {

    DelphiCalculationsContainer sourceToDestination(DelphiCalculations source);

    List<DelphiCalculationsContainer> sourceListToDestination(List<DelphiCalculations> source);

}
