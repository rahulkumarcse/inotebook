import './App.css';
import {BrowserRouter as Router , Routes, Route} from 'react-router-dom';
import Navbar from './components/Navbar';
import Home from './components/Home';
import About from './components/About';
import NoteContext from './context/note/NoteContext';
import Notestate from './context/note/NoteState';
import  Alert  from './components/Alert';

function App() {
  return (
    <>
   <Notestate>
    <Router>
    <Navbar/>
    <Alert message="Hello rahul , this is beginning of your app"/>
    <div className='container' >
    <Routes>
    <Route exact path="/" element={<Home/>}></Route>
    <Route exact path="/about" element={<About/>}></Route>
    </Routes>
    </div>
    </Router>
    </Notestate>
    </>
  );
}

export default App;
