import React, { useState } from "react";
import NoteContext from "./NoteContext";

const Notestate = (props) =>{
    return(
        <NoteContext.Provider value={{}}>
                {props.children}
        </NoteContext.Provider>
    );
}
export default Notestate;