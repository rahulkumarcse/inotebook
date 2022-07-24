package com.devrahul.inotebook.service;

import com.devrahul.inotebook.entity.NotesEntity;
import com.devrahul.inotebook.entity.UserEntity;
import com.devrahul.inotebook.model.AddNotesDto;
import com.devrahul.inotebook.model.GetUser;
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
          String userEmail = Security.getUserEmailFromJwtToken(token);
          if (userEmail != null) {
              try {
                  UserEntity userEntity =  userRepository.findByEmail(userEmail);
                  NotesEntity notes = new NotesEntity();
                  notes.setDate(new Date());
                  notes.setDescription(addNotesDto.getDescription());
                  notes.setTag(addNotesDto.getTag());
                  notes.setTitle(addNotesDto.getTitle());
                  notes.setUser(userEntity.getId());
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
}
