package com.template.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.template.dao.IUsersDao;
import com.template.dao.UsersDao;
import com.template.models.User;
import com.template.services.ITemplateService;
import com.template.services.TemplateService;

/**
 * Database configuration for connections/transactions.
 * 
 * @author Connor Hanson
 * @version 1.0
 * @since Feb 8, 2017
 */
@Configuration
@EnableTransactionManagement
public class DBConfig {

	private final String DB_USER = "root";
	private final String DB_PASS = "";
	private final String DB_URL = "localhost:3306";
	private final String DB_SCHEMA = "test";
	private final static String HIBERNATE_SHOW_SQL = "true";
	
	/**
     * Returns a Hibernate transaction manager that manages database
     * transactions.
     * 
     * See http://stackoverflow.com/questions/21625282/why-is-hibernatetransactionmanager-required-in-spring
     * 
     * @return A Hibernate transaction manager.
     * @throws IOException If an I/O error occurs.
     */
	@Bean
	public HibernateTransactionManager transactionManager() throws IOException {
		HibernateTransactionManager txMgr = new HibernateTransactionManager();
		txMgr.setSessionFactory(sessionFactory());
		txMgr.afterPropertiesSet();
		
		return txMgr;
	}
	
	/**
     * Returns a session factory that provides database sessions.
     * 
     * @return A session factory.
     * @throws IOException if an I/O error occurs.
     */
	@Bean
	public SessionFactory sessionFactory() throws IOException {
		LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
		bean.setDataSource(dataSource());
		bean.setHibernateProperties(hibernateProperties());
		bean.setPackagesToScan("com.template.models");
		bean.setAnnotatedClasses(
			User.class
		);
		bean.afterPropertiesSet();
		
		return bean.getObject();
	}
	
	/**
	 * Returns a data source used to access the database.
	 * 
	 * @return The database data source.
	 */
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://" + DB_URL + "/" + DB_SCHEMA);
		dataSource.setUsername(DB_USER);
		dataSource.setPassword(DB_PASS);
		
		return dataSource;
	}
	
	/**
	 * Returns Hibernate properties specific to the application database.
	 * 
	 * @return The Hibernate properties.
	 */
	private static Properties hibernateProperties() {
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		props.setProperty("hibernate.show_sql", HIBERNATE_SHOW_SQL);
		
		return props;
	}
	
	/**
	 * Returns a data access object for the Users table.
	 * 
	 * @return Users data access object.
	 * @throws IOException If an I/O error occurs.
	 */
	@Bean
	public IUsersDao usersDao() throws IOException {
		return new UsersDao(sessionFactory());
	}
	
	/**
	 * Returns a "template" service provider used to service "template"
	 * API requests.
	 * 
	 * @return A "template" service provider.
	 * @throws IOException If an I/O error occurs.
	 */
	@Bean
	public ITemplateService templateService() throws IOException {
		return new TemplateService(usersDao());
	}
}
