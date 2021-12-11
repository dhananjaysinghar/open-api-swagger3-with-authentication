package com.ba.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.csrf().disable()

				.formLogin().disable()
				.logout().disable()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.authorizeRequests(authorize -> authorize
						.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
						.antMatchers(HttpMethod.GET, "/swagger-ui/**").permitAll()
						.antMatchers(HttpMethod.GET, "/swagger-ui.html").permitAll()
						.antMatchers(HttpMethod.GET, "/v3/api-docs/**").permitAll()
						.anyRequest().authenticated())
				.httpBasic();
	}

	@Override
	public void configure(WebSecurity webSecurity) throws Exception {
		webSecurity.ignoring().antMatchers("/test");
	}

	@Autowired
	public void configGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
				.withUser("admin")
				.password("{noop}admin")
				.roles("ADMIN")
				.and()
				.withUser("user")
				.password("{noop}user")
				.roles("USER");
	}
}
