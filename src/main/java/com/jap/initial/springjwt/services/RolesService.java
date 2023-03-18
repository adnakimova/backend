package com.jap.initial.springjwt.services;

import org.springframework.stereotype.Service;

import com.jap.initial.springjwt.entities.Roles;
import com.jap.initial.springjwt.repositories.RolesRepository;

@Service
public class RolesService {
	private RolesRepository rolesRepository;
	
	public void saveRole(Roles role) {
		rolesRepository.save(role);
	}

}
