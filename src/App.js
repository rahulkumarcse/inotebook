import './App.css';
import {BrowserRouter as Router , Routes, Route} from 'react-router-dom';
import Navbar from './components/Navbar';

function App() {
  return (
    <>
    <Router>
    <Navbar/>
    <Routes>
    <Route exact path="/" element={<></>}></Route>
    <Route exact path="/" element={<></>}></Route>

    <Route exact path="/" element={<></>}></Route>

    </Routes>
    </Router>
    
    </>
  );
}

export default App;
