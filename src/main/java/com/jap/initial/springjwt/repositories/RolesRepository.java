package com.jap.initial.springjwt.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jap.initial.springjwt.model.Roles;
import com.jap.initial.springjwt.model.Users;

public interface RolesRepository extends JpaRepository<Roles, Long>{

	Page<Roles> findAll(Pageable pageable);
    Roles findByName(String name);
    Roles getById(Long id);

}
