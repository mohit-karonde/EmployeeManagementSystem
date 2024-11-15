package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;



@RestController
public class LoginController {

	
	@Autowired
	EmployeeService service;
	
	
	
	
	
	
}
