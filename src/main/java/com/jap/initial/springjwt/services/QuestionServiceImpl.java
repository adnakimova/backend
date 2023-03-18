package com.jap.initial.springjwt.services;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jap.initial.springjwt.entities.exam.Question;
import com.jap.initial.springjwt.repositories.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	private QuestionRepository questionRepository;
	
	@Override
	public Question addQuestion(Question question) {
		return this.questionRepository.save(question);
	}

	@Override
	public Question updateQuestion(Question quest) {
		return this.questionRepository.save(quest);
	}

	@Override
	public Set<Question> getQuestions() {
		return new LinkedHashSet<>(this.questionRepository.findAll());
	}

	@Override
	public Question getQuestion(Long questId) {
		return this.questionRepository.findById(questId).get();
	}

	@Override
	public void deleteQuestion(Long questId) {
		
		this.questionRepository.deleteById(questId);
	}

}
