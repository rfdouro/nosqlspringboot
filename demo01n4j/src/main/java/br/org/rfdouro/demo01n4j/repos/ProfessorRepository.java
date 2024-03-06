package br.org.rfdouro.demo01n4j.repos;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import br.org.rfdouro.demo01n4j.model.Professor;

public interface ProfessorRepository extends Neo4jRepository<Professor, String> {
 
}
