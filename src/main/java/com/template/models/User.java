package com.template.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Users Entity.
 * 
 * @author Connor Hanson
 * @version 1.0
 * @since 2/8/2017
 */
@Entity
@Table(name="Users")
public class User {

	/**
	 * The user's id (primary key).
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/**
	 * The user's first name.
	 */
	private String firstName;
	
	/**
	 * The user's last name.
	 */
	private String lastName;

	/**
	 * Returns the id (primary key) for the user.
	 * 
	 * @return The id of the user.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id (primary key) for the user.
	 * 
	 * @param id The id value to use.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns the user's first name.
	 * 
	 * @return The user's first name.
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Sets the user's first name.
	 * 
	 * @param firstName The first name to use.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Returns the user's last name.
	 * 
	 * @return The user's last name.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the user's last name.
	 * 
	 * @param lastName The last name to use.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
