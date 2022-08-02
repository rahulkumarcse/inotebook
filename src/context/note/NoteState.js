import React, { useState } from "react";
import NoteContext from "./NoteContext";

const backendHostUrl = "http://localhost:8080"
const Notestate = (props) => {
  const notesInitial = []
  const [notes, setNotes] = useState(notesInitial);
  //Get all notes 
  const getNotes = async () => {
    //API CALL PENDING
    const response = await fetch(`${backendHostUrl}/api/v1/notes/getNotes`, {
      method: 'GET',
      headers: {
        'content-type': 'application/json',
        'token': localStorage.getItem('token')
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
        'token': localStorage.getItem('token')
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
        'token': localStorage.getItem('token')
      },
    });
    const json =  response
    console.log(json)
    const newNote = notes.filter((note) => { return note.id !== noteId })
    console.log("Deleting note with id:" + noteId)
    setNotes(newNote)
  }

  //edit note
  const editNote = async (noteId, title, description, tag) => {
    //API CALL
    const response = await fetch(`${backendHostUrl}/api/v1/notes/updateNote/${noteId}`, {
      method: 'PUT',
      headers: {
        'content-type': 'application/json',
        'token': localStorage.getItem('token')
      },
      body: JSON.stringify({ title, description, tag })
    });
    const json = await response.json();
    //Editing notes on ui
    let newNotes=JSON.parse(JSON.stringify(notes))
   console.log(json)
   for (let index = 0; index < newNotes.length; index++) {
    const element = notes[index];
    if(element.id===noteId){
      newNotes[index].title=title;
      newNotes[index].description=description;
      newNotes[index].tag=tag;
      break;
    }
   }
   setNotes(newNotes)
  }
  return (
    <NoteContext.Provider value={{ notes, addNote, deleteNote, editNote ,getNotes}}>
      {props.children}
    </NoteContext.Provider>
  );
}
export default Notestate;