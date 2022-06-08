package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.ContactDTO;
import com.example.demo.commons.GenericServiceImpl;
import com.example.demo.models.Contact;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;

@Service
public class ContactServiceImpl extends GenericServiceImpl<Contact, ContactDTO> implements ContactService {

    @Autowired
    private Firestore firestore;

    @Override
    public CollectionReference getCollection() {
        return firestore.collection("contact");
    }

    @Override
    public ContactDTO get(String id) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ContactDTO> getAll() throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

}
