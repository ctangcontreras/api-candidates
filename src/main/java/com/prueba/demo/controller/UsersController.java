package com.prueba.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.demo.service.UsersService;
import com.prueba.demo.support.dto.Respuesta;
import com.prueba.demo.support.dto.UsuarioDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/users")
@Api(value = "HelloWorld Resource", description = "shows hello world")
public class UsersController {

	private static final Logger log = LoggerFactory.getLogger(UsersController.class);

	@Autowired
	private UsersService usersService;
 

	@ApiOperation(value = "Iniciar sesion")
	@RequestMapping(value = "/iniciarSesion", method = RequestMethod.POST)
	public ResponseEntity<Object> iniciarSesion(@RequestBody UsuarioDto dto) {	
		Respuesta<?> respuesta = null;
		try {
			respuesta = usersService.iniciarSesion(dto);

			if (respuesta.isSuccess()) {				
				return ResponseEntity.ok(respuesta);
			}else{
				return new org.springframework.http.ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return new org.springframework.http.ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
		}
	}


	


 
}
