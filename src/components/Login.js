import React, { useState } from 'react'
import { useNavigate } from "react-router-dom";
const Login = () => {
    const [credential, setCredential] = useState({ email: "", password: "" })

    const onChange = (e) => {
        setCredential({ ...credential, [e.target.name]: e.target.value })
    }
    let navigate = useNavigate();
    const handleSubmit = async (e) => {
        e.preventDefault();
        const response = await fetch(`http://localhost:8080/api/v1/auth/login`, {
            method: 'POST',
            headers: {
                'content-type': 'application/json',
            },
            body: JSON.stringify({ email: credential.email, password: credential.password })
        });
        const result = await response.text();
        if (response.status === 200) {
            localStorage.setItem('token', result)
            navigate("/")
        }
        else {
            alert("Please enter correct credetials")
        }

    }


    return (
        <div>
            <form onSubmit={handleSubmit}>
                <div className="mb-3">
                    <label htmlFor="email" className="form-label">Email address</label>
                    <input type="email" className="form-control" id="email" value={credential.email} onChange={onChange} name="email" aria-describedby="emailHelp" />
                    <div id="emailHelp" className="form-text">We'll never share your email with anyone else.</div>
                </div>
                <div className="mb-3">
                    <label htmlFor="password" className="form-label">Password</label>
                    <input type="password" className="form-control" id="password" name="password" onChange={onChange} value={credential.password} />
                </div>

                <button type="submit" className="btn btn-primary" >Submit</button>
            </form>
        </div>
    )
}

export default Login
