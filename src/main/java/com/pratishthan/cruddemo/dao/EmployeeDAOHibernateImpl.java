package com.pratishthan.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pratishthan.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	
	//set up constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager)
	{
		entityManager=theEntityManager;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		// get  a current hibernate session
		Session curSession=entityManager.unwrap(Session.class);
		
		//create a query
		Query<Employee> query=curSession.createQuery("from Employee",Employee.class);
		
		//execute query and get result list
		List<Employee> employees=query.getResultList();
		
		//return the results
		return employees;
	}

	@Override
	public Employee findById(int id) {
		// get current hibernate session
		Session curSession=entityManager.unwrap(Session.class);
		
		//get the enmployee
		Employee employee=curSession.get(Employee.class, id);
		
		//return the employee
		return employee;
	}

	@Override
	public void save(Employee employee) {
		// get current hibernate session
		Session curSession=entityManager.unwrap(Session.class);
		
		//get the enmployee
		curSession.saveOrUpdate(employee);
		
	}

	@Override
	public void deleteById(int id) {
		// get current hibernate session
		Session curSession=entityManager.unwrap(Session.class);
		
		//get the enmployee
		Query query=curSession.createQuery("delete from Employee where id=:employeeId");
		
		query.setParameter("employeeId", id);
		
		query.executeUpdate();
	}

}
