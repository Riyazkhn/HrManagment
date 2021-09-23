package com.dao;

import java.util.List;
import com.model.Employee;

public interface EmployeeDao {

	List<Employee> getAllEmployee();

	int insertEmployee(Employee employee);

	public boolean updateEmployee(Employee employee);

	int deleteEmployee(int id);

	Employee searchEmployeebyId(int id);

	public void departmentWiseEmployeeCount();

	List<Employee> departmentHaveEmployee(int id);

}
