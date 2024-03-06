package br.org.testes.exnitrite.config;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.common.mapper.JacksonMapperModule;
import org.dizitart.no2.mvstore.MVStoreModule;
import org.dizitart.no2.repository.ObjectRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import br.org.testes.exnitrite.model.Pessoa;

@Order(1)
@Configuration
public class DBConfig {

 @Bean
 public Nitrite dataBase() {
  MVStoreModule storeModule = MVStoreModule.withConfig()
    .filePath("baseDados.db")
    .build();

  Nitrite db = Nitrite.builder()
    .loadModule(storeModule)
    .loadModule(new JacksonMapperModule())
    .openOrCreate("root", "salesiano");

  return db;
 }

 @Bean
 public ObjectRepository<Pessoa> repositoryPessoas() {
  return dataBase().getRepository(Pessoa.class);
 }

}
