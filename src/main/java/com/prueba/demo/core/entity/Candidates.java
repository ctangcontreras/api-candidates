package com.prueba.demo.core.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "candidates", schema = "candidatos")
@Setter
@Getter
public class Candidates {
    
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "idUser")
    private Integer idUser;

    @Column(name = "name")
    private String name;
    
    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "gender")
    private String gender;

    @Column(name = "salary_expected")
    private Double salary_expected;

    @Column(name = "active")
    private String active;

    @Column(name = "date_create")
    private LocalDateTime date_create;

    @Column(name = "date_modify")
    private LocalDateTime date_modify;

    @Column(name = "date_eliminate")
    private LocalDateTime date_eliminate;

    public Candidates() {
    }

    public Candidates(Integer id, Integer idUser, String name, String email, String phone, String address,
            String gender, Double salary_expected, String active, LocalDateTime date_create, LocalDateTime date_modify,
            LocalDateTime date_eliminate) {
        this.id = id;
        this.idUser = idUser;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.salary_expected = salary_expected;
        this.active = active;
        this.date_create = date_create;
        this.date_modify = date_modify;
        this.date_eliminate = date_eliminate;
    }

    

}
