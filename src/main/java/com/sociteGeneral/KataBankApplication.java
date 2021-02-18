package com.sociteGeneral;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@ComponentScan("com.sociteGeneral.repository")
@EntityScan("com.sociteGeneral.repository")
@EnableJpaRepositories("com.sociteGeneral.repository")

public class KataBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(KataBankApplication.class, args);
	}

}
