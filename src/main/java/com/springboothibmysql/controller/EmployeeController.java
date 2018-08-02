package com.springboothibmysql.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.springboothibmysql.dao.EmployeeDao;
import com.springboothibmysql.model.Employee;

@RestController
@RequestMapping("/company")
public class EmployeeController {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee emp) {
		return employeeDao.save(emp);
	}
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return employeeDao.getEmployees();
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployee(@Valid @PathVariable(value="id") Long empId) {
		Employee emp =  employeeDao.getEmployee(empId);
		
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
		
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@Valid @PathVariable(value="id") Long empId, @RequestBody Employee empDetails){
		Employee emp = employeeDao.getEmployee(empId);
		if(empId==null) {
		return ResponseEntity.notFound().build();
		}
		emp.setName(empDetails.getName());
		emp.setDesignation(empDetails.getDesignation());
		emp.setExpertise(empDetails.getExpertise());
		
		Employee updateEmployee = employeeDao.save(emp);
		return ResponseEntity.ok().body(updateEmployee);
		
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmployee(@Valid @PathVariable(value="id")Long empId){
		Employee emp = employeeDao.getEmployee(empId);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		employeeDao.deleteEmployee(emp);
		return ResponseEntity.ok().build();
	}
}
