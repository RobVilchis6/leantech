package com.leantech.service;

import java.util.List;

import com.leantech.entity.Employee;
import com.leantech.entity.Position;

public interface PositionService {
	public List<Position> listEmployees(String position, String name);
	

}