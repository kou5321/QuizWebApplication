package com.example.quizapp.repository;

import com.example.quizapp.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Contact> findAll() {
        return jdbcTemplate.query("SELECT * FROM contact", new BeanPropertyRowMapper<>(Contact.class));
    }

    public Contact findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM contact WHERE contact_id = ?", new BeanPropertyRowMapper<>(Contact.class), id);
    }

    public int save(Contact contact) {
        return jdbcTemplate.update("INSERT INTO contact (subject, message, email, time) VALUES (?, ?, ?, ?)",
                contact.getSubject(), contact.getMessage(), contact.getEmail(), contact.getTime());
    }

    public int update(Contact contact) {
        return jdbcTemplate.update("UPDATE contact SET subject = ?, message = ?, email = ?, time = ? WHERE contact_id = ?",
                contact.getSubject(), contact.getMessage(), contact.getEmail(), contact.getTime(), contact.getContactId());
    }

    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM contact WHERE contact_id = ?", id);
    }
}
