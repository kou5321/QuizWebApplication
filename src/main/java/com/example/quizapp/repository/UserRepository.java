package com.example.quizapp.repository;

import com.example.quizapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM user", new BeanPropertyRowMapper<>(User.class));
    }

    public User findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM user WHERE user_id = ?", new BeanPropertyRowMapper<>(User.class), id);
    }

    public int save(User user) {
        return jdbcTemplate.update("INSERT INTO user (email, password, firstname, lastname, is_active, is_admin) VALUES (?, ?, ?, ?, ?, ?)",
                user.getEmail(), user.getPassword(), user.getFirstname(), user.getLastname(), user.isActive(), user.isAdmin());
    }

    public int update(User user) {
        return jdbcTemplate.update("UPDATE user SET email = ?, password = ?, firstname = ?, lastname = ?, is_active = ?, is_admin = ? WHERE user_id = ?",
                user.getEmail(), user.getPassword(), user.getFirstname(), user.getLastname(), user.isActive(), user.isAdmin(), user.getUserId());
    }

    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM user WHERE user_id = ?", id);
    }

    public User findByEmail(String email) {
        return jdbcTemplate.queryForObject("SELECT * FROM user WHERE email = ?", new BeanPropertyRowMapper<>(User.class), email);
    }
}
