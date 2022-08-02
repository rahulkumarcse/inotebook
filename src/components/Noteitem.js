import React,{useContext} from 'react'
import NoteContext from '../context/note/NoteContext';


function Noteitem(props) {
    const { note , updateNote } = props;
    const context = useContext(NoteContext);
    const { deleteNote } = context
 
    return (
        <div className='col-md-3'>
            <div className="card my-3">
                <div className="card-body">
                    <div className='d-flex align-items-center'>
                        <h5 className="card-title"> {note.title}</h5>
                        <i className="far  fa-solid fa-trash mx-3 btn"  onClick={()=>{deleteNote(note.id)}}/>
                        <i className=" fa-solid fa-pen-to-square mx-3 btn" onClick={()=>{updateNote(note)}}></i>
                    </div>

                    <p className="card-text"> {note.description}</p>


                </div>
            </div>
        </div>
    )
}

export default Noteitem
