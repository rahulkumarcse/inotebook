package com.devrahul.inotebook.repository;

import com.devrahul.inotebook.entity.NotesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends MongoRepository<NotesEntity,String> {

}
