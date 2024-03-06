package br.org.rfdouro.demo01n4j;

import org.neo4j.cypherdsl.core.renderer.Configuration;
import org.neo4j.cypherdsl.core.renderer.Dialect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.repository.config.EnableReactiveNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories
@EnableReactiveNeo4jRepositories
public class Demo01n4jApplication {

	public static void main(String[] args) {
		SpringApplication.run(Demo01n4jApplication.class, args);
	}

	//bean usado para as versões mais novas --> usar elementid
	@Bean
	Configuration cypherDslConfiguration() {
		return Configuration.newConfig()
				.withDialect(Dialect.NEO4J_5).build();
	}

}
