package com.leantech.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.leantech.dao.PositionDao;
import com.leantech.entity.Position;

@Repository
public class PositionDaoImpl implements PositionDao {

	@Autowired
    private EntityManager entityManager;
	
	@Override
	public List<Position> findAll(String position, String name) {
		Session currentSession = entityManager.unwrap(Session.class);

		 TypedQuery<Position> query = currentSession.createQuery(
				  " select p "
		 		+ " from Position p "
		 		+ " join p.employees e  "	 		
		 		+ " join e.person u  "	 		
		 		+ " where (p.position = :position or :position is null)"
		 		+ " and (u.name = :name or :name is null)", Position.class);
        
        List<Position> users = query
        		 .setParameter("position", position)
        		 .setParameter("name", name)
        		  .getResultList();

        return users;
	}	
}
