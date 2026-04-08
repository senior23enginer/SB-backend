package com.mayoristas.interfaz_contable.auth.custom_user_details.infrastructure.repository;

import com.mayoristas.interfaz_contable.auth.custom_user_details.domain.CustomUserDetail;
import com.mayoristas.interfaz_contable.auth.custom_user_details.domain.CustomUserDetailRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.Optional;

@Repository
public class PostgresCustomUserDetailRepository implements CustomUserDetailRepository {
    private final Logger LOG = LoggerFactory.getLogger(PostgresCustomUserDetailRepository.class);
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public PostgresCustomUserDetailRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Optional<CustomUserDetail> findByUsername(String username) {
        LOG.debug("Buscando usuario username {}", username);
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("u.user_name username,");
        sql.append("u.password, ");
        sql.append("s.role_name role_name, ");
        sql.append("s.name role_description ");
        sql.append("FROM interfaz_contable.users u ");
        sql.append("INNER JOIN interfaz_contable.profiles p on p.id_profile = u.id_profile ");
        sql.append("INNER JOIN interfaz_contable.permits per on per.id_profile = p.id_profile ");
        sql.append("INNER JOIN interfaz_contable.sections s on s.id_section = per.id_section ");
        sql.append("WHERE u.user_name  = :USERNAME ");
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        LOG.debug("Query " + sql.toString());
        parameterSource.addValue("USERNAME", username, Types.VARCHAR);
        var customUserDetail = this.namedParameterJdbcTemplate.query(sql.toString(), parameterSource,
                new CustomUserDetailExtractor());
        LOG.debug("Objeto encontrado : " + customUserDetail.toString());
        if (customUserDetail != null ) {
            return Optional.of(customUserDetail);
        } else {
            return Optional.empty();
        }
    }

}
