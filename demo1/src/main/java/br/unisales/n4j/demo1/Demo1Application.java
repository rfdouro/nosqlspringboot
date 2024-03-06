package br.unisales.n4j.demo1;

import org.neo4j.cypherdsl.core.renderer.Configuration;
import org.neo4j.cypherdsl.core.renderer.Dialect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.repository.config.EnableReactiveNeo4jRepositories;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication
@EnableNeo4jRepositories
@EnableReactiveNeo4jRepositories
public class Demo1Application {

	// bean usado para as versões mais novas --> usa elementid por padrão
	@Bean
	Configuration cypherDslConfiguration() {
		return Configuration.newConfig()
				.withDialect(Dialect.NEO4J_5).build();
	}

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Servidor NoSQL Neo4J")
						.version("1.0.0")
						.contact(new Contact().email("rfdouro@gmail.com").name("Rômulo F. Douro"))
						.description("<h1>Exemplo de API com Neo4J</h1>"));
	}

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

}
