package com.jap.initial.springjwt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jap.initial.springjwt.entities.exam.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	

}
