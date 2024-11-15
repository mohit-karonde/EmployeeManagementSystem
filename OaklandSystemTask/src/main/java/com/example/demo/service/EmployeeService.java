package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.payload.ApiResponse;

@Service
public interface EmployeeService {
	
	public ResponseEntity<ApiResponse<EmployeeEntity>> CreateEmployee(EmployeeEntity employee);
	
	public ResponseEntity<ApiResponse<List<EmployeeEntity>>> getAllEmployee();
	
	public ResponseEntity<ApiResponse<EmployeeEntity>> getByEmpId(Long id);
	
	public ResponseEntity<ApiResponse<EmployeeEntity>> updateById(Long id, EmployeeEntity employee);
	
	public ResponseEntity<ApiResponse<String>> deleteById(Long id);
	
	public ResponseEntity<ApiResponse<String>> login(String loginId, String password);
	
	
	public ResponseEntity<ApiResponse<String>> loginn(EmployeeEntity emp);
	
	
	public ResponseEntity<ApiResponse<List<EmployeeEntity>>> getEmpNotById(Long id);
	
	
	

}
