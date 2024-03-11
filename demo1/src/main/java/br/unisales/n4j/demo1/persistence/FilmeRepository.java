package br.unisales.n4j.demo1.persistence;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import br.unisales.n4j.demo1.model.Filme;

public interface FilmeRepository extends Neo4jRepository<Filme, String> {
 List<Filme> findFirst10By();

 //https://docs.spring.io/spring-data/neo4j/reference/appendix/custom-queries.html
 
 /*
 //uma opção de usar query para neo4j
 @Query("MATCH (f:Filme) WHERE ElementId(f) = $id RETURN f")
 Filme findOneById(@Param("id") String id);*/
 //outra opção de usar query para neo4j
 @Query("MATCH (f:Filme) WHERE ElementId(f) = :#{#id} RETURN f")
 Filme findOneById(String id);

 @Query("MATCH (f:Filme) RETURN f;")
 List<Filme> findFilmes();

 @Query("MATCH (f:Filme)\n" + //
   " RETURN count(f)")
 Long getTotalFilmes();
}
