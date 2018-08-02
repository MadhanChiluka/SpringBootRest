package com.springboothibmysql.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboothibmysql.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
