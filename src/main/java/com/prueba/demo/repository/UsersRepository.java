package com.prueba.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.demo.core.entity.Users;


 
public interface UsersRepository extends JpaRepository<Users, Integer>{

    Users findByEmailAndPassword(String email, String password);


}