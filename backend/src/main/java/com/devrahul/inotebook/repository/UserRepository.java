package com.devrahul.inotebook.repository;

import com.devrahul.inotebook.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserEntity, String> {

}
