package com.prueba.demo.service;
 
import com.prueba.demo.support.dto.Respuesta;
import com.prueba.demo.support.dto.UsuarioDto;
 

public interface UsersService {

	Respuesta<?> iniciarSesion(UsuarioDto dto) throws Exception;
}
