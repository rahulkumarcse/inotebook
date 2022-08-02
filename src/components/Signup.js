import React, { useState } from 'react'
import { useNavigate } from "react-router-dom";
const Signup = (props) => {
    const [credentials, setCredentials] = useState({ name :"",email: "", password: "" ,cpassword:""})
    const {name,email,password,cpassword} = credentials
    const onChange = (e) => {
        setCredentials({ ...credentials, [e.target.name]: e.target.value })
    }
    let navigate = useNavigate();
    const handleSubmit = async (e) => {
        e.preventDefault();
        const response = await fetch(`http://localhost:8080/api/v1/auth/addUser`, {
            method: 'POST',
            headers: {
                'content-type': 'application/json',
            },
            body: JSON.stringify({ email,name,password})
        });
        const result = await response.text();
        if (response.status === 200) {
            localStorage.setItem('token', result)
            navigate("/")
            props.showAlert("You are registered","success")
        }
        else {
            props.showAlert("Please fill proper details","warning")
        }

    }
    return (
        <div>
            <form onSubmit={handleSubmit}>
            <div className="mb-3">
                    <label htmlFor="name" className="form-label">Name</label>
                    <input type="text" className="form-control" id="name" name="name" onChange={onChange} value={credentials.name}  />
                </div>
                <div className="mb-3">
                    <label htmlFor="email" className="form-label">Email address</label>
                    <input type="email" className="form-control" id="email" value={credentials.email} onChange={onChange} name="email" aria-describedby="emailHelp" />
                    <div id="emailHelp" className="form-text">We'll never share your email with anyone else.</div>
                </div>
                
                <div className="mb-3">
                    <label htmlFor="password" className="form-label">Password</label>
                    <input type="password" className="form-control" id="password" name="password" onChange={onChange} value={credentials.password}  required minLength={8} />
                </div>
                <div className="mb-3">
                    <label htmlFor="cpassword" className="form-label">Confirm Password</label>
                    <input type="password" className="form-control" id="cpassword" name="cpassword" onChange={onChange} value={credentials.cpassword} required minLength={8} />
                </div>

                <button type="submit" className="btn btn-primary" >Submit</button>
            </form>    </div>
    )
}

export default Signup
