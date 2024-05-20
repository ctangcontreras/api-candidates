package com.prueba.demo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.demo.core.entity.Users;
import com.prueba.demo.repository.UsersRepository;
import com.prueba.demo.service.UsersService;
import com.prueba.demo.support.dto.DtoResponse;
import com.prueba.demo.support.dto.JwtUtil;
import com.prueba.demo.support.dto.Mensajes;
import com.prueba.demo.support.dto.Respuesta;
import com.prueba.demo.support.dto.UsuarioDto;

@Service
public class UsersServiceImpl implements UsersService {
	private static final Logger log = LoggerFactory.getLogger(UsersServiceImpl.class);

	@Autowired
	UsersRepository usuarioRepository;

	@Autowired
	JwtUtil jwtUtil;

	@Override
	public Respuesta<?> iniciarSesion(UsuarioDto dto) throws Exception {

		try {
			Users user = usuarioRepository.findByEmailAndPassword(dto.getEmail(), dto.getPassword());

			if (user!=null) {
				String token = jwtUtil.createToken(user.getName());

				DtoResponse response = new DtoResponse(user.getId(), token);
				return new Respuesta<>(true, response, Mensajes.ALER_SUCCESS005);
			} else {
				return new Respuesta<>(false, user, Mensajes.ALER002);
			}
			

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return new Respuesta<>(false, e.getMessage());
		}

	}
}