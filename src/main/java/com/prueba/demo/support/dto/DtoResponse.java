package com.prueba.demo.support.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DtoResponse {
    
    private Integer id;
    private String token;
    
    public DtoResponse() {
    }

    public DtoResponse(Integer id, String token) {
        this.id = id;
        this.token = token;
    }
 
    
 
    

    

    
}
