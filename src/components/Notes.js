import React, { useContext, useEffect, useRef, useState } from 'react'
import NoteContext from '../context/note/NoteContext';
import Noteitem from './Noteitem';
import AddNote from './AddNote';
import {useNavigate} from 'react-router-dom';

function Notes() {
  const context = useContext(NoteContext);
  const { notes, getNotes ,editNote } = context
  let navigate = useNavigate()
  useEffect(() => {
    if(localStorage.getItem('token')!=null){
      getNotes()
      // eslint-disable-next-line
    }
    else{
      navigate("/login")
    }
    
  },[])
  const ref = useRef(null)
  const refClose = useRef(null)

  const [note, setNote] = useState({id:"", etitle: "", edescription: "", etag: "" })



  const updateNote = (currentNote) => {
    ref.current.click();
    setNote({ id:currentNote.id, etitle: currentNote.title, edescription: currentNote.description, etag: currentNote.tag });
  }
  const handleClick = (e) => {
    console.log("Handling update...", note)
    editNote(note.id,note.etitle,note.edescription,note.etag)
    refClose.current.click();
  }
  const onChange = (e) => {
    setNote({ ...note, [e.target.name]: e.target.value })
  }
  return (
    <>
      <AddNote />
      <button type="button" className="btn btn-primary d-none" data-bs-toggle="modal" ref={ref} data-bs-target="#exampleModal">
        Edit Note Modal
      </button>

      <div className="modal fade" id="exampleModal" tabIndex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div className="modal-dialog">
          <div className="modal-content">
            <div className="modal-header">
              <h5 className="modal-title" id="exampleModalLabel">Edit note</h5>
              <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div className="modal-body">
              <form className='my-3'>
                <div className="mb-3">
                  <label htmlFor="title" className="form-label">Titles</label>
                  <input type="text" className="form-control" id="etitle" name="etitle" value={note.etitle} aria-describedby="emailHelp" onChange={onChange}  required minLength={8}/>
                </div>
                <div className="mb-3">
                  <label htmlFor="description" className="form-label">Description</label>
                  <input type="text" className="form-control" id="edescription" name="edescription" value={note.edescription} onChange={onChange}  required minLength={8}/>
                </div>
                <div className="mb-3">
                  <label htmlFor="tag" className="form-label">Tag</label>
                  <input type="text" className="form-control" id="etag" name="etag" value={note.etag} onChange={onChange}  required minLength={8}/>
                </div>
              </form>
            </div>
            <div className="modal-footer">
              <button ref={refClose} type="button" className="btn btn-secondary" data-bs-dismiss="modal">Close</button>
              <button disabled={note.etag.length <= 8 || note.edescription.length <=8 || note.etitle.length <=8} type="button" className="btn btn-primary" onClick={handleClick}>Save changes</button>
            </div>
          </div>
        </div>
      </div>
      <div className='row my-3'>
        {
          notes.map((note) => {
            return <Noteitem note={note} updateNote={updateNote} key={note.id} />
          })
        }
      </div>
    </>
  )
}

export default Notes
