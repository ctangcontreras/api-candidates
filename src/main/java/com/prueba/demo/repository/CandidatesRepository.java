package com.prueba.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.demo.core.entity.Candidates;

public interface CandidatesRepository extends JpaRepository<Candidates, Integer>{
    
    
}
