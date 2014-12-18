package com.sudosmith.cenmesser.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
//equalent xml element <mvc:annotation-driven>
@EnableWebMvc
@ComponentScan(value = {"com.sudosmith.cenmesser.controller"})
public class CenMesSerWebMvcConfiguration extends WebMvcConfigurerAdapter {
	
	/**
	 * Register your static resources
	 */
	@Override
	public void addResourceHandlers (final ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler("/resources/**")
			.addResourceLocations("classpath:/resources/");
	}
	
	/**
	 * Enable @see{DefaultServlet} so that request to static resources are handled by this servlet
	 */
	@Override
	public void configureDefaultServletHandling (DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	/**
	 * To resolve actual messages from message codes
	 * we need register bean @see {MessageSource} implementation class
	 */
	
	@Bean
	public MessageSource messageSource () {
		ResourceBundleMessageSource messageSources = new ResourceBundleMessageSource();
		messageSources.setBasenames("classpath:messages");
		messageSources.setUseCodeAsDefaultMessage(Boolean.TRUE);
		messageSources.setDefaultEncoding("UTF-8");
		return messageSources;
	}
	
	// -- Start Locale Support (I18N) --//
	/**
	 * The {@link LocaleChangeInterceptor} allows for the locale to be changed.
	 * It provides a <code>paramName</code> property which sets the request
	 * parameter to check for changing the language, the default is
	 * <code>locale</code>.
	 * 
	 * @return the {@link LocaleChangeInterceptor}
	 */
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor () {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		return localeChangeInterceptor;
	}
	
	/**
	 * The {@link LocaleResolver} implementation to use. Specifies where to
	 * store the current selectd locale.
	 * 
	 * @return the {@link LocaleResolver}
	 */ 
	@Bean
	public LocaleResolver localeResolver() {
		CookieLocaleResolver cookieResolver = new CookieLocaleResolver();
		cookieResolver.setDefaultLocale(Locale.ENGLISH);
		return cookieResolver;
	}
	
	/**
	 * Register all your interceptor 
	 */
	@Override
	public void addInterceptors (final InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor ());
	}
	
	/**
	 * Register @see{UrlResourceViewResolver} to resolve view name when String
	 * repersantion of view is returned from Handler method
	 */
	
	@Bean
	public UrlBasedViewResolver viewResolver () {
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	/*public AnnotationMethodHandlerAdapter annotationMethodHandlerAdapter () {
		AnnotationMethodHandlerAdapter methAdapter = new AnnotationMethodHandlerAdapter();
		
		return methAdapter;
	}*/
}
