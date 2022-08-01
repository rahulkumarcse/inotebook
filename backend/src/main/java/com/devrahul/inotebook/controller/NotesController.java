package com.devrahul.inotebook.controller;

import com.devrahul.inotebook.model.AddNotesDto;
import com.devrahul.inotebook.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/notes")
@CrossOrigin("*")
public class NotesController {

    @Autowired
    public NotesService notesService;

    @PostMapping("/addNote")
    private  ResponseEntity<?> addNote(@RequestHeader String token, @RequestBody AddNotesDto addNotesDto){
        List<Object> regResult = notesService.addNotes(token,addNotesDto);
        if(regResult.get(0).toString() .equals("1")){
            return new ResponseEntity<>(regResult.get(1),HttpStatus.OK);
        }
        else return new ResponseEntity<>(regResult.get(1),HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/getNotes")
    private  ResponseEntity<?> getNotes(@RequestHeader String token){
        List<Object> regResult = notesService.getAllNotes(token);
        if(regResult.get(0).toString() .equals("1")){
            return new ResponseEntity<>(regResult.get(1),HttpStatus.OK);
        }
        else return new ResponseEntity<>(regResult.get(1),HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/updateNote/{noteId}")
    private  ResponseEntity<?> updateNote(@RequestHeader String token, @PathVariable String notesId ,@RequestBody AddNotesDto addNotesDto){
        List<Object> regResult = notesService.updateNotes(token,notesId,addNotesDto);
        if(regResult.get(0).toString() .equals("1")){
            return new ResponseEntity<>(regResult.get(1),HttpStatus.OK);
        }
        else return new ResponseEntity<>(regResult.get(1),HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/deleteNote/{noteId}")
    private  ResponseEntity<?> deleteNote(@RequestHeader String token, @PathVariable String noteId){
        List<Object> regResult = notesService.deleteNote(token,noteId);
        if(regResult.get(0).toString() .equals("1")){
            return new ResponseEntity<>(regResult.get(1),HttpStatus.OK);
        }
        else return new ResponseEntity<>(regResult.get(1),HttpStatus.BAD_REQUEST);
    }
}
