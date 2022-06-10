package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.TokenDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.security.JWTProvider;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JWTProvider jwtProvider;

    // public User save(UserDTO dto) {
    // Optional<User> user = userRepository.findByName(dto.getName());
    // if (user.isPresent())
    // return null;
    // String password = passwordEncoder.encode(dto.getPassword());
    // User user = User
    // .name(dto.getName())
    // .password(password)
    // .build();
    // return userRepository.save(user);
    // }

    public TokenDTO login(UserDTO dto) {
        Optional<User> user = userRepository.findByName(dto.getName());
        if (!user.isPresent())
            return null;
        if (passwordEncoder.matches(dto.getPassword(), user.get().getPassword()))
            return new TokenDTO(jwtProvider.createToken(user.get()));
        return null;
    }

    public TokenDTO validate(String token) {
        if (!jwtProvider.validate(token))
            return null;
        String name = jwtProvider.getNameFromToken(token);
        if (!userRepository.findByName(name).isPresent())
            return null;
        return new TokenDTO(token);
    }
}