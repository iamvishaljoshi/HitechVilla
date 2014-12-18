/**
 * 
 */
package com.sudosmith.cenmesser.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.sudosmith.cenmesser.model.User;

/**
 * @author Vishal joshi
 *
 */
@Repository
public interface UserDAO extends GenericDAO<User, Serializable> {

}
