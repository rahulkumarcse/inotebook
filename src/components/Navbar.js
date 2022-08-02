import React,{useEffect} from 'react';
import {Link,useLocation,useNavigate} from 'react-router-dom';

function Navbar() {
  let location = useLocation();
  let navigate = useNavigate();
  useEffect(() => {
  }, [location]);

  const handleLogout = () =>{
    localStorage.removeItem('token')
    navigate("/login")
  }
  return (
   
      <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
        <div className="container-fluid">
          <Link className="navbar-brand" to="/">iNotebook</Link>
          <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarSupportedContent">
            <ul className="navbar-nav me-auto mb-2 mb-lg-0">
              <li className="nav-item">
                <Link className={`nav-link ${location.pathname==="/"?"active":""}`} aria-current="page" to="/">Home</Link>
              </li>
              <li className="nav-item">
                <Link className={`nav-link ${location.pathname==="/about"?"active":""}`} to="/about">About</Link>
              </li>
              {/* <li className="nav-item dropdown">
                <a className="nav-link dropdown-toggle disabled" href="/" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  Utility
                </a>
                <ul className="dropdown-menu">
                  <li><a className="dropdown-item" href="/buddy">Buddy</a></li>
                  <li><a className="dropdown-item" href="/huddy">Huddy</a></li>
                  <li><hr className="dropdown-divider" /></li>
                  <li><a className="dropdown-item" href="/chaddi">Chaddi</a></li>
                </ul>
              </li> */}
              {/* <li className="nav-item">
                <a className="nav-link disabled">Disabled Testing</a>
              </li> */}
            </ul>
            {!localStorage.getItem('token')?<form className="d-flex" role="search">
              <Link className="btn btn-primary mx-2" to="/login" roles="button">Login</Link>
              <Link className="btn btn-primary mx-2" to="/signup"   roles="button">Signup</Link>
            </form>:<button className='btn btn-primary' onClick={handleLogout}>Logout</button>}
          </div>
        </div>
      </nav>
    
  )
}

export default Navbar
