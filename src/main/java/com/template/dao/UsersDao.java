package com.template.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.template.models.User;

/**
 * Data access object implementation for the User entity.
 * 
 * @author Connor Hanson
 * @version 1.0
 * @since Feb 8, 2017
 */
public class UsersDao extends TemplateDao<User> implements IUsersDao {

	/**
	 * creates a new UsersDao with the specified database session 
	 * factory.
	 * 
	 * @param sessionFactory The database session factory to use.
	 */
	public UsersDao(SessionFactory sessionFactory) {
		super(sessionFactory, User.class);
	}

	@Override
	@Transactional
	public List<User> getAllUsers() {
		@SuppressWarnings("unchecked")
		List<User> users = sessionFactory.getCurrentSession()
					.createCriteria(entityClass)
					.list();
		
		return users;
	}
	
	@Override
	@Transactional
	public void updateUser(int id, String firstName, String lastName) {
		// get the current user data for the specified id.
		Session session = sessionFactory.getCurrentSession();
		User user = session.get(entityClass, id);
		
		// Specify updates to the user's data.
		user.setFirstName(firstName);
		user.setLastName(lastName);
		
		// save the updated data.
		session.update(user);
	}
}
