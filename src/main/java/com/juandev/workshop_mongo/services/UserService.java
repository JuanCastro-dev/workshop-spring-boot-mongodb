package com.juandev.workshop_mongo.services;

import com.juandev.workshop_mongo.domain.User;
import com.juandev.workshop_mongo.repository.UserRepository;
import com.juandev.workshop_mongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        User user = repository.findOne(id);
        if (user == null) {
            throw new ObjectNotFoundException("Object not found!");
        }
        return user;
    }

}
