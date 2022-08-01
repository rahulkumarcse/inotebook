import React, { useState } from "react";
import NoteContext from "./NoteContext";

const Notestate = (props) =>{
    const notesInitial = [
        {
            "id": "62dd3b449d642d7de7c788be2",
            "user": "62dd3abb9d642d7de7c788b1",
            "title": "This is updated title",
            "description": "this is updated description",
            "tag": "This is updated tag",
            "date": "2022-07-24T12:29:56.402+00:00"
          },
          {
            "id": "62dd3b649d642d7de7c788b3g",
            "user": "62dd3abb9d642d7de7c788b1",
            "title": "My Title",
            "description": "My Title",
            "tag": "Dummy Notes",
            "date": "2022-07-24T12:30:28.543+00:00"
          }
          ,
          {
            "id": "62dd3b649d642d7de7c78e8b3",
            "user": "62dd3abb9d642d7de7c788b1",
            "title": "Dummy Notes",
            "description": "This is dummy notes",
            "tag": "Dummy Notes",
            "date": "2022-07-24T12:30:28.543+00:00"
          },
          {
            "id": "62dd3b649d642d7de7c7er88b3",
            "user": "62dd3abb9d642d7de7c788b1",
            "title": "Dummy Notes",
            "description": "This is dummy notes",
            "tag": "Dummy Notes",
            "date": "2022-07-24T12:30:28.543+00:00"
          },
          {
            "id": "62dd3b649d642d7de7cwr788b3",
            "user": "62dd3abb9d642d7de7c788b1",
            "title": "Dummy Notes",
            "description": "This is dummy notes",
            "tag": "Dummy Notes",
            "date": "2022-07-24T12:30:28.543+00:00"
          },
          {
            "id": "62dd3b649d642d7de7cwew788b3",
            "user": "62dd3abb9d642d7de7c788b1",
            "title": "Dummy Notes",
            "description": "This is dummy notes",
            "tag": "Dummy Notes",
            "date": "2022-07-24T12:30:28.543+00:00"
          },
          {
            "id": "62dd3b649d642d7de7wewc788b3",
            "user": "62dd3abb9d642d7de7c788b1",
            "title": "Dummy Notes",
            "description": "This is dummy notes",
            "tag": "Dummy Notes",
            "date": "2022-07-24T12:30:28.543+00:00"
          }
    ]
    const[notes,setNotes] = useState(notesInitial);

    //addNote
    const addNote = (title , description ,tag) =>{
      console.log("Adding a note")
       const  note =  {
          "id": "s62dd3b649d642zxd7de7wewc788b3",
          "user": "62dd3abb9d642d7de7c788b1",
          "title": title,
          "description": description,
          "tag": tag,
          "date": "2022-07-24T12:30:28.543+00:00"
        };
        setNotes(notes.concat(note))
    }
    //deleteNote
    const deleteNote =(id) =>{
    const  newNote=notes.filter((note)=>{return note.id != id})
      console.log("Deleting note with id:"+id)
      setNotes(newNote)
    }
    //edit note
    const editNote =() =>{
      
    }
    return(
        <NoteContext.Provider value={{notes, addNote,deleteNote, editNote}}>
                {props.children}
        </NoteContext.Provider>
    );
}
export default Notestate;