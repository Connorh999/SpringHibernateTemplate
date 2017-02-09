package com.template.dao;

import org.hibernate.SessionFactory;

/**
 * Data access object implementation for "template" entities.
 * ex: {@literal TemplateDao<UsersDao>}.
 * 
 * @author Connor Hanson
 * @version 1.0
 * @since Feb 8, 2017
 *
 * @param <T> The DAO type.
 */
public class TemplateDao<T> implements ITemplateDao<T> {
	
	/**
	 * Database session factory.
	 */
	protected final SessionFactory sessionFactory;
	
	/**
	 * Data access object entity class.
	 */
	protected final Class<T> entityClass;
	
	/**
	 * Creates a new TemplateDao with the given database session factory
	 * and entity class type.
	 * 
	 * @param sessionFactory The database session factory.
	 * @param entityClass The data access object entity class type.
	 */
	public TemplateDao(SessionFactory sessionFactory, Class<T> entityClass) {
		this.sessionFactory = sessionFactory;
		this.entityClass = entityClass;
	}
}
