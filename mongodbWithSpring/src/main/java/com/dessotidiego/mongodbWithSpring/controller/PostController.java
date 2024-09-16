package com.dessotidiego.mongodbWithSpring.controller;

import com.dessotidiego.mongodbWithSpring.domain.Post;
import com.dessotidiego.mongodbWithSpring.domain.User;
import com.dessotidiego.mongodbWithSpring.dto.UserDTO;
import com.dessotidiego.mongodbWithSpring.services.PostService;
import com.dessotidiego.mongodbWithSpring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostService service;

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = service.findById(id);

        return ResponseEntity.ok().body(post);
    }





}
