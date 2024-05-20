package com.prueba.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.prueba.demo.core.entity.Users;
import com.prueba.demo.repository.UsersRepository;
import com.prueba.demo.service.impl.UsersServiceImpl;
import com.prueba.demo.support.dto.JwtUtil;
import com.prueba.demo.support.dto.Mensajes;
import com.prueba.demo.support.dto.Respuesta;
import com.prueba.demo.support.dto.UsuarioDto;

@ExtendWith(MockitoExtension.class)
public class UsersServiceImplTest {

    @InjectMocks
    private UsersServiceImpl usersServiceImpl;

    @Mock
    private UsersRepository usersRepository;

    @Mock
    private JwtUtil jwtUtil;

    private UsuarioDto usuarioDto;
    private Users users;

    @BeforeEach
    public void setUp() {
        usuarioDto = new UsuarioDto();
        usuarioDto.setEmail("prueba@gmail.com");
        usuarioDto.setPassword("123456");

        users = new Users();
        users.setId(1);
        users.setName("Nombre");
        users.setEmail("prueba@gmail.com");
        users.setPassword("123456");
        users.setActive(Mensajes.ACTIVE);
        users.setDateCreate(LocalDateTime.now());

    }

    @Test
    public void testIniciarSesion() throws Exception {

        when(usersRepository.findByEmailAndPassword(usuarioDto.getEmail(), usuarioDto.getPassword())).thenReturn(users);

        Respuesta<?> response = usersServiceImpl.iniciarSesion(usuarioDto);

        assertTrue(response.isSuccess());
        assertEquals(Mensajes.ALER_SUCCESS005, response.getMessage());
        verify(usersRepository, times(1)).findByEmailAndPassword(usuarioDto.getEmail(), usuarioDto.getPassword());
    }
}
