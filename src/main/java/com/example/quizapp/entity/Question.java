package com.example.quizapp.entity;

import jakarta.persistence.*;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;
    private String description;
    private boolean isActive;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Long getQuestionId() {
        return questionId;
    }

    public String getDescription() {
        return description;
    }

    public boolean isActive() {
        return isActive;
    }

    public Category getCategory() {
        return category;
    }


    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
