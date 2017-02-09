package com.template.dto;

/**
 * Data transfer object for users.
 * 
 * @author Connor Hanson
 * @version 1.0
 * @since Feb 8, 2017
 */
public class UserDto {

	/**
	 * The id of the user.
	 */
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
	 * Constructs and empty UserDto. Required for proper 
	 * entity mapping.
	 */
	public UserDto() {}
	
	/**
	 * Constructs a UserDto with the given parameters.
	 * 
	 * @param id The id of the user.
	 * @param firstName The user's first name.
	 * @param lastName The user's last name.
	 */
	public UserDto(int id, String firstName, String lastName) {
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
	}

	/**
	 * Returns the id of the user.
	 * 
	 * @return The id of the user.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id of the user.
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
