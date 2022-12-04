package com.sts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sts.exception.ResourceNotFoundException;
import com.sts.model.Employee;
import com.sts.repository.EmployeeReposirtory;

import jakarta.websocket.server.PathParam;

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
	
	@GetMapping("/employees/{id}")
   public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id)
   {
		 Employee employee = new Employee();
		 employee= employeeReposirtory.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee Not exist"));
		return ResponseEntity.ok(employee);
   }

    
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id , @RequestBody Employee employeeDetails)
	{
		 Employee employee = new Employee();
		 employee= employeeReposirtory.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee Not exist"));
		 employee.setFirstName(employeeDetails.getFirstName());
		 employee.setLastName(employeeDetails.getLastName());
		 
	Employee UpdatedEmployeee	= employeeReposirtory.save(employee);
		 return ResponseEntity.ok(UpdatedEmployeee);
		
	}
	
	@PutMapping("/timepass")
	public void timepass()
	{
		
		System.out.println("hello");
	}
	
	@PutMapping("/timepass1")
	public void timepass1()
	{
		
		System.out.println("hello");
	}
	
}
