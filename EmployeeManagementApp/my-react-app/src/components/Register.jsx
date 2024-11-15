// src/components/Register.jsx
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import './Register.css'; // Make sure you create this CSS file

const Register = () => {
    const navigate = useNavigate();
    const [formData, setFormData] = useState({
        name: '',
        dob: '',
        gender: '',
        address: '',
        city: '',
        state: '',
        loginId: '',
        password: '',
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/api/Employee', formData);
            alert(response.data.message);
            // Reset form after submission
            setFormData({
                name: '',
                dob: '',
                gender: '',
                address: '',
                city: '',
                state: '',
                loginId: '',
                password: '',
            });
        } catch (error) {
            alert('Error during registration');
        }
    };

    const handleSignInClick = () => {
        navigate('/login'); // Redirects to the login page
    };

    return (
        <div className="container d-flex justify-content-center align-items-center h-screen">
            <div className="card shadow p-4" style={{ width: '400px' }}>
                <h2 className="text-center mb-4">Register</h2>
                <form onSubmit={handleSubmit}>
                    <div className="mb-3">
                        <label htmlFor="name" className="form-label">Name</label>
                        <input type="text" className="form-control" name="name" value={formData.name} onChange={handleChange} required />
                    </div>
                    <div className="mb-3">
                        <label htmlFor="dob" className="form-label">Date of Birth</label>
                        <input type="date" className="form-control" name="dob" value={formData.dob} onChange={handleChange} required />
                    </div>
                    <div className="mb-3">
                        <label htmlFor="gender" className="form-label">Gender</label>
                        <select className="form-select" name="gender" value={formData.gender} onChange={handleChange} required>
                            <option value="">Select</option>
                            <option value="Male">Male</option>
                            <option value="Female">Female</option>
                            <option value="Other">Other</option>
                        </select>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="address" className="form-label">Address</label>
                        <input type="text" className="form-control" name="address" value={formData.address} onChange={handleChange} required />
                    </div>
                    <div className="mb-3">
                        <label htmlFor="city" className="form-label">City</label>
                        <input type="text" className="form-control" name="city" value={formData.city} onChange={handleChange} required />
                    </div>
                    <div className="mb-3">
                        <label htmlFor="state" className="form-label">State</label>
                        <input type="text" className="form-control" name="state" value={formData.state} onChange={handleChange} required />
                    </div>
                    <div className="mb-3">
                        <label htmlFor="loginId" className="form-label">Login ID</label>
                        <input type="text" className="form-control" name="loginId" value={formData.loginId} onChange={handleChange} required />
                    </div>
                    <div className="mb-3">
                        <label htmlFor="password" className="form-label">Password</label>
                        <input type="password" className="form-control" name="password" value={formData.password} onChange={handleChange} required />
                    </div>
                    <button type="submit" className="btn btn-primary w-100">Register</button>
                </form>
                <div className="text-center mt-3">
                    <p>Already have an account? <button onClick={handleSignInClick} className="btn btn-link p-0">Sign In</button></p>
                </div>
            </div>
        </div>
    );
};

export default Register;
