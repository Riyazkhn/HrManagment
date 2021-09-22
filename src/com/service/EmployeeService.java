package com.service;

import java.util.List;
import com.model.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployee();

	int insertEmployee(Employee employee);

	public boolean updateEmployee(Employee employee);

	int deleteEmployee(int id);

	Employee searchEmployeebyId(int id);

	public void departmentWiseEmployeeCount();
	
	Employee departmentHaveEmployee(int id);

}
