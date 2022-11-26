package com.sts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sts.model.Employee;
import com.sts.repository.EmployeeReposirtory;



@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
  
	@Autowired
  	private EmployeeReposirtory employeeReposirtory;
	
	@GetMapping("/employees")
	public List<Employee> getEmployee()
	{
		
		return employeeReposirtory.findAll();
	}
	
	
	
	

}
