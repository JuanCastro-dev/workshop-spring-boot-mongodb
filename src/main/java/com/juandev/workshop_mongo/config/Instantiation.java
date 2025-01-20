package com.juandev.workshop_mongo.config;

import com.juandev.workshop_mongo.domain.User;
import org.springframework.boot.CommandLineRunner;

public class Instantiation implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
    }
}
