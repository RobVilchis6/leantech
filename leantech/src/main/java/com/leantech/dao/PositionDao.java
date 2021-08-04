package com.leantech.dao;

import com.leantech.entity.Position;

import java.util.List;

public interface PositionDao {
	
	public List<Position> findAll(String position, String name);
}

