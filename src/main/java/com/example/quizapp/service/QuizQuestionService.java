package com.example.quizapp.service;

import com.example.quizapp.entity.QuizQuestion;
import com.example.quizapp.repository.QuizQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizQuestionService {

    @Autowired
    private QuizQuestionRepository quizQuestionRepository;

    public List<QuizQuestion> findAll() {
        return quizQuestionRepository.findAll();
    }

    public QuizQuestion findById(Long id) {
        return quizQuestionRepository.findById(id);
    }

    public void save(QuizQuestion quizQuestion) {
        quizQuestionRepository.save(quizQuestion);
    }

    public void update(QuizQuestion quizQuestion) {
        quizQuestionRepository.update(quizQuestion);
    }

    public void deleteById(Long id) {
        quizQuestionRepository.deleteById(id);
    }
}
