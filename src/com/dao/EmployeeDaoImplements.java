package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.configuration.ConnectionFactory;
import com.model.Employee;
import com.sun.source.tree.CatchTree;

public class EmployeeDaoImplements implements EmployeeDao {
	// ConnectionFactory connectionfactory;

	public EmployeeDaoImplements() {
		// connectionfactory = new ConnectionFactory();
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> employeeList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		final String Query = "select * from employee";
		try {

			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(Query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setEmployeeId(resultSet.getInt("EmployeeId"));
				employee.setEmployeeName(resultSet.getString("EmployeeName"));
				employee.setEmployeeSalary(resultSet.getInt("EmployeeSalary"));
				employee.setEmployeeAge(resultSet.getInt("EmployeeAge"));
				employee.setEmployeeAddress(resultSet.getString("EmployeeAddress"));
				employee.setDepartmentId(resultSet.getInt("DepartmentId"));
				employee.setRoleId(resultSet.getInt("RoleId"));
				employee.setMobileNumber(resultSet.getString("MobileNumber"));
				employee.setEmail(resultSet.getString("Email"));
				employeeList.add(employee);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return employeeList;
	}

	public int deleteEmployee(int id) {
		int statusdelete = 0;
		Connection connection = null;
		PreparedStatement preparedStatment = null;
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatment = connection.prepareStatement("Delete from employee where EmployeeId=?");
			preparedStatment.setInt(1, id);
			statusdelete = preparedStatment.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return statusdelete;

	}

	@Override
	public int insertEmployee(Employee employee) {
		System.out.println(employee);
		int status = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement("insert into employee values(?,?,?,?,?,?,?,?,?)");
			preparedStatement.setInt(1, employee.getEmployeeId());
			preparedStatement.setString(2, employee.getEmployeeName());
			preparedStatement.setInt(3, employee.getEmployeeSalary());
			preparedStatement.setInt(4, employee.getEmployeeAge());
			preparedStatement.setString(5, employee.getEmployeeAddress());
			preparedStatement.setInt(6, employee.getDepartmentId());
			preparedStatement.setInt(7, employee.getRoleId());
			preparedStatement.setString(8, employee.getMobileNumber());
			preparedStatement.setString(9, employee.getEmail());
			status = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return status;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		Connection connection = null;
		PreparedStatement preparedStatment = null;
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatment = connection.prepareStatement(
					"Update employee set EmployeeName=?,EmployeeSalary=?,EmployeeAge=?,EmployeeAddress=?,DepartmentId=?,RoleId=?,MobileNumber=?,Email=? Where EmployeeId=?");
			preparedStatment.setString(1, employee.getEmployeeName());
			preparedStatment.setInt(2, employee.getEmployeeSalary());
			preparedStatment.setInt(3, employee.getEmployeeAge());
			preparedStatment.setString(4, employee.getEmployeeAddress());
			preparedStatment.setInt(5, employee.getDepartmentId());
			preparedStatment.setInt(6, employee.getRoleId());
			preparedStatment.setString(7, employee.getMobileNumber());
			preparedStatment.setString(8, employee.getEmail());
			preparedStatment.setInt(9, employee.getEmployeeId());
			int i = preparedStatment.executeUpdate();
			if (i == 1)
				return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatment != null)
					preparedStatment.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return false;
	}

	@Override
	public Employee searchEmployeebyId(int id) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		Employee employee = null;
		try {

			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement("Select * from employee where EmployeeId=?");
			preparedStatement.setInt(1, id);
			resultset = preparedStatement.executeQuery();

			while (resultset.next()) {
				employee = new Employee();
				employee.setEmployeeId(resultset.getInt("EmployeeId"));
				employee.setEmployeeName(resultset.getString("EmployeeName"));
				employee.setEmployeeSalary(resultset.getInt("EmployeeSalary"));
				employee.setEmployeeAge(resultset.getInt("EmployeeAge"));
				employee.setEmployeeAddress(resultset.getString("EmployeeAddress"));
				employee.setDepartmentId(resultset.getInt("DepartmentId"));
				employee.setRoleId(resultset.getInt("RoleId"));
				employee.setMobileNumber(resultset.getString("MobileNumber"));
				employee.setEmail(resultset.getString("Email"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultset != null)
					resultset.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (preparedStatement != null)
					preparedStatement.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null)
					connection.close();

			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
		return employee;
	}

	@Override
	public void departmentWiseEmployeeCount() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "select d.departmentname , count(e.employeeid) from department d  join employee e on d.departmentid = e.departmentId group by d.departmentname";
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(
						"DepartmentName:" + resultSet.getString(1) + " Count of Employee: " + resultSet.getInt(2));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Employee> departmentHaveEmployee(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		ArrayList<Employee> list = new ArrayList<>();
		Employee employee = null;
		try {

			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement("Select * from employee where DepartmentId=?");
			preparedStatement.setInt(1, id);
			resultset = preparedStatement.executeQuery();
			while (resultset.next()) {
				employee = new Employee();
				employee.setEmployeeId(resultset.getInt("EmployeeId"));
				employee.setEmployeeName(resultset.getString("EmployeeName"));
				employee.setEmployeeSalary(resultset.getInt("EmployeeSalary"));
				employee.setEmployeeAge(resultset.getInt("EmployeeAge"));
				employee.setEmployeeAddress(resultset.getString("EmployeeAddress"));
				employee.setDepartmentId(resultset.getInt("DepartmentId"));
				employee.setRoleId(resultset.getInt("RoleId"));
				employee.setMobileNumber(resultset.getString("MobileNumber"));
				employee.setEmail(resultset.getString("Email"));
				list.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultset != null)
					resultset.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (preparedStatement != null)
					preparedStatement.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null)
					connection.close();

			} catch (SQLException e) {
				// TODO: handle exception
			}

		}
		return list;
	}

}
