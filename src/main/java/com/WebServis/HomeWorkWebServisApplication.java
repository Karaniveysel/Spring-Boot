package com.WebServis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import org.apache.log4j.Logger;
import java.sql.*;
import java.io.*;
import java.util.*;

import org.junit.Test;
import org.apache.log4j.*;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import com.WebServis.controller.EmployeeController;
import com.WebServis.exception.ResourceNotFoundException;
import com.WebServis.model.Employee;


import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class HomeWorkWebServisApplication {


	// private static final Logger logger =
	// LogManager.getLogger(HomeWorkWebServisApplication.class);
      static Logger log = Logger.getLogger(HomeWorkWebServisApplication.class.getName());
	 

	public static void main(String[] args) {
		SpringApplication.run(HomeWorkWebServisApplication.class, args);

//	    	log.debug("fatih");
//	      log.info("Info");
//	      System.out.print("bbbb");
//	
//	
//	Connection conn = null;
//	try{  
//		Class.forName("com.mysql.cj.jdbc.Driver");  
//		Connection con=DriverManager.getConnection(  
//		"jdbc:mysql://localhost:3306/deneme","root","root");  
//		//here sonoo is database name, root is username and password  
//		Statement stmt=con.createStatement();  
//		ResultSet rs=stmt.executeQuery("select USER_ID,LOG_DATE,MESSAGE from test");  
//		while(rs.next())  
//			System.err.println("deneme");
//        System.out.println(rs.getString(1)+"  "+rs.getDate(2)+"  "+rs.getString(3));  
//		con.close();  
//		}catch(Exception e){ System.out.println(e);}  
//	
//	 
		}  
}
	
	


//	
//	 EmployeeController testIntence = new  EmployeeController();
//		
//	 @Test
//	 public void test1() {
//		Employee employee = null;
//		 Employee actual = testIntence.createEmployee(employee);
//		 assertEquals(employee,actual);
//		 
//	 }
//	 
//	
//
//	@Test
//	 public void test2() {
//		 Employee employeeId = null;
//		  Employee actual= (Employee) testIntence.getAllEmployees();
//		assertEquals(actual,employeeId);
//	 }
//	
//	
