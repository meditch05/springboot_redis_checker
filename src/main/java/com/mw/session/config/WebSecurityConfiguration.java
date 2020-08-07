package com.mw.session.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

// https://pasudo123.tistory.com/379
// https://deveric.tistory.com/76
// https://to-dy.tistory.com/94

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private final PasswordEncoder passwordEncoder;	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("user").password(passwordEncoder.encode("1")).roles("USER")
			.and()
			.withUser("admin").password(passwordEncoder.encode("2")).roles("ADMIN")
			.and()
			.withUser("p069528").password(passwordEncoder.encode("alskfl12~!")).roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.cors().disable()
			.authorizeRequests()
			.antMatchers("/admin/**").hasRole("ADMIN")
			.antMatchers("/user/**").hasRole("USER")
			.antMatchers("/p069528/**").hasRole("ADMIN")
			.antMatchers("/anonymous*").anonymous()
			.anyRequest().authenticated();
		
		http.formLogin()
			.defaultSuccessUrl("/", true)
			.and()
			.logout()
			.logoutUrl("/logout");
	}
}
