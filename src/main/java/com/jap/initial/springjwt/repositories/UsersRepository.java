package com.jap.initial.springjwt.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jap.initial.springjwt.entities.Users;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {
	
    Page<Users> findAll(Pageable pageable);
    Users findByEmail(String email);
    Users getById(Long id);
    
    List<Users> findByFullNameContainsOrEmailContainsOrPhoneContainsOrPasswordContains
    (String fullName, String email, String phone, String password);

}
