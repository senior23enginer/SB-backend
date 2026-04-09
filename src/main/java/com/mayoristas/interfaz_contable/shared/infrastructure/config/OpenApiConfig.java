package com.mayoristas.interfaz_contable.shared.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Interfaz Contable Backend - API")
                        .description("API REST para la Interfaz Contable - Sistema de gestión de mayoristas")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Mayoristas")
                                .url("https://mayoristas.com")
                                .email("soporte@mayoristas.com"))
                        .license(new License()
                                .name("Proprietary")
                                .url("https://mayoristas.com/license")));
    }
}

