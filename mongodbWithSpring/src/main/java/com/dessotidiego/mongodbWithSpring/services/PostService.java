package com.dessotidiego.mongodbWithSpring.services;

import com.dessotidiego.mongodbWithSpring.domain.Post;
import com.dessotidiego.mongodbWithSpring.domain.User;
import com.dessotidiego.mongodbWithSpring.dto.UserDTO;
import com.dessotidiego.mongodbWithSpring.repository.PostRepository;
import com.dessotidiego.mongodbWithSpring.repository.UserRepository;
import com.dessotidiego.mongodbWithSpring.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;


    public Post findById(String id) {
        try {
            Optional<Post> post = repository.findById(id);
            return post.get();
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException("Object not found");
        }

    }

    public List<Post> findByTitle(String text){
        return repository.findByTitleContaining(text);
    }



}
