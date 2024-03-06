package br.org.rfdouro.demo01n4j.repos;

import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import br.org.rfdouro.demo01n4j.model.Professor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReactiveProfessorRepository extends ReactiveNeo4jRepository<Professor, String> {
 Flux<Professor> findFirst1000By();

 Mono<Professor> findOneById(String id);

 @Query("MATCH (p:Professor) RETURN p;")
 Flux<Professor> findProferrores();

 @Query("MATCH (p:Professor)\n" + //
   " RETURN count(p)")
 Flux<Long> getTotalProfs();

}
