package com.sharma.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Email;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "User")
public class User {
	@Id
	@Column(name = "username", unique = true, nullable = false, length = 45)
	private String username;
	@Column(name = "password", nullable = false, length = 60)
	private String password;
	@Column(name = "enabled", nullable = false)
	private boolean enabled;
	@Transient
	private String roleName;
	@Email
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "contactNo", nullable = true)
	private String contactNo;
	@Column(name = "address", nullable = true)
	private String address;
	
	@Column(name="fullName",nullable= false)
	private String fullName;

	@ManyToMany
	@JoinTable(name = "UserRole", joinColumns = { @JoinColumn(name = "userId") }, inverseJoinColumns = {
			@JoinColumn(name = "roleId") })
	@JsonManagedReference 
	private Set<Role> userRole = new HashSet<Role>();

	public User() {
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public User(String username, String password, boolean enabled) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

//	public User(String username, String password, boolean enabled, Set<UserRole> userRole) {
//		this.username = username;
//		this.password = password;
//		this.enabled = enabled;
//		this.userRole = userRole;
//	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public void setUserRole(Set<Role> userRole) {
		this.userRole = userRole;
	}

	

	public Set<Role> getUserRole() {
		return userRole;
	}
	
	
	@OneToOne(mappedBy="user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Cart cart;
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	

}