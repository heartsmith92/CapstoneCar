package com.educlaas.xyzcar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class CorsConfig {
	
	@Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        	.csrf(csrf -> csrf.disable())
            .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests((requests) -> requests
            		// User
                    .requestMatchers(HttpMethod.GET, "xyz/users").permitAll()
                    .requestMatchers(HttpMethod.PUT, "xyz/users/*").permitAll()
                    .requestMatchers(HttpMethod.GET, "xyz/users/*").authenticated()
                    
                    // Post
                    .requestMatchers(HttpMethod.GET, "xyz/get/posts", "xyz/get/posts/*").permitAll()
                    .requestMatchers(HttpMethod.POST, "xyz/create/post").permitAll()
                    .requestMatchers(HttpMethod.PUT, "xyz/put/post/status/{postId}", "xyz/put/post/{postId}").permitAll()
                    
                    // Login/ Register
                    .requestMatchers(HttpMethod.POST, "auth/login", "auth/register").permitAll()
                    
                    // All other requests required a authentication check
                    .anyRequest().authenticated())
            		.addFilterBefore(new JwtAuthFilter(), BasicAuthenticationFilter.class);;
        return http.build();
    }
	
}
