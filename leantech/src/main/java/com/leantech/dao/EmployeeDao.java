package com.leantech.dao;

import com.leantech.entity.Employee;
import com.leantech.entity.Person;
import java.util.List;

public interface EmployeeDao {
	
	public List<Employee> findAll();

    public Employee findById(int id);

    public void save(Employee user);

    public void deleteById(int id);

}

