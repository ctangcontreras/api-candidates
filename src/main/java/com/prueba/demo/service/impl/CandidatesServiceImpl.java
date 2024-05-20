package com.prueba.demo.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.demo.core.entity.Candidates;
import com.prueba.demo.repository.CandidatesRepository;
import com.prueba.demo.service.CandidatesService;
import com.prueba.demo.support.dto.CandidateDto;
import com.prueba.demo.support.dto.Mensajes;
import com.prueba.demo.support.dto.Respuesta;

@Service
public class CandidatesServiceImpl implements CandidatesService {

    private static final Logger log = LoggerFactory.getLogger(CandidatesServiceImpl.class);

    @Autowired
    CandidatesRepository candidatesRepository;

    public Respuesta<?> saveCandidate(CandidateDto dto) throws Exception {

        try {
            Candidates candidate = new Candidates();
            candidate.setIdUser(dto.getIdUser());
            candidate.setName(dto.getName());
            candidate.setPhone(dto.getPhone());
            candidate.setEmail(dto.getEmail());
            candidate.setAddress(dto.getAddress());
            candidate.setGender(dto.getGender());
            candidate.setSalary_expected(dto.getSalary_expected());
            candidate.setActive(Mensajes.ACTIVE);
            candidate.setDate_create(LocalDateTime.now());
            candidatesRepository.save(candidate);

            return new Respuesta<>(true, candidate, Mensajes.ALER_SUCCESS001);

        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return new Respuesta<>(true, e.getMessage());
        }

    }

    public Respuesta<?> updateCandidate(CandidateDto dto) throws Exception {
        try {
            Optional<Candidates> list = candidatesRepository.findById(dto.getId());
            if (list.isPresent()) {
                Candidates candidate = list.get();
                candidate.setName(dto.getName());
                candidate.setName(dto.getName());
                candidate.setPhone(dto.getPhone());
                candidate.setEmail(dto.getEmail());
                candidate.setAddress(dto.getAddress());
                candidate.setGender(dto.getGender());
                candidate.setSalary_expected(dto.getSalary_expected());
                candidate.setDate_modify(LocalDateTime.now());
                candidatesRepository.save(candidate);

                return new Respuesta<>(true, list, Mensajes.ALER_SUCCESS005);
            } else {
                return new Respuesta<>(true, list, Mensajes.ALER_SUCCESS002);
            } 
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return new Respuesta<>(true, e.getMessage());
        }
    }

    public Respuesta<?> getCandidate(Integer id) throws Exception {

        try {
            Optional<Candidates> list = candidatesRepository.findById(id);

            if (list.isPresent()) {
                return new Respuesta<>(true, list, Mensajes.ALER_SUCCESS003);
            } else {
                return new Respuesta<>(true, list, Mensajes.ALER_SUCCESS002);
            }
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return new Respuesta<>(true, e.getMessage());
        }
    }

    public Respuesta<?> deleteCandidate(Integer id) throws Exception{

        try {
            
            Optional<Candidates> list = candidatesRepository.findById(id);
            if (list.isPresent()) {
                Candidates candidate = list.get();
                candidate.setActive(Mensajes.INACTIVE);
                candidate.setDate_eliminate(LocalDateTime.now());
                candidatesRepository.save(candidate);

                return new Respuesta<>(true, list, Mensajes.ALER_SUCCESS004);
            } else {
                return new Respuesta<>(true, list, Mensajes.ALER_SUCCESS002);
            }

        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return new Respuesta<>(true, e.getMessage());
        }
    }


}
