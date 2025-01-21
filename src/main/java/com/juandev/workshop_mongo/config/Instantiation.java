package com.juandev.workshop_mongo.config;

import com.juandev.workshop_mongo.domain.Post;
import com.juandev.workshop_mongo.domain.User;
import com.juandev.workshop_mongo.repository.PostRepository;
import com.juandev.workshop_mongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        Post post1 = new Post(null,"Hello",sdf.parse("25/08/2024"),"Hello everybody, have a nice day !",maria);
        Post post2 = new Post(null,"The end",sdf.parse("31/12/2024"),"We reached here, the end of another year",alex);

        userRepository.save(Arrays.asList(maria,alex,bob));
        postRepository.save(Arrays.asList(post1,post2));
    }
}
