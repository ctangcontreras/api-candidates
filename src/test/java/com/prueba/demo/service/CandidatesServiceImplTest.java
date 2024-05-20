package com.prueba.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.Optional;

import com.prueba.demo.core.entity.Candidates;
import com.prueba.demo.repository.CandidatesRepository;
import com.prueba.demo.service.impl.CandidatesServiceImpl;
import com.prueba.demo.support.dto.CandidateDto;
import com.prueba.demo.support.dto.Mensajes;
import com.prueba.demo.support.dto.Respuesta;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CandidatesServiceImplTest {
    
    @InjectMocks
    private CandidatesServiceImpl candidatesService;

    @Mock
    private CandidatesRepository candidatesRepository;

    private CandidateDto candidateDto;
    private Candidates candidate;

    @BeforeEach
    public void setUp() {
        candidateDto = new CandidateDto();
        candidateDto.setId(1);
        candidateDto.setIdUser(1);
        candidateDto.setName("Juan");
        candidateDto.setPhone("123456789");
        candidateDto.setEmail("ejemplo1@gmail.com");
        candidateDto.setAddress("Direccion 1");
        candidateDto.setGender("M");
        candidateDto.setSalary_expected(1500.00);

        candidate = new Candidates();
        candidate.setId(candidateDto.getId());
        candidate.setIdUser(candidateDto.getIdUser());
        candidate.setName(candidateDto.getName());
        candidate.setPhone(candidateDto.getPhone());
        candidate.setEmail(candidateDto.getEmail());
        candidate.setAddress(candidateDto.getAddress());
        candidate.setGender(candidateDto.getGender());
        candidate.setSalary_expected(candidateDto.getSalary_expected());
        candidate.setActive(Mensajes.ACTIVE);
        candidate.setDate_create(LocalDateTime.now());
    }

    @Test
    public void testSaveCandidate() throws Exception {
        
        when(candidatesRepository.save(Mockito.any(Candidates.class))).thenReturn(candidate);

        Respuesta<?> response = candidatesService.saveCandidate(candidateDto);

        assertTrue(response.isSuccess());
        assertEquals(Mensajes.ALER_SUCCESS001, response.getMessage());
        verify(candidatesRepository, times(1)).save(any(Candidates.class));
    }

    @Test
    public void testUpdateCandidate() throws Exception {

        when(candidatesRepository.findById(candidateDto.getId())).thenReturn(Optional.of(candidate));
        when(candidatesRepository.save(Mockito.any(Candidates.class))).thenReturn(candidate);

        Respuesta<?> response = candidatesService.updateCandidate(candidateDto);

        assertTrue(response.isSuccess());
        assertEquals(Mensajes.ALER_SUCCESS004, response.getMessage());
        verify(candidatesRepository, times(1)).findById(candidateDto.getId());
        verify(candidatesRepository, times(1)).save(any(Candidates.class));
    }

    @Test
    public void testGetCandidate() throws Exception {

        when(candidatesRepository.findById(candidateDto.getId())).thenReturn(Optional.of(candidate));

        Respuesta<?> response = candidatesService.getCandidate(candidateDto.getId());

        assertTrue(response.isSuccess());
        assertEquals(Mensajes.ALER_SUCCESS002, response.getMessage());
        verify(candidatesRepository, times(1)).findById(candidateDto.getId());
    }

    @Test
    public void testDeleteCandidate() throws Exception {

        when(candidatesRepository.findById(candidateDto.getId())).thenReturn(Optional.of(candidate));
        when(candidatesRepository.save(Mockito.any(Candidates.class))).thenReturn(candidate);

        Respuesta<?> response = candidatesService.deleteCandidate(candidateDto.getId());

        assertTrue(response.isSuccess());
        assertEquals(Mensajes.ALER_SUCCESS003, response.getMessage());
        verify(candidatesRepository, times(1)).findById(candidateDto.getId());
        verify(candidatesRepository, times(1)).save(any(Candidates.class));
    }
}
