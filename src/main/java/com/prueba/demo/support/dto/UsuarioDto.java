package com.prueba.demo.support.dto;

import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.prueba.demo.validation.PasswordConstraint;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioDto {
    
 

    @Email(message = "El campo 'email' debe tener un formato de correo electrónico válido")
    private String email;

    @PasswordConstraint
    private String password;

  
}
