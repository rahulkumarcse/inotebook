package com.devrahul.inotebook.controller;

import com.devrahul.inotebook.entity.NotesEntity;
import com.devrahul.inotebook.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notes")
public class NotesController {

    @Autowired
    public NotesService notesService;
    @PostMapping("/saveNotes")
    private ResponseEntity saveNotes(@RequestBody NotesEntity notes){
        return  ResponseEntity.ok(notesService.saveNotes(notes));
    }

}
