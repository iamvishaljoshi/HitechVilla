package com.sudosmith.cenmesser.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

public class CenMesSerWebAppIntializer implements WebApplicationInitializer{

	private static final Class<?>[] INFRASTRUCTURE_CLASSES = {CenMesSerInfrastructure.class};
	private static final Class<?>[] WEB_CONFIG_CLASSES = {CenMesSerWebMvcConfiguration.class};
	private static final String FRONT_CONTROLLER_NAME = "dispatcher";
	private static final String SPRING_SECURITY_FILTER_CHAIN_NAME = "springSecurityFilterChain";
	
	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		registerContextLoaderListener (servletContext);
		registerFronControllerServlet (servletContext);
		registerSpringSecurityFilterChain (servletContext);
	}
	
	private void registerSpringSecurityFilterChain (final ServletContext servletContext) {
		FilterRegistration.Dynamic securityFilter = servletContext.addFilter(
				SPRING_SECURITY_FILTER_CHAIN_NAME, new DelegatingFilterProxy());
		securityFilter.addMappingForUrlPatterns(dispatcherTypes (), Boolean.TRUE, "/*");
	}
	
	private EnumSet<DispatcherType> dispatcherTypes() {

		EnumSet<DispatcherType> dispatcherTypes = EnumSet.of(
				DispatcherType.REQUEST, DispatcherType.FORWARD);
		return dispatcherTypes;
	}

	
	/**
	 * Configure Spring front controller servlet
	 * @param servletContext
	 */
	private void registerFronControllerServlet (final ServletContext servletContext) {
		ServletRegistration.Dynamic dispatcher = 
				servletContext.addServlet(FRONT_CONTROLLER_NAME, 
						new DispatcherServlet(webApplicationContextFactory (WEB_CONFIG_CLASSES)));
		dispatcher.addMapping("/");
		dispatcher.setLoadOnStartup(1);
	}
	
	/**
	 * Configure @link{ContextLoaderListener} to register parent @see(WebApplicationContext}
	 * @param servletContext
	 */
	private void registerContextLoaderListener (final ServletContext servletContext) {
		servletContext.addListener(new ContextLoaderListener(webApplicationContextFactory (INFRASTRUCTURE_CLASSES)));
	}
	
	/**
	 * Factory method to create {@link WebApplicationContext} instances.
	 * 
	 * @param annotatedClasses
	 * @return {@link WebApplicationContext}
	 */
	private WebApplicationContext webApplicationContextFactory (Class<?>... annotatedClasses) {
		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.register(annotatedClasses);
		return webApplicationContext;
	}
}
