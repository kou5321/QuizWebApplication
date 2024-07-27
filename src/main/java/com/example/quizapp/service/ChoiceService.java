package com.example.quizapp.service;

import com.example.quizapp.entity.Choice;
import com.example.quizapp.repository.ChoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChoiceService {

    @Autowired
    private ChoiceRepository choiceRepository;

    public List<Choice> findAll() {
        return choiceRepository.findAll();
    }

    public Choice findById(Long id) {
        return choiceRepository.findById(id);
    }

    public void save(Choice choice) {
        choiceRepository.save(choice);
    }

    public void update(Choice choice) {
        choiceRepository.update(choice);
    }

    public void deleteById(Long id) {
        choiceRepository.deleteById(id);
    }
}
