package com.pratishthan.cruddemo.dao;

import java.util.List;

import com.pratishthan.cruddemo.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee employee);
	
	public void deleteById(int id);
	
//	public void showNameById(int id);

}
