package com.example.quizapp.controller;

import com.example.quizapp.entity.Contact;
import com.example.quizapp.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    public String listContacts(Model model) {
        List<Contact> contacts = contactService.findAll();
        model.addAttribute("contacts", contacts);
        return "contact/list";
    }

    @GetMapping("/{id}")
    public String getContact(@PathVariable Long id, Model model) {
        Contact contact = contactService.findById(id);
        model.addAttribute("contact", contact);
        return "contact/details";
    }

    @GetMapping("/create")
    public String createContactForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact/form";
    }

    @PostMapping("/create")
    public String createContact(@ModelAttribute Contact contact) {
        contactService.save(contact);
        return "redirect:/contacts";
    }

    @GetMapping("/edit/{id}")
    public String editContactForm(@PathVariable Long id, Model model) {
        Contact contact = contactService.findById(id);
        model.addAttribute("contact", contact);
        return "contact/form";
    }

    @PostMapping("/edit/{id}")
    public String editContact(@PathVariable Long id, @ModelAttribute Contact contact) {
        contact.setContactId(id);
        contactService.update(contact);
        return "redirect:/contacts";
    }

    @GetMapping("/delete/{id}")
    public String deleteContact(@PathVariable Long id) {
        contactService.deleteById(id);
        return "redirect:/contacts";
    }
}

