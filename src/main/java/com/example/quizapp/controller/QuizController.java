package com.example.quizapp.controller;

import com.example.quizapp.entity.Quiz;
import com.example.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/quizzes")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping
    public String listQuizzes(Model model) {
        List<Quiz> quizzes = quizService.findAll();
        model.addAttribute("quizzes", quizzes);
        return "quiz/list";
    }

    @GetMapping("/{id}")
    public String getQuiz(@PathVariable Long id, Model model) {
        Quiz quiz = quizService.findById(id);
        model.addAttribute("quiz", quiz);
        return "quiz/details";
    }

    @GetMapping("/create")
    public String createQuizForm(Model model) {
        model.addAttribute("quiz", new Quiz());
        return "quiz/create";
    }

    @PostMapping("/create")
    public String createQuiz(@ModelAttribute Quiz quiz) {
        quizService.save(quiz);
        return "redirect:/quizzes";
    }

    @GetMapping("/edit/{id}")
    public String editQuizForm(@PathVariable Long id, Model model) {
        Quiz quiz = quizService.findById(id);
        model.addAttribute("quiz", quiz);
        return "quiz/edit";
    }

    @PostMapping("/edit/{id}")
    public String editQuiz(@PathVariable Long id, @ModelAttribute Quiz quiz) {
        quiz.setQuizId(id);
        quizService.update(quiz);
        return "redirect:/quizzes";
    }

    @GetMapping("/delete/{id}")
    public String deleteQuiz(@PathVariable Long id) {
        quizService.deleteById(id);
        return "redirect:/quizzes";
    }
}
