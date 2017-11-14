package com.sharma.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sharma.dao.UserDao;
import com.sharma.model.Role;
import com.sharma.model.UserRole;


@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
	
		com.sharma.model.User user = userDao.findByUserName(username);
//		List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());
		List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());

		System.out.println(authorities.get(0));
		return buildUserForAuthentication(user, authorities);
		
	}

	// Converts com.mkyong.users.model.User user to
	// org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(com.sharma.model.User user, List<GrantedAuthority> authorities) {
		//System.out.println("KULLLLLLLLLLLLLIIIIII:"+user.getPassword());
		return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
	}

//	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
		private List<GrantedAuthority> buildUserAuthority(Set<Role> userRoles) {
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
//		for (UserRole userRole : userRoles) {
			for (Role userRole : userRoles) {
//			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
			setAuths.add(new SimpleGrantedAuthority(userRole.getRoleName()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}

}