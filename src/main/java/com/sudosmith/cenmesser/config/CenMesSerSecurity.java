package com.sudosmith.cenmesser.config;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class CenMesSerSecurity extends WebSecurityConfigurerAdapter{
	
	@Inject
	private UserDetailsService userDetailsService;
	
	@Override
	public void configure (final WebSecurity webSecurity) throws Exception {
		//ignore static resources
		webSecurity.ignoring().antMatchers("/resources/**");
	}
	
	
	@Override
	public void configure (final HttpSecurity httpSecurity) throws Exception{
		//configure form login
		httpSecurity.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/", Boolean.TRUE)
		.failureUrl("/login?nOk=1")
		//configure logout
		.and()
		.logout()
		.logoutUrl("/logout")
		.logoutSuccessUrl("/login")
		.deleteCookies("JSESSIONID")
		.and()
		//fix session issues
		.sessionManagement()
		.invalidSessionUrl("/login")
		.sessionFixation().newSession()
		.and()
		//configure url based authorization
		.authorizeRequests()
		.antMatchers("/login").permitAll()
		//protect rest of url
		.antMatchers("/**").authenticated();
	}
	
	@Bean
	public Md5PasswordEncoder passwordEncoder () {
		return  new Md5PasswordEncoder();
	}	
	
	@Override
	public void configure (final AuthenticationManagerBuilder authBuilder) throws Exception {
		authBuilder.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder ());
	}
}
