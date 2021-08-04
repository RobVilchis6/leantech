package com.leantech.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.leantech.dao.EmployeeDao;
import com.leantech.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
    private EntityManager entityManager;
	
	@Override
	public List<Employee> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);

        Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);

        List<Employee> users = theQuery.getResultList();

        return users;
	}

	@Override
    public Employee findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Employee user = currentSession.get(Employee.class, id);

        return user;
    }

	@Override
	public void save(Employee user) {
		Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(user); 
	}

	@Override
	 @Transactional
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        
        Query<Employee> theQuery = currentSession.createQuery("delete from Employee where id=:idUser");

        theQuery.setParameter("idUser", id);
        theQuery.executeUpdate();
    }
}
