package com.educlaas.xyzcar.config;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;


import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthFilter implements Filter {
	
	 private final JwtTokenProvider jwtTokenProvider = new JwtTokenProvider();

		@Override
		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
				throws IOException, ServletException {
			String header = ((HttpServletRequest) request).getHeader(HttpHeaders.AUTHORIZATION);

	        if (header != null) {
	            String[] authElements = header.split(" ");

	            if (authElements.length == 2
	                    && "Bearer".equals(authElements[0])) {
	                try {
	                    SecurityContextHolder.getContext().setAuthentication(
	                    		jwtTokenProvider.validateToken(authElements[1]));
	                } catch (RuntimeException e) {
	                    SecurityContextHolder.clearContext();
	                    throw e;
	                }
	            }
	        }

	        chain.doFilter(request, response);
			
		}
	

}
