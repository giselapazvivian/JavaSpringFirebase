package com.example.demo.services;

import com.example.demo.DTO.TokenDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.models.User;

public interface UserService {

    User save(UserDTO dto);

    TokenDTO login(UserDTO dto);

    TokenDTO validate(String token);
}