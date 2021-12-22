package com.WebServis.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.WebServis.exception.ResourceNotFoundException;
import com.WebServis.model.Employee;
import com.WebServis.repository.EmployeeRepository;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.http.ResponseEntity;
@ExtendWith(MockitoExtension.class)

class EmployeeControllerTest {
	
	@Mock
	private EmployeeRepository employeeRepo;
	
	@InjectMocks
	private EmployeeController empployeeCont;
	
	@Test
	void testGetAllEmployees() {
		
		Employee emp = new Employee();
		emp.setFirstName("fatih");
		emp.setLastName("oguzhan");
		emp.setEmailId("bla@gmail.com");
		emp.setId(1);
		
		Mockito.when(employeeRepo.findAll()).thenReturn(Collections.singletonList(emp));
		List<Employee> result = empployeeCont.getAllEmployees();
		
		assertEquals(result.size(),1 );
	}



	@Test
	void testCreateEmployee() {
		Employee emp1 = new Employee();
		emp1.setFirstName("fatih");
		emp1.setLastName("oguzhan");
		emp1.setEmailId("bla@gmail.com");
		
		Employee employeeMock =Mockito.mock(Employee.class);
		Mockito.when(employeeRepo.save(ArgumentMatchers.any(Employee.class))).thenReturn(employeeMock);
		Employee employee = employeeRepo.save(emp1);
		assertEquals(employee.getId(),emp1.getId());
	
	}

	@Test
	void testGetEmployeeById() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateEmployee() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteEmployee() throws ResourceNotFoundException {
		Employee emp2 = new Employee();
		emp2.setFirstName("fatih");
		emp2.setLastName("oguzhan");
		emp2.setEmailId("bla@gmail.com");
		
		
		empployeeCont.deleteEmployee(emp2.getId());
		assertEquals(emp2, empployeeCont);
		
		Mockito.when(employeeRepo.findAll()).thenReturn((List<Employee>) emp2);
		ResponseEntity<Long>result = empployeeCont.deleteEmployee(emp2.getId());
		assertEquals(result, emp2);
	}

}
