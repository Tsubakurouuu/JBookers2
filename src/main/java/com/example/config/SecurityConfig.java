package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;
	
		
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Override
	public void configure(WebSecurity web) throws Exception {
		web
			.ignoring()
				.antMatchers("/webjars/**")
				.antMatchers("/css/**")
				.antMatchers("/js/**")
				.antMatchers("/h2-console/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/home/about").permitAll()
				.antMatchers("/users/sign_in").permitAll()
				.antMatchers("/users/sign_up").permitAll()
				.anyRequest().authenticated();
		
		http
			.formLogin()
				.loginProcessingUrl("/users/sign_in")
				.loginPage("/users/sign_in")
				.failureUrl("/users/sign_in?error")
				.usernameParameter("name")
				.passwordParameter("password")
				.defaultSuccessUrl("/users/", true);
		
		http
			.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/users/logout"))
				.logoutUrl("/users/logout")
				.logoutSuccessUrl("/");
				
		
//		http.csrf().disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = passwordEncoder();
		auth
			.inMemoryAuthentication()
				.withUser("user")
					.password(encoder.encode("user"))
					.roles("GENERAL");
		auth
			.userDetailsService(userDetailsService)
			.passwordEncoder(encoder);
	}
	
	
}
