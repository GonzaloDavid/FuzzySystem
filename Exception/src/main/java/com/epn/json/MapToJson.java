/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;
import javax.ejb.Singleton;

/**
 *
 * @author david
 */
@Singleton
public class MapToJson {
    
    private final ObjectMapper mapper;

    public MapToJson() {
        this.mapper = new ObjectMapper();
    }
    
    public String listMapToJson(List<Map<String, Object>> list) throws JsonProcessingException {
        return mapper.writeValueAsString(list);
    }

}
