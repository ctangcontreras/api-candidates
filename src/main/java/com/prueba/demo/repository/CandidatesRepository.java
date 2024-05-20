package com.prueba.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.prueba.demo.core.entity.Candidates;

public interface CandidatesRepository extends JpaRepository<Candidates, Integer>{
    
    @Query("select u from Candidates u where id=:id and active = 'A'")
    Candidates findByIdAndActives(@Param("id") Integer id);
}
