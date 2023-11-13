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
                    .requestMatchers(HttpMethod.GET)
                    .permitAll()
                    .requestMatchers(HttpMethod.POST)
                    .permitAll()
                    .requestMatchers(HttpMethod.PUT)
                    .permitAll()
                    .requestMatchers(HttpMethod.DELETE)
                    .permitAll()
                    .requestMatchers(HttpMethod.PUT)
                    .authenticated()
                    .requestMatchers(HttpMethod.POST)
                    .authenticated()
                    .requestMatchers(HttpMethod.GET)
                    .authenticated()
                    .requestMatchers(HttpMethod.DELETE)
                    .authenticated()
                    .anyRequest().authenticated())
            		.addFilterBefore(new JwtAuthFilter(), BasicAuthenticationFilter.class);;
        return http.build();
    }
	
}
