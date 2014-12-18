package com.sudosmith.cenmesser.config;

import java.util.Properties;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
//equalent xml element <tx:annotation-driven>
@EnableTransactionManagement
@PropertySource(value={"classpath:/META-INF/spring/jdbc.properties"})
public class SpringHibernateConfiguration {
	private static String PACKAGES_TO_SCAN = "com.sudosmith.cenmesser.model";
	
	@Inject
	private Environment env;
	
	@Bean(destroyMethod="close")
	public DataSource dataSource () {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getProperty("jdbc.databaseurl"));
		dataSource.setUsername(env.getProperty("jdbc.username"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		return dataSource;
	}
	
	@Autowired
	@Bean
	public LocalSessionFactoryBean sessionFactory (DataSource dataSource) {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setPackagesToScan(PACKAGES_TO_SCAN);
		sessionFactory.setHibernateProperties(getHibernateProperties());
		return sessionFactory;
	}
	
	@Autowired
	@Bean
	public HibernateTransactionManager transactionManager (SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
	}
	
	@Bean
	public HibernateExceptionTranslator hibernateExceptionTranslator() {
		return new HibernateExceptionTranslator();
	}
	
	private Properties getHibernateProperties () {
		Properties properties = new Properties ();
		properties.setProperty("hiberante.hbm2ddl.auto", env.getProperty("hiberante.hbm2ddl.auto"));
		properties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		properties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		return properties;
	}
}
