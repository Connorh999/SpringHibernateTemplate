package com.template.services;

import java.util.List;

import com.template.dto.UserDto;

/**
 * A "Template" service interface.
 * 
 * @author Connor Hanson
 * @version 1.0
 * @since Feb 8, 2017
 */
public interface ITemplateService {
	
	/**
	 * Returns a list of user data transfer objects.
	 * 
	 * @return List of users.
	 */
	List<UserDto> getAllUsers();
	
	/**
	 * Updates the given user with the specified first and 
	 * last names.
	 * 
	 * @param user The user to update.
	 */
	void updateUser(UserDto user);
}
