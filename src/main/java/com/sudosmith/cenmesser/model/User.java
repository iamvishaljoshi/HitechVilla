package com.sudosmith.cenmesser.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * 
 * @author Vishal Joshi
 *
 */

@Entity
@Table(name = "User")
@NamedQuery(name = "findUserByName", query = "SELECT user FROM User user WHERE user.userName LIKE :queryString")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7257051297399186919L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "username")
	private String userName;

	@Column(name = "password")
	private String password;

	@ManyToMany
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "userid"), inverseJoinColumns = @JoinColumn(name = "roleid"))
	private List<Role> roles;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private UserStatus status;

	public User() {

	}

	public User(int id, String userName, String password, List<Role> roles,
			UserStatus status) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.roles = roles;
		this.status = status;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the roles
	 */
	public List<Role> getRoles() {
		if (roles != null) {
			return roles;
		} else {
			return new ArrayList<Role>();
		}
	}

	/**
	 * @param roles
	 *            the roles to set
	 */
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	/**
	 * @return the status
	 */
	public UserStatus getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(UserStatus status) {
		this.status = status;
	}

}
