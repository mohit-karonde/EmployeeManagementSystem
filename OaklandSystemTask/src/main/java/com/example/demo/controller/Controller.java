package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.payload.ApiResponse;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("api")
public class Controller {
	
	@Autowired
	EmployeeService service;
	
	@PostMapping("/Employee")
	public ResponseEntity<ApiResponse<EmployeeEntity>> CreateEmployee(@RequestBody EmployeeEntity employee){
		
		return service.CreateEmployee(employee);
	}
	
	@GetMapping("/Employee")
	public ResponseEntity<ApiResponse<List<EmployeeEntity>>> getAllEmployee() {
		
		return service.getAllEmployee();
	}
	
	@GetMapping("/Employee/{id}")
	public ResponseEntity<ApiResponse<EmployeeEntity>> getByEmpId(@PathVariable Long id) {
	
		return service.getByEmpId(id);
	}
    
	@PutMapping("/Employee/{id}")
	public ResponseEntity<ApiResponse<EmployeeEntity>> updateById(@PathVariable Long id, @RequestBody EmployeeEntity employee){
		
		return service.updateById(id, employee);
		
	}
	
	@DeleteMapping("/Employee/{id}")
	public ResponseEntity<ApiResponse<String>> deleteById(@PathVariable Long id){
		
		return service.deleteById(id);
	}
	
	@PostMapping("/Login/{loginId}/{password}")
	public ResponseEntity<ApiResponse<String>> login(@PathVariable String loginId, @PathVariable String password){
		
		return service.login(loginId, password);
	}
	
	@PostMapping("/Login")
	public ResponseEntity<ApiResponse<String>> loginn(@RequestBody EmployeeEntity emp){
		
		return service.loginn(emp);
		
	}
	
	@GetMapping("/AllEmployee/{id}")
	public ResponseEntity<ApiResponse<List<EmployeeEntity>>> getEmpNotById(@PathVariable Long id){
		
		return service.getEmpNotById(id);
		
	}
	
	
	
}
