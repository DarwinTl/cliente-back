package com.tienda.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.tienda.authorization.filter.JwtAuthenticationFilter;

@Configuration
public class SpringSecurityConfiguration {
	
		@Autowired
		private AuthenticationConfiguration authenticationConfiguration;
		
		@Bean
		AuthenticationManager authenticationManager() throws Exception{
			return authenticationConfiguration.getAuthenticationManager();
		}
		
		@Bean
		PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}

		@Bean
		SecurityFilterChain filterChain(HttpSecurity http) throws  Exception {
			
			return http.authorizeHttpRequests( auth ->
 					auth.requestMatchers(HttpMethod.GET,"/tienda/productos").permitAll()
 					.anyRequest().authenticated()
					)
					.addFilter(new  JwtAuthenticationFilter(authenticationManager()))
					.csrf(config-> config.disable())
					.sessionManagement(mng-> mng.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).build();
		}
	
}