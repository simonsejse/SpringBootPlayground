package com.simonwinther.Refresh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableJpaRepositories
@EnableConfigurationProperties
public class RefreshApplication {
	public static void main(String[] args) {
		SpringApplication.run(RefreshApplication.class, args);
	}

}
