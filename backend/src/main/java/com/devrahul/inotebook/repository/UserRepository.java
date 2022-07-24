package com.devrahul.inotebook.repository;

import com.devrahul.inotebook.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<UserEntity, String> {
    @Query(value = "{'email' : ?0}")
    UserEntity findByEmail(String email);
}
