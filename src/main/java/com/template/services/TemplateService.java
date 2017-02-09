package com.template.services;

import java.util.ArrayList;
import java.util.List;

import com.template.dao.IUsersDao;
import com.template.dto.UserDto;
import com.template.models.User;

/**
 * "Template" service implementation.
 * 
 * @author Connor Hanson
 * @version 1.0
 * @since Feb 8, 2017
 */
public class TemplateService implements ITemplateService {

	/**
	 * Data access object for the Users table.
	 */
	private IUsersDao usersDao;
	
	/**
	 * Constructs a new TemplateService with the specified data 
	 * access objects
	 * 
	 * @param usersDao The data access object for the Users table.
	 */
	public TemplateService(IUsersDao usersDao) {
		this.usersDao = usersDao;
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<UserDto> users = new ArrayList<>();
		
		for (User user : usersDao.getAllUsers()) {
			users.add(new UserDto(
				user.getId(), 
				user.getFirstName(), 
				user.getLastName()
			));
		}
		
		return users;
	}

	@Override
	public void updateUser(UserDto user) {
		usersDao.updateUser(user.getId(), user.getFirstName(), 
					user.getLastName());
	}
}
