package com.leantech.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leantech.dao.EmployeeDao;
import com.leantech.dao.PositionDao;
import com.leantech.service.EmployeeService;
import com.leantech.service.PositionService;
import com.leantech.entity.Employee;
import com.leantech.entity.Position;


@Service
public class PositionServiceImpl implements PositionService {
	
	@Autowired
	private PositionDao positionDao;
	
	@Override
	public List<Position> listEmployees(String position, String name) {
		return (List<Position>) positionDao.findAll(position, name);
	}

}