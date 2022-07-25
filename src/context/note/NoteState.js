import React, { useState } from "react";
import NoteContext from "./NoteContext";

const Notestate = (props) =>{
    const notesInitial = [
        {
            "id": "62dd3b449d642d7de7c788b2",
            "user": "62dd3abb9d642d7de7c788b1",
            "title": "This is updated title",
            "description": "this is updated description",
            "tag": "This is updated tag",
            "date": "2022-07-24T12:29:56.402+00:00"
          },
          {
            "id": "62dd3b649d642d7de7c788b3",
            "user": "62dd3abb9d642d7de7c788b1",
            "title": "Dummy Notes",
            "description": "This is dummy notes",
            "tag": "Dummy Notes",
            "date": "2022-07-24T12:30:28.543+00:00"
          }
    ]
    const[notes,setNotes] = useState(notesInitial);
    return(
        <NoteContext.Provider value={{notes, setNotes}}>
                {props.children}
        </NoteContext.Provider>
    );
}
export default Notestate;