package com.leantech.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Position {
	@Id
    @Column(name = "position_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String position;
    
    @OneToMany(mappedBy = "position")
	private List<Employee> employees  = new ArrayList<>();
	
	public Position() {}
	
	public Position(int id, String position, List<Employee> employees) {
		super();
		this.id = id;
		this.position = position;
		this.employees = employees;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}
	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	/**
	 * @return the employees
	 */
	public List<Employee> getEmployees() {
		return employees;
	}
	/**
	 * @param employees the employees to set
	 */
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
