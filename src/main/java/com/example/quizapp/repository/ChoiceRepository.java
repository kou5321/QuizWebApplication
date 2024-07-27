package com.example.quizapp.repository;

import com.example.quizapp.entity.Choice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChoiceRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Choice> findAll() {
        return jdbcTemplate.query("SELECT * FROM choice", new BeanPropertyRowMapper<>(Choice.class));
    }

    public Choice findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM choice WHERE choice_id = ?", new BeanPropertyRowMapper<>(Choice.class), id);
    }

    public int save(Choice choice) {
        return jdbcTemplate.update("INSERT INTO choice (description, is_correct, question_id) VALUES (?, ?, ?)",
                choice.getDescription(), choice.isCorrect(), choice.getQuestionId());
    }

    public int update(Choice choice) {
        return jdbcTemplate.update("UPDATE choice SET description = ?, is_correct = ?, question_id = ? WHERE choice_id = ?",
                choice.getDescription(), choice.isCorrect(), choice.getQuestionId(), choice.getChoiceId());
    }

    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM choice WHERE choice_id = ?", id);
    }
}
