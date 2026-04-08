package com.mayoristas.interfaz_contable.auth.custom_user_details.application.find_by_username;

import com.mayoristas.interfaz_contable.shared.domain.bus.query.Query;

public class FindByUsernameCustomUserDetailsQuery implements Query {
    private String username;

    public FindByUsernameCustomUserDetailsQuery(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "FindByUsernameCustomUserDetailsQuery{" +
                "username='" + username + '\'' +
                '}';
    }
}
