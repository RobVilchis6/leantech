package com.leantech.service;

import java.util.List;

import com.leantech.entity.Employee;

public interface EmployeeService {
	public List<Employee> listEmployees();
	
	public void save(Employee newEmployee);
	
    public Employee findById(int id);
    
    public void deleteById(int id) ;

}