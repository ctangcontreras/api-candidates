package com.prueba.demo.support.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CandidateDto {

    private Integer id;
    private Integer idUser;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String gender;
    private Double salary_expected;
    private String active;
}
