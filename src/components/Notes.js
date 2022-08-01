import React, { useContext, useEffect } from 'react'
import NoteContext from '../context/note/NoteContext';
import Noteitem from './Noteitem';
import AddNote from './AddNote'


function Notes() {
  const context = useContext(NoteContext);
  const { notes, getNotes } = context
  useEffect(()=>{
    getNotes()
  },[])
  return (
    <>
      <AddNote />
      <div className='row my-3'>
        {
          notes.map((note) => {
            return <Noteitem note={note} key={note.id} />
          })
        }
      </div>
    </>
  )
}

export default Notes
