import React, { useState } from "react";
import NoteContext from "./NoteContext";

const backendHostUrl = "http://localhost:8080"
const Notestate = (props) => {
  const notesInitial = []
  const [notes, setNotes] = useState(notesInitial);
  //Get all notes 
  const getNotes = async (title, description, tag) => {
    //API CALL PENDING
    const response = await fetch(`${backendHostUrl}/api/v1/notes/getNotes`, {
      method: 'GET',
      headers: {
        'content-type': 'application/json',
        'token': 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI2MmRkM2FiYjlkNjQyZDdkZTdjNzg4YjEiLCJleHAiOjE2NTkzNzAyODksImlhdCI6MTY1OTM1MjI4OX0.2c9RE2QHuHFdd1GTjogRNGS5UBPbXCMjE2yVwwnz03bgI1ggElWDrX0SFndGBcHC4AFOGefGDWB8cqR2buO4uw'
      },
    });
    const json = await response.json();
    console.log(json)
    setNotes(json)
  }
  //addNote
  const addNote = async (title, description, tag) => {
    //API CALL PENDING
    const response = await fetch(`${backendHostUrl}/api/v1/notes/addNote`, {
      method: 'POST',
      headers: {
        'content-type': 'application/json',
        'token': 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI2MmRkM2FiYjlkNjQyZDdkZTdjNzg4YjEiLCJleHAiOjE2NTkzNzAyODksImlhdCI6MTY1OTM1MjI4OX0.2c9RE2QHuHFdd1GTjogRNGS5UBPbXCMjE2yVwwnz03bgI1ggElWDrX0SFndGBcHC4AFOGefGDWB8cqR2buO4uw'
      },
      body: JSON.stringify({ title, description, tag })
    });
    const json = await response.json();
    //Adding note
    console.log("Adding a note"+json)
    
    setNotes(notes.concat(json))
  }

  //deleteNote
  const deleteNote = async (noteId) => {
    const response = await fetch(`${backendHostUrl}/api/v1/notes/deleteNote/${noteId}`, {
      method: 'DELETE',
      headers: {
        'content-type':'application/json',
        'token': 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI2MmRkM2FiYjlkNjQyZDdkZTdjNzg4YjEiLCJleHAiOjE2NTkzNzAyODksImlhdCI6MTY1OTM1MjI4OX0.2c9RE2QHuHFdd1GTjogRNGS5UBPbXCMjE2yVwwnz03bgI1ggElWDrX0SFndGBcHC4AFOGefGDWB8cqR2buO4uw'
      },
    });
    const newNote = notes.filter((note) => { return note.id !== noteId })
    console.log("Deleting note with id:" + noteId)
    setNotes(newNote)
  }

  //edit note
  const editNote = async (id, title, description, tag) => {
    //API CALL
    const response = await fetch(`${backendHostUrl}/api/v1/notes/updateNote/${id}`, {
      method: 'POST',
      headers: {
        'content-type': 'application/json',
        'token': 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI2MmRkM2FiYjlkNjQyZDdkZTdjNzg4YjEiLCJleHAiOjE2NTkzNzAyODksImlhdCI6MTY1OTM1MjI4OX0.2c9RE2QHuHFdd1GTjogRNGS5UBPbXCMjE2yVwwnz03bgI1ggElWDrX0SFndGBcHC4AFOGefGDWB8cqR2buO4uw'
      },
      body: JSON.stringify({ title, description, tag })
    });
    const json = response.json();
    //Editing notes
    for (let index = 0; index < notes.length; index++) {
      // const element = notes[index];
      // if (element.id === id) {
      //   element.title = title,
      //     element.description = description,
      //     element.tag = tag
      // }
    }
  }
  return (
    <NoteContext.Provider value={{ notes, addNote, deleteNote, editNote ,getNotes}}>
      {props.children}
    </NoteContext.Provider>
  );
}
export default Notestate;