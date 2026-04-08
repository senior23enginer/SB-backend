package com.mayoristas.interfaz_contable.shared.infrastructure.config.postgres;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class PostgresJdbcConfig {

    @Bean(name = "postgresDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.postgres")
    public DataSource postgresDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean
    public JdbcTemplate postgresJdbcTemplate(@Qualifier("postgresDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public NamedParameterJdbcTemplate postgresNamedJdbcTemplate(@Qualifier("postgresDataSource") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }
}
