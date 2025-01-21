package com.juandev.workshop_mongo.config;

import com.juandev.workshop_mongo.domain.Post;
import com.juandev.workshop_mongo.domain.User;
import com.juandev.workshop_mongo.dto.AuthorDto;
import com.juandev.workshop_mongo.dto.CommentDto;
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

        userRepository.saveAll(Arrays.asList(maria,alex,bob));

        Post post1 = new Post(null,"Hello",sdf.parse("25/08/2024"),"Hello everybody, have a nice day !",new AuthorDto(maria));
        Post post2 = new Post(null,"The end",sdf.parse("31/12/2024"),"We reached here, the end of another year",new AuthorDto(alex));

        CommentDto c1 = new CommentDto("Happy new year!",sdf.parse("01/01/2025"),new AuthorDto(bob));
        CommentDto c2 = new CommentDto("Nice day 4 u 2",sdf.parse("25/08/2024"),new AuthorDto(bob));

        post1.getComments().add(c2);
        post2.getComments().add(c1);

        postRepository.saveAll(Arrays.asList(post1,post2));

        maria.getPosts().add(post1);
        alex.getPosts().add(post2);
        userRepository.save(maria);
        userRepository.save(alex);
    }
}
