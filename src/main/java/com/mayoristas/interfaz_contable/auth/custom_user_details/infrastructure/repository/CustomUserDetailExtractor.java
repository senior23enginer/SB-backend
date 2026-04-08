package com.mayoristas.interfaz_contable.auth.custom_user_details.infrastructure.repository;

import com.mayoristas.interfaz_contable.auth.custom_user_details.domain.CustomUserDetail;
import com.mayoristas.interfaz_contable.auth.custom_user_details.domain.Role;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomUserDetailExtractor implements ResultSetExtractor<CustomUserDetail> {

    @Override
    public CustomUserDetail extractData(ResultSet rs) throws SQLException, DataAccessException {
        CustomUserDetail user = null;
        List<Role> roles = new ArrayList<>();
        while (rs.next()) {
            if (user == null) {
                user = new CustomUserDetail(
                        rs.getString("username"),
                        rs.getString("password"),
                        roles
                );
            }
            String rolName = rs.getString("role_name");
            String rolDescription = rs.getString("role_description");
            roles.add(new Role(rolName, rolDescription));
        }

        return user;
    }
}
