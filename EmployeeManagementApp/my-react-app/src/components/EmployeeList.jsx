import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './EmployeeList.css';

const EmployeeList = () => {
    const [employees, setEmployees] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchEmployees = async () => {
            try {
                const result = await axios.get('http://localhost:8080/api/Employee'); // Update the endpoint
                setEmployees(result.data.data); // Adjust based on your API response structure
                setLoading(false);
            } catch (err) {
                setError(err.response ? err.response.data : "Error fetching employees");
                setLoading(false);
            }
        };

        fetchEmployees();
    }, []);

    const handleDelete = async (id) => {
        try {
            await axios.delete(`http://localhost:8080/api/Employee/${id}`); // Call delete API
            setEmployees(employees.filter(emp => emp.id !== id)); // Update state
        } catch (err) {
            setError(err.response ? err.response.data : "Error deleting employee");
        }
    };

    if (loading) {
        return <div className="text-center">Loading...</div>;
    }

    if (error) {
        return <div className="alert alert-danger">{error}</div>;
    }

    return (
        <div className="d-flex justify-content-center w-full align-items-center vh-100">
            <div className="card" style={{ width: '', maxWidth: '800px' }}>
                <div className="card-body">
                    <h5 className="card-title text-center">Registered Employees</h5>
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
                                <th>Actions</th> {/* Added actions column */}
                            </tr>
                        </thead>
                        <tbody>
                            {employees.length > 0 ? (
                                employees.map((emp) => (
                                    <tr key={emp.id}>
                                        <td>{emp.id}</td>
                                        <td>{emp.name}</td>
                                        <td>{new Date(emp.dob).toLocaleDateString()}</td> {/* Format DOB */}
                                        <td>{emp.gender}</td>
                                        <td>{emp.address}</td>
                                        <td>{emp.city}</td>
                                        <td>{emp.state}</td>
                                        <td>
                                            <button 
                                                className="btn btn-danger"
                                                onClick={() => handleDelete(emp.id)}> {/* Delete button */}
                                                Delete
                                            </button>
                                        </td>
                                    </tr>
                                ))
                            ) : (
                                <tr>
                                    <td colSpan="8" className="text-center">No employees found</td> {/* Adjusted colspan */}
                                </tr>
                            )}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    );
};

export default EmployeeList;
