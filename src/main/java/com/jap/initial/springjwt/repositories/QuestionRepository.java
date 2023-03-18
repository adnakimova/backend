package com.jap.initial.springjwt.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jap.initial.springjwt.entities.exam.Question;
import com.jap.initial.springjwt.entities.exam.Quiz;

public interface QuestionRepository extends JpaRepository<Question, Long>{
	Set<Question> findByQuiz(Quiz quiz);

}
