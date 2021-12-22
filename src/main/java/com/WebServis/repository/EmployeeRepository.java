package com.WebServis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.WebServis.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
