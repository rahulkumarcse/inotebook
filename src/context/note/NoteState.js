import React, { useState } from "react";
import NoteContext from "./NoteContext";

const Notestate = (props) =>{
    const s1 ={
        'name' : 'rahul',
        'class' :'18'
    }
    const update =()=>{
       setTimeout( () =>{
        setState({
            'name' : 'Rahul Kumar',
        'class' :'Boss'
        })
       }, 1000
       )
    }
    const [state,setState] = useState(s1);
    return(
        <NoteContext.Provider value={{state, update}}>
                {props.children}
        </NoteContext.Provider>
    );
}
export default Notestate;