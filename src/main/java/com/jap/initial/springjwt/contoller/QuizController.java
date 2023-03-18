package com.jap.initial.springjwt.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jap.initial.springjwt.entities.exam.Quiz;
import com.jap.initial.springjwt.services.QuizService;

public class QuizController {
	@Autowired
	public QuizService quizService;
	
	
	//add quiz service
	@PostMapping("/")
	public ResponseEntity<Quiz> add (@RequestBody Quiz quiz){
		return ResponseEntity.ok(this.quizService.addQuiz(quiz));
	}
	
	//update quiz
	
	@PostMapping("/")
	public ResponseEntity<Quiz> update (@RequestBody Quiz quiz){
		return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
	}
	
	//get quizzes
	
	@GetMapping("/")
	public ResponseEntity<?> getQuizzes(){
		return ResponseEntity.ok(this.quizService.getQuizzes());
	}
	
	//get quiz
	
	@GetMapping("/{quizId}")
	public Quiz getQuiz(@PathVariable("quizId") Long quizId){
		return this.quizService.getQuiz(quizId);
	}
	
	//delete quiz
	@DeleteMapping("/{quizId}")
	public void deleteQuiz(@PathVariable("quizId") Long quizId) {
		this.quizService.deleteQuiz(quizId);
	}

}
