package com.bcruz.mongodbspringboot.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bcruz.mongodbspringboot.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{


}
