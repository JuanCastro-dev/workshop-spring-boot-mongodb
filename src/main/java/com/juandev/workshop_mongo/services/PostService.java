package com.juandev.workshop_mongo.services;

import com.juandev.workshop_mongo.domain.Post;
import com.juandev.workshop_mongo.domain.User;
import com.juandev.workshop_mongo.dto.UserDto;
import com.juandev.workshop_mongo.repository.PostRepository;
import com.juandev.workshop_mongo.repository.UserRepository;
import com.juandev.workshop_mongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Post post = repository.findById(id).get();
        if (post == null) {
            throw new ObjectNotFoundException("Object not found!");
        }
        return post;
    }

    public List<Post> findByTitle(String text) {
        return repository.findByTitleContaining(text);
    }
}
