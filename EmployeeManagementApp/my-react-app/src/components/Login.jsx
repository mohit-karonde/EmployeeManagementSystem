import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const Login = () => {
    const [loginId, setLoginId] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();

    const handleLogin = async (e) => {
        e.preventDefault();
        
        const response = await fetch(`http://localhost:8080/api/Login/${loginId}/${password}`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
        });

        const data = await response.json();

        if (response.ok) {
            // Navigate to Welcome page with employee ID only
            navigate('/welcome', { state: { id: data.data } }); // Assuming data.data is the employee ID
        } else {
            alert(data.message); // Display error message
        }
    };

    return (
        <div className="card">
            <div className="card-body">
                <h5 className="card-title">Login</h5>
                <form onSubmit={handleLogin}>
                    <div className="form-group">
                        <label>Login ID</label>
                        <input 
                            type="text" 
                            className="form-control" 
                            value={loginId} 
                            onChange={(e) => setLoginId(e.target.value)} 
                        />
                    </div>
                    <div className="form-group">
                        <label>Password</label>
                        <input 
                            type="password" 
                            className="form-control" 
                            value={password} 
                            onChange={(e) => setPassword(e.target.value)} 
                        />
                    </div>
                    <button type="submit" className="btn btn-primary">Login</button>
                </form>
            </div>
        </div>
    );
};

export default Login;
