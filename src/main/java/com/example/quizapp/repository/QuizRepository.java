package com.example.quizapp.repository;

import com.example.quizapp.entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuizRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Quiz> findAll() {
        return jdbcTemplate.query("SELECT * FROM quiz", new BeanPropertyRowMapper<>(Quiz.class));
    }

    public List<Quiz> findRecentQuizzesByEmail(String email) {
        String sql = "SELECT q.* FROM quiz q " +
                "JOIN user u ON q.user_id = u.user_id " +
                "WHERE u.email = ? " +
                "ORDER BY q.time_end DESC";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Quiz.class), email);
    }

    public Quiz findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM quiz WHERE quiz_id = ?", new BeanPropertyRowMapper<>(Quiz.class), id);
    }

    public int save(Quiz quiz) {
        return jdbcTemplate.update("INSERT INTO quiz (name, time_start, time_end, user_id, category_id) VALUES (?, ?, ?, ?, ?)",
                quiz.getName(), quiz.getTimeStart(), quiz.getTimeEnd(), quiz.getUserId(), quiz.getCategoryId());
    }

    public int update(Quiz quiz) {
        return jdbcTemplate.update("UPDATE quiz SET name = ?, time_start = ?, time_end = ?, user_id = ?, category_id = ? WHERE quiz_id = ?",
                quiz.getName(), quiz.getTimeStart(), quiz.getTimeEnd(), quiz.getUserId(), quiz.getCategoryId(), quiz.getQuizId());
    }

    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM quiz WHERE quiz_id = ?", id);
    }
}
