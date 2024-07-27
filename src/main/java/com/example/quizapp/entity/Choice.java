package com.example.quizapp.entity;

import jakarta.persistence.*;

@Entity
public class Choice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long choiceId;
    private String description;
    private boolean isCorrect;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public Long getChoiceId() {
        return choiceId;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public Question getQuestion() {
        return question;
    }

    public void setChoiceId(Long choiceId) {
        this.choiceId = choiceId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}

