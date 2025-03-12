package com.example.appspringdata.application;

import org.neo4j.cypherdsl.core.renderer.Configuration;
import org.neo4j.cypherdsl.core.renderer.Dialect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories
public class AppSpringDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppSpringDataApplication.class, args);
	}

	@Bean
	public Configuration configuration() {
		return Configuration.newConfig().withDialect(Dialect.NEO4J_5)
				.build();
	}
}