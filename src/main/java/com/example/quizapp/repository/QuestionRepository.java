package com.example.quizapp.repository;

import com.example.quizapp.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Question> findAll() {
        return jdbcTemplate.query("SELECT * FROM question", new BeanPropertyRowMapper<>(Question.class));
    }

    public Question findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM question WHERE question_id = ?", new BeanPropertyRowMapper<>(Question.class), id);
    }

    public int save(Question question) {
        return jdbcTemplate.update("INSERT INTO question (description, is_active, category_id) VALUES (?, ?, ?)",
                question.getDescription(), question.isActive(), question.getCategory().getCategoryId());
    }

    public int update(Question question) {
        return jdbcTemplate.update("UPDATE question SET description = ?, is_active = ?, category_id = ? WHERE question_id = ?",
                question.getDescription(), question.isActive(), question.getCategory().getCategoryId(), question.getQuestionId());
    }

    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM question WHERE question_id = ?", id);
    }
}

