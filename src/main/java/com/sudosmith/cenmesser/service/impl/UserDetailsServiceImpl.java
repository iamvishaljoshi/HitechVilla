/**
 * 
 */
package com.sudosmith.cenmesser.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sudosmith.cenmesser.dao.UserDAO;
import com.sudosmith.cenmesser.model.Role;
import com.sudosmith.cenmesser.model.User;
import com.sudosmith.cenmesser.model.UserStatus;

/**
 * @author Vishal Joshi
 *
 */
@SuppressWarnings("deprecation")
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	private Logger logger = Logger.getLogger(UserDetailsServiceImpl.class);

	@Autowired
	private UserDAO userDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String)
	 */
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		logger.debug("loadUserByUsername()");
		logger.info("UserName :: "+username);
		boolean enabled = false;
		boolean accountNonExpired = false;
		boolean credentialsNonExpired = false;
		boolean accountNonLocked = false;
		User loggedInUser = null;
		Map<String, Object> queryParameter = new HashMap<String, Object>();
		queryParameter.put("queryString", username);
		try {
			List<User> users = userDao.findByQueryParams("findUserByName",
					queryParameter);

			for (User loggedUser : users) {
				loggedInUser = loggedUser;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (loggedInUser != null) {

			enabled = loggedInUser.getStatus().equals(UserStatus.ACTIVE);
			accountNonExpired = loggedInUser.getStatus().equals(
					UserStatus.ACTIVE);
			credentialsNonExpired = loggedInUser.getStatus().equals(
					UserStatus.ACTIVE);
			accountNonLocked = loggedInUser.getStatus().equals(
					UserStatus.ACTIVE);
			// adding roles
			Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			for (Role role : loggedInUser.getRoles()) {
				authorities.add(new GrantedAuthorityImpl(role.getRoleName()));
			}

			// now adding spring security to user objects

			org.springframework.security.core.userdetails.User securityUser = new org.springframework.security.core.userdetails.User(
					username, loggedInUser.getPassword(), enabled,
					accountNonExpired, credentialsNonExpired, accountNonLocked,
					authorities);
			
			return securityUser;
		} else {
			throw new UsernameNotFoundException("User Not Found!!");
		}

	}
}
