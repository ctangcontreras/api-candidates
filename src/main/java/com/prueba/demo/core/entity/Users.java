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
@Table(name = "users", schema = "candidatos")
@Setter
@Getter
public class Users {

     @Column(name = "id")
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;

     @Column(name = "name")
     private String name;

     @Column(name = "email")
     private String email;

     @Column(name = "active")
     private String active;
     
     @Column(name = "password")
     private String password;

     @Column(name = "date_create")
     private LocalDateTime dateCreate;    

     @Column(name = "date_modify")
     private LocalDateTime dateModify;    

     @Column(name = "date_eliminate")
     private LocalDateTime date_eliminate;
     
     
}
