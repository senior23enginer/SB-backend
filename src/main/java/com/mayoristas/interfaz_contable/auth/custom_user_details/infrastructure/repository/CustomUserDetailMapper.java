package com.mayoristas.interfaz_contable.auth.custom_user_details.infrastructure.repository;

import com.mayoristas.interfaz_contable.auth.custom_user_details.domain.CustomUserDetail;
import com.mayoristas.interfaz_contable.auth.custom_user_details.domain.Role;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomUserDetailMapper implements RowMapper<CustomUserDetail> {

    @Override
    public CustomUserDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
        try {
            String username = rs.getString("username");
            String password = rs.getString("password");
            String role = rs.getString("role_name");
            String description = rs.getString("role_description");
            List<Role> roles = new ArrayList<>();
            if(role != null) {
                roles.add(new Role(role, description));
            }
            return new CustomUserDetail(username, password, roles);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
