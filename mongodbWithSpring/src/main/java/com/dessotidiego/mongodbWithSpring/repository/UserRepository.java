package com.dessotidiego.mongodbWithSpring.repository;

import com.dessotidiego.mongodbWithSpring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
