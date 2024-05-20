package com.prueba.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.demo.service.UsersService;
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
		
		try {
			return ResponseEntity.ok(usersService.iniciarSesion(dto));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.ok(e);
		}
	}


	


 
}
