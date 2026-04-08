package com.mayoristas.interfaz_contable.shared.infrastructure.config.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtServices {
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
    public static final String JWT_SECRET_KEY = "jxgEQe.XHuPq8VdbyYFNkAN.dudQ0903YUn4";

    private Claims getAllClaimsFromToken(String token) {
        final var key = Keys.hmacShaKeyFor(JWT_SECRET_KEY.getBytes(StandardCharsets.UTF_8));
        return Jwts
                .parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public <T> T getClaimsFromToken(String token, Function<Claims, T> claimsResolver) {
        final var claims = this.getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Date getExpirationDateFromToken(String token) {
        return getAllClaimsFromToken(token).getExpiration();
    }

    public Boolean isTokenExpired(String token) {
        final Date expiration = this.getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public String getUsernameFromToken(String token) {
        return this.getClaimsFromToken(token, Claims::getSubject);
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        if (token == null || token.isBlank() || userDetails == null) {
            return false;
        }
        final String expectedUsername = userDetails.getUsername();
        if (expectedUsername == null || expectedUsername.isBlank()) {
            return false;
        }
        final String usernameFromToken = getUsernameFromToken(token);
        if (usernameFromToken == null || usernameFromToken.isBlank()) {
            return false;
        }
        return expectedUsername.equals(usernameFromToken) && !isTokenExpired(token);
    }

    private String getToken(Map<String, Object> claims, String subject) {
        final var key = Keys.hmacShaKeyFor(JWT_SECRET_KEY.getBytes(StandardCharsets.UTF_8));
        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(key)
                .compact();
    }

    public String generateToken(UserDetails userDetails) {
        final Map<String, Object> claims = Collections.singletonMap("ROLES", userDetails.getAuthorities().toString());
        return this.getToken(claims, userDetails.getUsername());
    }
}
