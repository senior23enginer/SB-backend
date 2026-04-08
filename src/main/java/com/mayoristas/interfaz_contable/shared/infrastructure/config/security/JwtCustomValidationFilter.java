package com.mayoristas.interfaz_contable.shared.infrastructure.config.security;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

@Component
public class JwtCustomValidationFilter extends OncePerRequestFilter {
    private final JwtServices jwtServices;
    private final JwtCustomUserDetails jwtCustomUserDetails;
    private static final String AUTHENTICATION_SCHEME = "Bearer ";
    private static final String AUTHENTICATION_HEADER = "Authorization";

    public JwtCustomValidationFilter(JwtServices jwtServices, JwtCustomUserDetails jwtCustomUserDetails) {
        this.jwtServices = jwtServices;
        this.jwtCustomUserDetails = jwtCustomUserDetails;
    }


    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        final var requestTokenHeader = request.getHeader(AUTHENTICATION_HEADER);
        String username = null;
        String jwtToken = null;
        if(Objects.nonNull(requestTokenHeader) && requestTokenHeader.startsWith(AUTHENTICATION_SCHEME)) {
            jwtToken = requestTokenHeader.substring(AUTHENTICATION_SCHEME.length());
            try {
                username = jwtServices.getUsernameFromToken(jwtToken);
            } catch (IllegalArgumentException e) {
                logger.error("Unable to get JWT Token or JWT Token has expired");
            } catch (ExpiredJwtException e) {
                logger.warn("JWT Token has expired"+e.getMessage());
            }
        }
        if(Objects.nonNull(username) && Objects.isNull(SecurityContextHolder.getContext().getAuthentication())) {
            final var userDetails = this.jwtCustomUserDetails.loadUserByUsername(username);
            if(this.jwtServices.validateToken(jwtToken, userDetails)) {
                var usernameAndPassAutToken = new UsernamePasswordAuthenticationToken(
                        userDetails,null,userDetails.getAuthorities()
                );
                usernameAndPassAutToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernameAndPassAutToken);
            }
        }
        filterChain.doFilter(request,response);
    }
}
