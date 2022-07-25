import React, { useEffect } from 'react'
import { useContext } from 'react'
import NoteContext from '../context/note/NoteContext'

function About() {
  const a = useContext(NoteContext)
  useEffect( ()=>{
    a.update()
  },[])
  return (
    
    <div>
      This is about {a.state.name} AND HE IS IN {a.state.class}
    </div>
  )
}

export default About;
