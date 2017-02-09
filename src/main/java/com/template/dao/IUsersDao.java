package com.template.dao;

import java.util.List;

import com.template.models.User;

/**
 * Data access object interface for the User entity.
 * 
 * @author Connor Hanson
 * @version 1.0
 * @since Feb 8, 2017
 */
public interface IUsersDao {

	/**
	 * Returns a list of all users from the Users table.
	 * 
	 * @return A list of Users.
	 */
	List<User> getAllUsers();
	
	/**
	 * Updates user values for the given user id key.
	 * 
	 * @param id The id of the user to update.
	 * @param firstName The new value for the user's first name.
	 * @param lastName The new value for the user's last name.
	 */
	void updateUser(int id, String firstName, String lastName);
}
