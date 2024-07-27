package com.example.quizapp.controller;

import com.example.quizapp.entity.Choice;
import com.example.quizapp.service.ChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/choices")
public class ChoiceController {

    @Autowired
    private ChoiceService choiceService;

    @GetMapping
    public String listChoices(Model model) {
        List<Choice> choices = choiceService.findAll();
        model.addAttribute("choices", choices);
        return "choice/list";
    }

    @GetMapping("/{id}")
    public String getChoice(@PathVariable Long id, Model model) {
        Choice choice = choiceService.findById(id);
        model.addAttribute("choice", choice);
        return "choice/details";
    }

    @GetMapping("/create")
    public String createChoiceForm(Model model) {
        model.addAttribute("choice", new Choice());
        return "choice/create";
    }

    @PostMapping("/create")
    public String createChoice(@ModelAttribute Choice choice) {
        choiceService.save(choice);
        return "redirect:/choices";
    }

    @GetMapping("/edit/{id}")
    public String editChoiceForm(@PathVariable Long id, Model model) {
        Choice choice = choiceService.findById(id);
        model.addAttribute("choice", choice);
        return "choice/edit";
    }

    @PostMapping("/edit/{id}")
    public String editChoice(@PathVariable Long id, @ModelAttribute Choice choice) {
        choice.setChoiceId(id);
        choiceService.update(choice);
        return "redirect:/choices";
    }

    @GetMapping("/delete/{id}")
    public String deleteChoice(@PathVariable Long id) {
        choiceService.deleteById(id);
        return "redirect:/choices";
    }
}
