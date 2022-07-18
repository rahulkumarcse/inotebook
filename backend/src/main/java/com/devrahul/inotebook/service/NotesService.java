package com.devrahul.inotebook.service;

import com.devrahul.inotebook.entity.NotesEntity;
import com.devrahul.inotebook.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesService {

    @Autowired
    private NotesRepository notesRepository;

    public String saveNotes(NotesEntity notesEntity){
        notesRepository.save(notesEntity);
        return "Notes Added";
    }

    public List<NotesEntity> getAllNotes(){
        return notesRepository.findAll();
    }
}
