package com.github.amandaveredas.adressapi.service;

import com.github.amandaveredas.adressapi.entity.User;
import com.github.amandaveredas.adressapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }
}



