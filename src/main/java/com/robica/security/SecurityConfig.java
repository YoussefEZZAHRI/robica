package com.robica.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	/*auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN","USER");
	auth.inMemoryAuthentication().withUser("user").password("123456").roles("USER");
	*/
	
	auth.jdbcAuthentication().dataSource(dataSource)
	.usersByUsernameQuery("select login as principal,password as credentials from uilisateur where username=?")
	.authoritiesByUsernameQuery("select username as principal,role as role from utilisateur where username=?")
	.rolePrefix("ROLE_")
	.passwordEncoder(new Md5PasswordEncoder());
}
@Override
	protected void configure(HttpSecurity http) throws Exception {
	http.formLogin().loginPage("/login");
	http.authorizeRequests().antMatchers("/operations","/consulterCompte").hasRole("USER");
	http.authorizeRequests().antMatchers("/saveOperation").hasRole("ADMIN");
    http.exceptionHandling().accessDeniedPage("/403");
}
}
