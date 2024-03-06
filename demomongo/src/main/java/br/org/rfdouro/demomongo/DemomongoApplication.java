package br.org.rfdouro.demomongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import br.org.rfdouro.demomongo.repository.ItemTarefaRepositorio;

@SpringBootApplication
@EnableMongoRepositories
public class DemomongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemomongoApplication.class, args);
	}

}
