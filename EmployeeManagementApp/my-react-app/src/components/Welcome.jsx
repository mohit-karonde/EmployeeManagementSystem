import React, { useEffect, useState } from 'react';
import { useLocation } from 'react-router-dom';

const Welcome = () => {
    const location = useLocation();
    const { id } = location.state || { id: null }; // Get the logged-in employee ID from state
    const [employee, setEmployee] = useState(null);
    const [employees, setEmployees] = useState([]);
    const [error, setError] = useState('');

    useEffect(() => {
        // Fetch logged-in employee details
        const fetchEmployeeDetails = async () => {
            try {
                const response = await fetch(`http://localhost:8080/api/Employee/${id}`);
                const data = await response.json();

                if (response.ok) {
                    setEmployee(data.data); // Set the logged-in employee's details
                } else {
                    setError(data.message); // Set error message if fetch fails
                }
            } catch (err) {
                setError("Failed to fetch employee details.");
            }
        };

        // Fetch all employees except the logged-in one
        const fetchEmployees = async () => {
            try {
                const response = await fetch(`http://localhost:8080/api/AllEmployee/${id}`);
                const data = await response.json();

                if (response.ok) {
                    setEmployees(data.data); // Set other employees' details
                } else {
                    setError(data.message); // Set error message if fetch fails
                }
            } catch (err) {
                setError("Failed to fetch other employees.");
            }
        };

        if (id) {
            fetchEmployeeDetails();
            fetchEmployees();
        }
    }, [id]);

    if (error) {
        return <div>Error: {error}</div>; // Show error if exists
    }

    if (!employee) {
        return <div>Loading...</div>; // Show loading state until data is fetched
    }

    return (
        <div>
            <h5 className="card-title">Welcome, {employee.name} (ID: {employee.id})!</h5>
            <p className="card-text">Here are the details of other employees:</p>
            <div className="card">
                <div className="card-body">
                    <table className="table">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>DOB</th>
                                <th>Gender</th>
                                <th>Address</th>
                                <th>City</th>
                                <th>State</th>
                            </tr>
                        </thead>
                        <tbody>
                            {employees.map(emp => (
                                <tr key={emp.id}>
                                    <td>{emp.id}</td>
                                    <td>{emp.name}</td>
                                    <td>{new Date(emp.dob).toLocaleDateString()}</td>
                                    <td>{emp.gender}</td>
                                    <td>{emp.address}</td>
                                    <td>{emp.city}</td>
                                    <td>{emp.state}</td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    );
};

export default Welcome;
