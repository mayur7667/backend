package com.sts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sts.model.Employee;
import com.sts.repository.EmployeeReposirtory;


@CrossOrigin(origins = "http://localhost:4200")
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
	
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee)
	{
		return employeeReposirtory.save(employee); 
		
	}
	
	
	
	
	

}
