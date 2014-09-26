package com.codesolid.securecassandra.filters;

import com.codesolid.securecassandra.configuration.ApplicationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class EnvironmentFilter extends OncePerRequestFilter {

    @Autowired
    ApplicationConfiguration configuration;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        request.setAttribute("applicationConfiguration", configuration); // add bean or just specific properties of bean.

        filterChain.doFilter(request, response);

    }

}