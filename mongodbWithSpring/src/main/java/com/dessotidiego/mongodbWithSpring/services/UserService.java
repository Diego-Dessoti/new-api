package com.dessotidiego.mongodbWithSpring.services;

import com.dessotidiego.mongodbWithSpring.repository.UserRepository;
import com.dessotidiego.mongodbWithSpring.domain.User;
import com.dessotidiego.mongodbWithSpring.services.exception.ObjectNotFoundException;
import com.sun.jdi.ObjectCollectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        try {
            Optional<User> optionalUser = repository.findById(id);
            return optionalUser.get();
        } catch (Exception e) {
            throw new ObjectNotFoundException("Object not found");
        }

    }


}
