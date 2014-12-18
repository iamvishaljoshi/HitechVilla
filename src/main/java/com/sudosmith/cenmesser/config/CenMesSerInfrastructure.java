package com.sudosmith.cenmesser.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@Import(value = {SpringHibernateConfiguration.class,
		CenMesSerSecurity.class})
@ComponentScan (value = {"com.sudosmith.cenmesser.dao.impl",
		"com.sudosmith.cenmesser.service.impl"})
public class CenMesSerInfrastructure {
	
	/**
	 * This is replacement of @link{PropertyPlaceHolderConfigurer} that
	 * is used because of some placeholder that we need to configure 
	 * in our configuration file this @see{PropertySourcesPlaceholderConfigurer}
	 * works with @see{@PropertySource} annotation and also we will make use
	 * of @see{Environment} to resolve placeholders from a property file.
	 * @return PropertySourcesPlaceholderConfigurer
	 */
	@Bean
	public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer () {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
