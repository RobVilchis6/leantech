package com.leantech.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.leantech.service.EmployeeService;
import com.leantech.service.PositionService;
import com.leantech.entity.Employee;
import com.leantech.entity.Person;
import com.leantech.entity.Position;

@RestController
@RequestMapping (value="/leantech")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private PositionService positionService;

    @GetMapping("/listAll")
	public List<Position> listEmployees(@RequestParam(value = "position", required = false) String position, @RequestParam(value = "name", required = false) String name) {
		return positionService.listEmployees(position, name );
	}
    
    @GetMapping("/employeeById/{userId}")
    public Employee getEmployee(@PathVariable int userId){
    	Employee user = employeeService.findById(userId);

        if(user == null) {
            throw new RuntimeException("User id not found -"+userId);
        }
        return user;
    }
	
	@PostMapping("/newEmployee" )
	public Employee newEmployee(@RequestBody Employee newEmployee,  HttpServletResponse response) {
		
		try
		{
			employeeService.save(newEmployee);
			response.setStatus(HttpServletResponse.SC_OK);
			return newEmployee;
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(
			           HttpStatus.BAD_REQUEST, "Error creating new user", e);
		}
	}
	
	@PutMapping("/updateEmployee")
    public Employee updateUser(@RequestBody Employee user) {

		employeeService.save(user);
        return user;
    }
	
	@DeleteMapping("deleteEmployee/{userId}")
    public String deteteEmployee(@PathVariable int userId) {

		Employee user = employeeService.findById(userId);

        if(user == null) {
            throw new RuntimeException("User id not found -"+userId);
        }

        employeeService.deleteById(userId);

        return "Deleted user id - "+userId;
    }
}

