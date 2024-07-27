package com.example.quizapp.repository;

import com.example.quizapp.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Category> findAll() {
        return jdbcTemplate.query("SELECT * FROM category", new BeanPropertyRowMapper<>(Category.class));
    }

    public Category findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM category WHERE category_id = ?", new BeanPropertyRowMapper<>(Category.class), id);
    }

    public int save(Category category) {
        return jdbcTemplate.update("INSERT INTO category (name) VALUES (?)", category.getName());
    }

    public int update(Category category) {
        return jdbcTemplate.update("UPDATE category SET name = ? WHERE category_id = ?", category.getName(), category.getCategoryId());
    }

    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM category WHERE category_id = ?", id);
    }
}
