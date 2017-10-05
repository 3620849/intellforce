package com.example.demo.configurations;

import com.example.demo.services.AuthService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AuthFilterForAngular extends GenericFilterBean {
    private final AuthService authService;
    public AuthFilterForAngular (AuthService authService) {
        this.authService = authService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        SecurityContextHolder.getContext().setAuthentication(
                authService.getAuthentication((HttpServletRequest)servletRequest).orElse(null)
        );
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
