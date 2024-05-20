package com.prueba.demo.service.impl;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.demo.core.entity.Users;
import com.prueba.demo.repository.UsersRepository;
import com.prueba.demo.service.UsersService;
import com.prueba.demo.support.dto.DtoResponse;
import com.prueba.demo.support.dto.JwtUtil;
import com.prueba.demo.support.dto.Respuesta;
import com.prueba.demo.support.dto.UsuarioDto;

@Service
public class UsersServiceImpl implements UsersService {
	private static final Logger log = LoggerFactory.getLogger(UsersServiceImpl.class);


	@Autowired
	UsersRepository usuarioRepository;

	@Autowired
	JwtUtil jwtUtil;
/* 
	@Override
	public Respuesta<?> getListarUsuario() throws Exception {

		
		List<Users> listaUsuarios = usuarioRepository.findAll();

		List<UsuarioDto> listaUsuarioDto = new ArrayList<>();
		UsuarioDto usuarioDto = new UsuarioDto();

		for (Users usuario : listaUsuarios) {
			usuarioDto = new UsuarioDto();
			
			usuarioDto.setId(usuario.getId());
			usuarioDto.setName(usuario.getName());
			usuarioDto.setEmail(usuario.getEmail());
			usuarioDto.setPassword(usuario.getPassword());
			usuarioDto.setActive(usuario.getActive());
			usuarioDto.setDateCreate(usuario.getDateCreate());
			usuarioDto.setDateModify(usuario.getDateModify());
			usuarioDto.setDateEliminate(usuario.getDate_eliminate());
			listaUsuarioDto.add(usuarioDto);
		}
		
		return new Respuesta<>(true, listaUsuarioDto);
	} */


	@Override
	public Respuesta<?> iniciarSesion(UsuarioDto dto) throws Exception {

	 
		  
		Users user = usuarioRepository.findByEmailAndPassword(dto.getEmail(), dto.getPassword());

		String token = jwtUtil.createToken(user.getName());

		DtoResponse response = new DtoResponse(user.getId(), token);
		return new Respuesta<>(true, response, "Se inició sesión correctamente");
	}
}