package com.jap.initial.springjwt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jap.initial.springjwt.entities.exam.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

}
