package com.task.TaskManagement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class appConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource datasource;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.jdbcAuthentication().dataSource(datasource)
		.usersByUsernameQuery("select email as principal, password as credetials, true from user_model where email=?")
		.authoritiesByUsernameQuery("select user_email as principal, role_name as role from user_role where user_email=?")
		.passwordEncoder(passwordEncoder())
		.rolePrefix("ROLE_");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests().antMatchers("/register","/login","/about","/webjars/**","/","/css/**").permitAll()
	.anyRequest().authenticated().and()
	.formLogin().loginPage("/login").permitAll()
	.defaultSuccessUrl("/profile").and().logout().logoutSuccessUrl("/login").invalidateHttpSession(true)
	.deleteCookies("JSESSIONID");
	}

	
}
