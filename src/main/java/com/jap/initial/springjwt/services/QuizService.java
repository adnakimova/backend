package com.jap.initial.springjwt.services;

import java.util.Set;

import com.jap.initial.springjwt.entities.exam.Quiz;

public interface QuizService {
	
	public Quiz addQuiz(Quiz quiz);
	public Quiz updateQuiz(Quiz quiz);
	public Set<Quiz> getQuizzes();
	public Quiz getQuiz(Long quizId);
	public void deleteQuiz(Long quizId);
	

}
