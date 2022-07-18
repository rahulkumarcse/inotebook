package com.devrahul.inotebook.controller;

import com.devrahul.inotebook.entity.NotesEntity;
import com.devrahul.inotebook.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/notes")
public class NotesController {

    @Autowired
    public NotesService notesService;
    @PostMapping("/saveNotes")
    private ResponseEntity saveNotes(@RequestBody   NotesEntity notes) throws Exception{
            try {
                notesService.saveNotes(notes);
                return ResponseEntity.ok(notes);
            }
            catch (Exception e) {
                return new ResponseEntity<>("Please enter correct input", HttpStatus.BAD_REQUEST);
            }
    }
    @GetMapping("/allNotes")
    private  ResponseEntity<?> getAllNotes(){
        List<NotesEntity> notes = notesService.getAllNotes();

        return ResponseEntity.ok(notes);
    }




}
