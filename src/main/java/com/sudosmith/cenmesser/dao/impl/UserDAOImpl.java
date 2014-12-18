/**
 * 
 */
package com.sudosmith.cenmesser.dao.impl;

import org.springframework.stereotype.Repository;

import com.sudosmith.cenmesser.dao.UserDAO;
import com.sudosmith.cenmesser.model.User;

/**
 * @author Vishal joshi
 *
 */
@Repository("userDao")
public class UserDAOImpl extends GenericDAOImpl<User, Long> implements UserDAO {
	
	public UserDAOImpl(){
		super(User.class);
	}
	
}
