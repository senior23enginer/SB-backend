package com.mayoristas.interfaz_contable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class InterfazBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterfazBackendApplication.class, args);
	}

}
