package com.example.quizapp.entity;

public class QuizQuestion {
    private Long qqId;
    private Long quizId;
    private Long questionId;
    private Long userChoiceId;

    // Getters and setters
    public Long getQqId() {
        return qqId;
    }

    public void setQqId(Long qqId) {
        this.qqId = qqId;
    }

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getUserChoiceId() {
        return userChoiceId;
    }

    public void setUserChoiceId(Long userChoiceId) {
        this.userChoiceId = userChoiceId;
    }
}
