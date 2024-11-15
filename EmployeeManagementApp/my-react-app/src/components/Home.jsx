// src/components/Home.jsx
import React from 'react';
import { Link } from 'react-router-dom';
import './Home.css'; // Import the CSS file for styling

const Home = () => {
    return (
        <div className="home">
            <nav className="navbar">
                <ul>
                    <li><Link to="/login">Login</Link></li>
                    <li><Link to="/register">Register</Link></li>
                    <li><Link to="/employees">Employee List</Link></li>
                </ul>
            </nav>
            <div className="welcome-message">
                <h1>Welcome to the Employee Management System</h1>
                <p>Please select an option from the menu above.</p>
            </div>
        </div>
    );
};

export default Home;
