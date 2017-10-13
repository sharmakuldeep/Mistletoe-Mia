package com.sharma.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity
//@Table(name = "User_Role")
@Embeddable
public class UserRole{

	
//	private Integer userRoleId;
//	private User user;
	private String role;
	public UserRole() {
	}

	public UserRole(User user, String role) {
//		this.user = user;
		this.role = role;
	}

//	@Id
//	@GeneratedValue(strategy = IDENTITY)
//	@Column(name = "user_role_id",
//		unique = true, nullable = false)
//	public Integer getUserRoleId() {
//		return this.userRoleId;
//	}
//
//	public void setUserRoleId(Integer userRoleId) {
//		this.userRoleId = userRoleId;
//	}

//	@ManyToOne(fetch = FetchType.LAZY)
//	
//	public User getUser() {
//		return this.user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

	@Column(name = "role", nullable = false, length = 45)
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}