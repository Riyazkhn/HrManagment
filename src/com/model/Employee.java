package com.model;

public class Employee {
	int employeeId;
	String employeeName;
	int employeeSalary;
	int employeeAge;
	String employeeAddress;
	int departmentId;
	int roleId;
	String mobileNumber;
	String email;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int employeeId, String employeeName, int employeeSalary, int employeeAge, String employeeAddress,
			int departmentId, int roleId, String mobileNumber, String email) {

		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeSalary = employeeSalary;
		this.employeeAge = employeeAge;
		this.employeeAddress = employeeAddress;
		this.departmentId = departmentId;
		this.roleId = roleId;
		this.mobileNumber = mobileNumber;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeSalary="
				+ employeeSalary + ", employeeAge=" + employeeAge + ", employeeAddress=" + employeeAddress
				+ ", departmentId=" + departmentId + ", roleId=" + roleId + ", mobileNumber=" + mobileNumber
				+ ", email=" + email + "";
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(int employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public int getEmployeeAge() {
		return employeeAge;
	}

	public void setEmployeeAge(int employeeAge) {
		this.employeeAge = employeeAge;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
