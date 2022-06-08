package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Contact;
import com.example.demo.services.ContactServiceImpl;

@RestController
@RequestMapping("/contact")
public class ContactControllers {

    private ContactServiceImpl service;

    @Autowired
    ContactControllers(ContactServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<Contact> findAll() {
        return service.findAll();
    }
}
