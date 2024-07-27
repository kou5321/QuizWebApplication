package com.example.quizapp.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
public class QuizQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qqId;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "user_choice_id")
    private Choice userChoice;

    public Long getQqId() {
        return qqId;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public Question getQuestion() {
        return question;
    }

    public Choice getUserChoice() {
        return userChoice;
    }

    public void setQqId(Long qqId) {
        this.qqId = qqId;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setUserChoice(Choice userChoice) {
        this.userChoice = userChoice;
    }
}

