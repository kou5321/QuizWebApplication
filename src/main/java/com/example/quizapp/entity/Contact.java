package com.example.quizapp.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactId;
    private String subject;
    private String message;
    private String email;
    private Timestamp time;

    public Long getContactId() {
        return contactId;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    public String getEmail() {
        return email;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}

