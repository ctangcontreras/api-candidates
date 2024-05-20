package com.prueba.demo.service;

import com.prueba.demo.support.dto.CandidateDto;
import com.prueba.demo.support.dto.Respuesta;

public interface CandidatesService {

    public Respuesta<?> saveCandidate(CandidateDto dto) throws Exception;
    public Respuesta<?> updateCandidate(CandidateDto dto) throws Exception;
    public Respuesta<?> getCandidate(Integer id) throws Exception;
    public Respuesta<?> deleteCandidate(Integer id) throws Exception;
}
