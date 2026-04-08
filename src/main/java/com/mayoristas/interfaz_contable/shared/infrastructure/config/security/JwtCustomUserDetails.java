package com.mayoristas.interfaz_contable.shared.infrastructure.config.security;

import com.mayoristas.interfaz_contable.auth.custom_user_details.application.find_by_username.CustomUserDetailsFinderByUsername;
import com.mayoristas.interfaz_contable.auth.custom_user_details.application.find_by_username.FindByUsernameCustomUserDetailsQuery;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class JwtCustomUserDetails implements UserDetailsService {
    private CustomUserDetailsFinderByUsername customUserDetailsFinderByUsername;


    public JwtCustomUserDetails(CustomUserDetailsFinderByUsername customUserDetailsFinderByUsername) {
        this.customUserDetailsFinderByUsername = customUserDetailsFinderByUsername;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            var customUserDetail =this.customUserDetailsFinderByUsername.findByUsername(
                    new FindByUsernameCustomUserDetailsQuery(username)
            );
            if (customUserDetail != null) {
                final var authorities = customUserDetail.getRoles().stream().map(
                        role -> new SimpleGrantedAuthority(role.getName())
                ).toList();
                return new User(
                        customUserDetail.getUsername(),
                        customUserDetail.getPassword(),
                        authorities
                );
            }
        } catch (Exception e) {
            throw new UsernameNotFoundException(e.getMessage());
        }
        throw  new UsernameNotFoundException("User not found "+username);
    }
}
