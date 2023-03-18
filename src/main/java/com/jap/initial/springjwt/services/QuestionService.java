package com.jap.initial.springjwt.services;

import java.util.Set;

import com.jap.initial.springjwt.entities.exam.Question;

public interface QuestionService {

	public Question addQuestion(Question question);
	public Question updateQuestion(Question quest);
	public Set<Question> getQuestions();
	public Question getQuestion(Long questId);
	public void deleteQuestion(Long questId);
}
