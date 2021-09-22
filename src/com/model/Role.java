package com.model;

public class Role {
	int roleId;
	int roleName;

	public Role() {
		
	}

	public Role(int roleId, int roleName) {

		this.roleId = roleId;
		this.roleName = roleName;
	}


	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + "]";
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getRoleName() {
		return roleName;
	}

	public void setRoleName(int roleName) {
		this.roleName = roleName;
	}

}
