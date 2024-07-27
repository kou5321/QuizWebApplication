package com.example.quizapp.service;

import com.example.quizapp.entity.Question;
import com.example.quizapp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    public Question findById(Long id) {
        return questionRepository.findById(id);
    }

    public void save(Question question) {
        questionRepository.save(question);
    }

    public void update(Question question) {
        questionRepository.update(question);
    }

    public void deleteById(Long id) {
        questionRepository.deleteById(id);
    }
}

