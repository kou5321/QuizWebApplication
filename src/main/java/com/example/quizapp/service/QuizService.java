package com.example.quizapp.service;

import com.example.quizapp.entity.Quiz;
import com.example.quizapp.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    public List<Quiz> findAll() {
        return quizRepository.findAll();
    }

    public Quiz findById(Long id) {
        return quizRepository.findById(id);
    }

    public void save(Quiz quiz) {
        quizRepository.save(quiz);
    }

    public void update(Quiz quiz) {
        quizRepository.update(quiz);
    }

    public void deleteById(Long id) {
        quizRepository.deleteById(id);
    }

    public List<Quiz> findRecentQuizzesByEmail(String email) {
        return quizRepository.findRecentQuizzesByEmail(email);
    }
}
