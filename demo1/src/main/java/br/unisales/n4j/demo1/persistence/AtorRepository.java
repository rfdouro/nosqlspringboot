package br.unisales.n4j.demo1.persistence;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import br.unisales.n4j.demo1.model.Ator;

public interface AtorRepository extends Neo4jRepository<Ator, String> {
 
}
