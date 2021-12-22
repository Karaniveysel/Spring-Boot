package com.WebServis.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.WebServis.exception.ResourceNotFoundException;
import com.WebServis.model.Employee;
import com.WebServis.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1")

// ornek json 

/*
 * { "firstName": "John", "lastName": "Doe", "emailId": "sdsd" }
 */

//http://localhost:8080/api/v1/employees     
public class EmployeeController {

	Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	public EmployeeRepository employeeRepository;

	// create get all employee api

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		logger.info("Get Mapping kismi calisti");
		return employeeRepository.findAll();
	}

	// create employee

	@PostMapping("/employees")
	public Employee createEmployee(@Validated @RequestBody Employee employee) {
		logger.info("post kismi da calisti");
		return employeeRepository.save(employee);
	}

	// get employee by id

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") long employeeId)
			throws ResourceNotFoundException {

		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee bulunamadı bu id için.." + employeeId));
		logger.info("bu 2. getmaping de calisti");
		return ResponseEntity.ok().body(employee);
	}

	// update employee

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") long employeeId,
			@Validated @RequestBody Employee employeeDetails) throws ResourceNotFoundException {

		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee bulunamadı bu id için.." + employeeId));
		employee.setEmailId(employeeDetails.getEmailId());
		employee.setLastName(employeeDetails.getLastName());
		employee.setFirstName(employeeDetails.getFirstName());
		logger.info("Put kismi da caisti");
		return ResponseEntity.ok().body(employee);
	}

	// delete employee by id

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Long> deleteEmployee(@PathVariable(value = "id") long employeeId)
			throws ResourceNotFoundException {
		employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee bulunamadı bu id için.. calismadi " + employeeId));

		employeeRepository.deleteById(employeeId);
		logger.info("Delete kismi da caisti");
		return ResponseEntity.ok().build();
	}

	
}
