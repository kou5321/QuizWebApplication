package com.example.quizapp.controller;

import com.example.quizapp.entity.QuizQuestion;
import com.example.quizapp.service.QuizQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/quizquestions")
public class QuizQuestionController {

    @Autowired
    private QuizQuestionService quizQuestionService;

    @GetMapping
    public String listQuizQuestions(Model model) {
        List<QuizQuestion> quizQuestions = quizQuestionService.findAll();
        model.addAttribute("quizQuestions", quizQuestions);
        return "quizquestion/list";
    }

    @GetMapping("/{id}")
    public String getQuizQuestion(@PathVariable Long id, Model model) {
        QuizQuestion quizQuestion = quizQuestionService.findById(id);
        model.addAttribute("quizQuestion", quizQuestion);
        return "quizquestion/details";
    }

    @GetMapping("/create")
    public String createQuizQuestionForm(Model model) {
        model.addAttribute("quizQuestion", new QuizQuestion());
        return "quizquestion/create";
    }

    @PostMapping("/create")
    public String createQuizQuestion(@ModelAttribute QuizQuestion quizQuestion) {
        quizQuestionService.save(quizQuestion);
        return "redirect:/quizquestions";
    }

    @GetMapping("/edit/{id}")
    public String editQuizQuestionForm(@PathVariable Long id, Model model) {
        QuizQuestion quizQuestion = quizQuestionService.findById(id);
        model.addAttribute("quizQuestion", quizQuestion);
        return "quizquestion/edit";
    }

    @PostMapping("/edit/{id}")
    public String editQuizQuestion(@PathVariable Long id, @ModelAttribute QuizQuestion quizQuestion) {
        quizQuestion.setQqId(id);
        quizQuestionService.update(quizQuestion);
        return "redirect:/quizquestions";
    }

    @GetMapping("/delete/{id}")
    public String deleteQuizQuestion(@PathVariable Long id) {
        quizQuestionService.deleteById(id);
        return "redirect:/quizquestions";
    }
}
