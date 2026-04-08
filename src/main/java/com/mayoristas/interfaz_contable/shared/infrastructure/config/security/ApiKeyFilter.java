package com.mayoristas.interfaz_contable.shared.infrastructure.config.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

public class ApiKeyFilter extends OncePerRequestFilter {
    private final String API_KEY_HEADER = "API_KEY";
    private final String VALID_API_KEY = "6e0c3427-cee6-4e7a-ae50-8aeb090b7adc"; // Replace with your

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            final var apiKerOptional = Optional.ofNullable(request.getHeader(API_KEY_HEADER));
            final var apiKey = apiKerOptional.map(String::trim).orElseThrow(()-> new BadCredentialsException("Invalid API KEY : No header found"));
            if(!apiKey.equals(VALID_API_KEY)){
                throw new BadCredentialsException("Invalid API KEY : " + apiKey);
            }
        } catch (Exception e) {
            throw new BadCredentialsException("Invalid API KEY : "+e);
        }
        filterChain.doFilter(request, response);
    }

}
