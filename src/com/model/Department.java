package com.model;

public class Department {
	int deparmentId;
	String departmentName;
	String departmentLocation;

	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(int deparmentId, String departmentName, String departmentLocation) {

		this.deparmentId = deparmentId;
		this.departmentName = departmentName;
		this.departmentLocation = departmentLocation;
	}

	@Override
	public String toString() {
		return "Department [deparmentId=" + deparmentId + ", departmentName=" + departmentName + ", departmentLocation="
				+ departmentLocation + "]";
	}

	public int getDeparmentId() {
		return deparmentId;
	}

	public void setDeparmentId(int deparmentId) {
		this.deparmentId = deparmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentLocation() {
		return departmentLocation;
	}

	public void setDepartmentLocation(String departmentLocation) {
		this.departmentLocation = departmentLocation;
	}

}
