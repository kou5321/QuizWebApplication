package com.example.quizapp.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quizId;
    private String name;
    private Timestamp timeStart;
    private Timestamp timeEnd;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Long getQuizId() {
        return quizId;
    }

    public String getName() {
        return name;
    }

    public Timestamp getTimeStart() {
        return timeStart;
    }

    public Timestamp getTimeEnd() {
        return timeEnd;
    }

    public User getUser() {
        return user;
    }

    public Category getCategory() {
        return category;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTimeStart(Timestamp timeStart) {
        this.timeStart = timeStart;
    }

    public void setTimeEnd(Timestamp timeEnd) {
        this.timeEnd = timeEnd;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
