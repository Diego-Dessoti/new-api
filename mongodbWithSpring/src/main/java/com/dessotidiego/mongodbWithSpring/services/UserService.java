package com.dessotidiego.mongodbWithSpring.services;

import com.dessotidiego.mongodbWithSpring.dto.UserDTO;
import com.dessotidiego.mongodbWithSpring.repository.UserRepository;
import com.dessotidiego.mongodbWithSpring.domain.User;
import com.dessotidiego.mongodbWithSpring.services.exception.ObjectNotFoundException;
import com.sun.jdi.ObjectCollectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
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
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException("Object not found");
        }

    }

    public User insert(User user) {
        return repository.insert(user);
    }

    public User fromDTO(UserDTO dto) {
        return new User(dto.getId(), dto.getName(), dto.getEmail());
    }

    public void delete(String id){
        findById(id);
        repository.deleteById( id);
    }

    public User update(User obj){
        try{
        User newObj = repository.findById(obj.getId()).get();
        updateData(newObj, obj);
        return repository.save(newObj);
        }catch (NoSuchElementException e){
            throw new ObjectNotFoundException("Object not found");
        }
    }

    public void updateData(User newObj, User obj){
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

}
