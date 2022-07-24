package com.devrahul.inotebook.service;

import com.devrahul.inotebook.entity.NotesEntity;
import com.devrahul.inotebook.entity.UserEntity;
import com.devrahul.inotebook.model.AddNotesDto;
import com.devrahul.inotebook.repository.NotesRepository;
import com.devrahul.inotebook.repository.UserRepository;
import com.devrahul.inotebook.utility.security.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class NotesService {

    @Autowired
    private NotesRepository notesRepository;
    @Autowired
    private  UserRepository userRepository;

  public List<Object> addNotes(String token , AddNotesDto addNotesDto){
      List<Object> regResult = new ArrayList<Object>();
      if(addNotesDto.getTitle().length()>4 && addNotesDto.getDescription().length() >8 &&addNotesDto.getTag().length() >4){
          String userId = Security.getUserIdFromJwtToken(token);
          if (userId != null) {
              try {
                  UserEntity userEntity =  userRepository.findById(userId).get();
                  NotesEntity notes = new NotesEntity();
                  notes.setDate(new Date());
                  notes.setDescription(addNotesDto.getDescription());
                  notes.setTag(addNotesDto.getTag());
                  notes.setTitle(addNotesDto.getTitle());
                  notes.setUser(userId);
                  notesRepository.save(notes);
                  regResult.add(1);
                  regResult.add(notes);
                  return regResult;
              } catch (Exception e) {
                  regResult.add(0);
                  regResult.add(e.getMessage());
                  return regResult;
              }
          }
          else {
              regResult.add(0);
              regResult.add("Please authenticate using valid token");
              return regResult;
          }
      }
      regResult.add(0);
      regResult.add("Please provide valid details to add new note");
      return regResult;

  }

  public List<Object> getAllNotes(String token){
      List<Object> regResult = new ArrayList<Object>();

      try {
          String userId = Security.getUserIdFromJwtToken(token);
          if(userId!=null){
              List<NotesEntity> getAllNotes = notesRepository.findNotesByUser(userId);
              regResult.add(1);
          regResult.add(getAllNotes);
          return regResult;
          }
          else {
              regResult.add(0);
              regResult.add("Please authenticate using valid token");
              return regResult;
          }
      }
      catch (Exception e){
          regResult.add(0);
          regResult.add(e.getMessage());
          return regResult;
      }
  }
  public  List<Object> updateNotes(String token ,String notesId, AddNotesDto addNotesDto){
      List<Object> regResult = new ArrayList<>();
      String userId = Security.getUserIdFromJwtToken(token);
      try{
          NotesEntity notes = notesRepository.findById(notesId).get();
          if(notes.getUser().equals(userId)){
              notes.setTitle(addNotesDto.getTitle());
              notes.setDescription(addNotesDto.getDescription());
              notes.setTag(addNotesDto.getTag());
              notesRepository.save(notes);
              regResult.add(1);
              regResult.add(notes);
              return  regResult;
          }
          else{
              regResult.add(0);
              regResult.add("Not Allowed");
              return  regResult;
          }
      }
      catch (Exception e){
          regResult.add(0);
          regResult.add("Not found");
          return regResult;
      }
  }
}
