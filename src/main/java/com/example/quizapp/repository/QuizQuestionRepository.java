package com.example.quizapp.repository;

import com.example.quizapp.entity.QuizQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuizQuestionRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<QuizQuestion> findAll() {
        return jdbcTemplate.query("SELECT * FROM quizquestion", new BeanPropertyRowMapper<>(QuizQuestion.class));
    }

    public QuizQuestion findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM quizquestion WHERE qq_id = ?", new BeanPropertyRowMapper<>(QuizQuestion.class), id);
    }

    public int save(QuizQuestion quizQuestion) {
        return jdbcTemplate.update("INSERT INTO quizquestion (quiz_id, question_id, user_choice_id) VALUES (?, ?, ?)",
                quizQuestion.getQuiz().getQuizId(), quizQuestion.getQuestion().getQuestionId(), quizQuestion.getUserChoice().getChoiceId());
    }

    public int update(QuizQuestion quizQuestion) {
        return jdbcTemplate.update("UPDATE quizquestion SET quiz_id = ?, question_id = ?, user_choice_id = ? WHERE qq_id = ?",
                quizQuestion.getQuiz().getQuizId(), quizQuestion.getQuestion().getQuestionId(), quizQuestion.getUserChoice().getChoiceId(), quizQuestion.getQqId());
    }

    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM quizquestion WHERE qq_id = ?", id);
    }
}
