package com.example.quizapp.service;

import com.example.quizapp.entity.Contact;
import com.example.quizapp.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    public Contact findById(Long id) {
        return contactRepository.findById(id);
    }

    public void save(Contact contact) {
        contactRepository.save(contact);
    }

    public void update(Contact contact) {
        contactRepository.update(contact);
    }

    public void deleteById(Long id) {
        contactRepository.deleteById(id);
    }
}
