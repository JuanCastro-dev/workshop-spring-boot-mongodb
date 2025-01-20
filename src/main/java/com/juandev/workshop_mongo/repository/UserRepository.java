package com.juandev.workshop_mongo.repository;

import com.juandev.workshop_mongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
