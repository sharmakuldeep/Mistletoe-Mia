package com.sharma.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="Role")
public class Role {
	
	@Id
	@GeneratedValue
	private int roleId;
	private String roleName;
	@ManyToMany(mappedBy="userRole")

	private Set<User> user = new HashSet<User>();
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Collection<User> getUser() {
		return user;
	}
	public void setUser(Set<User> user) {
		this.user = user;
	}
	
	

}
