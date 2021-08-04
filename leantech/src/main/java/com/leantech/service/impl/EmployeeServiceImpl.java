package com.leantech.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leantech.dao.EmployeeDao;
import com.leantech.service.EmployeeService;
import com.leantech.entity.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public List<Employee> listEmployees() {
		return (List<Employee>) employeeDao.findAll();
	}

	@Override
	public void save(Employee newEmployee){ 
		employeeDao.save(newEmployee);
	}
	
	@Override
    public Employee findById(int id) {
		Employee user = employeeDao.findById(id);
        return user;
    }
	
	@Override
    public void deleteById(int id) {
		employeeDao.deleteById(id);
    }
}