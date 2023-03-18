package com.jap.initial.springjwt.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jap.initial.springjwt.entities.exam.Question;
import com.jap.initial.springjwt.services.QuestionService;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	public QuestionService questionService;
	
	
	//add question service
	@PostMapping("/addQuestion")
	public ResponseEntity<Question> add (@RequestBody Question question){
		return ResponseEntity.ok(this.questionService.addQuestion(question));
	}
	
	//update question
	
	@PostMapping("/updateQuesttion")
	public ResponseEntity<Question> update (@RequestBody Question question){
		return ResponseEntity.ok(this.questionService.updateQuestion(question));
	}
	
	//get questions
	
	@GetMapping("/getQuestions")
	public ResponseEntity<?> getQuestions(){
		return ResponseEntity.ok(this.questionService.getQuestions());
	}
	
	//get question
	
	@GetMapping("/{questionId}")
	public Question getQuestion(@PathVariable("questionId") Long questionId){
		return this.questionService.getQuestion(questionId);
	}
	
	//delete question
	
	@DeleteMapping("/{questionId}")
	public void deletQuestion(@PathVariable("questionId") Long questionId) {
		this.questionService.deleteQuestion(questionId);
	}

}
