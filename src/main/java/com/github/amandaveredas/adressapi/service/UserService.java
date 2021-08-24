package com.github.amandaveredas.adressapi.service;

import com.github.amandaveredas.adressapi.entity.User;
import com.github.amandaveredas.adressapi.exception.EmptyListException;
import com.github.amandaveredas.adressapi.exception.UserNotFoundException;
import com.github.amandaveredas.adressapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAll() throws EmptyListException {
        if (userRepository.findAll().isEmpty()){
            throw new EmptyListException();
        }
        return userRepository.findAll();
    }

    public void create(User user) {
        userRepository.save(user);
}

    public User getById(Integer id) throws UserNotFoundException {
        User user =  userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));

        return user;
    }


    public void delete(Integer id) throws UserNotFoundException {
       userRepository.findById(id)
               .orElseThrow(() -> new UserNotFoundException(id));

       userRepository.deleteById(id);
    }
}





