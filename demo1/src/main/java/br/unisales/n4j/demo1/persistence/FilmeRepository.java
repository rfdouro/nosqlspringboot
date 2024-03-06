package br.unisales.n4j.demo1.persistence;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import br.unisales.n4j.demo1.model.Filme;

public interface FilmeRepository extends Neo4jRepository<Filme, String> {
 List<Filme> findFirst10By();

 Filme findOneById(String id);

 @Query("MATCH (f:Filme) RETURN f;")
 List<Filme> findFilmes();

 @Query("MATCH (f:Filme)\n" + //
   " RETURN count(f)")
 Long getTotalFilmes();
}
