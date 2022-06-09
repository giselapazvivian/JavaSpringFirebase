package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.ContactDTO;
import com.example.demo.models.Contact;
import com.example.demo.services.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactControllers {

    @Autowired
    private ContactService service;

    @GetMapping("/all")
    public List<ContactDTO> findAll() throws Exception {
        return service.findAll();
    }

    @GetMapping("/find/{id}")
    public ContactDTO find(@PathVariable String id) throws Exception {
        return service.get(id);
    }

    @PostMapping("save/{id}")
    public ResponseEntity<String> save(@RequestBody Contact contact, @PathVariable String id) throws Exception {
        if (id == null || id.length() == 0 || id.equals("null")) {
            id = service.save(contact);
        } else {
            service.save(contact, id);
        }
        return new ResponseEntity<String>(id, HttpStatus.OK);
    }

    // @GetMapping("/delete/{id}")
    // public ResponseEntity<ContactDTO> delete(@PathVariable String id) throws
    // Exception {
    // ContactDTO contact = ContactService.get(id);
    // if (contact != null) {
    // ContactService.delete(id);
    // } else {
    // return new ResponseEntity<ContactDTO>(HttpStatus.NO_CONTENT);
    // }

    // return new ResponseEntity<ContactDTO>(contact, HttpStatus.OK);
    // }

}
