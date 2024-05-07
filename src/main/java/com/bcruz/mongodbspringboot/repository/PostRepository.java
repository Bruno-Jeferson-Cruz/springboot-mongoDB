package com.bcruz.mongodbspringboot.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bcruz.mongodbspringboot.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{


}
