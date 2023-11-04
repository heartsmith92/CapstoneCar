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
                    .requestMatchers(HttpMethod.GET, "xyz/cars", "xyz/users").permitAll()
                    .requestMatchers(HttpMethod.POST, "auth/login", "auth/register").permitAll()
                    .requestMatchers(HttpMethod.PUT, "xyz/users/*").permitAll()
                    .requestMatchers(HttpMethod.PUT, "xyz/car/status/*").authenticated()
                    .requestMatchers(HttpMethod.POST, "xyz/cars").authenticated()
                    .requestMatchers(HttpMethod.GET, "xyz/users/*").authenticated()
                    .anyRequest().authenticated())
            		.addFilterBefore(new JwtAuthFilter(), BasicAuthenticationFilter.class);;
        return http.build();
    }
	
}
