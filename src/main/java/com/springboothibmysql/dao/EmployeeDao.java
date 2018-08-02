package com.springboothibmysql.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboothibmysql.model.Employee;
import com.springboothibmysql.repo.EmployeeRepository;

@Service
public class EmployeeDao {
	@Autowired
	EmployeeRepository employeeRepo;
	
		/*To save an Employee */
	public Employee save(Employee emp) {
		return employeeRepo.save(emp);
	}
		
	/* To search employees or to get employees */
	public List<Employee> getEmployees(){
		return employeeRepo.findAll();
	}

	/* get an employee by id*/
	public Employee getEmployee(Long empId) {
		return employeeRepo.getOne(empId);
	}
	
	/* delete an employee */
	public void deleteEmployee(Employee emp) {
		employeeRepo.delete(emp);
	}
}
