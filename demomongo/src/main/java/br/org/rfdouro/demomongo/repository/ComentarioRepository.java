package br.org.rfdouro.demomongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.org.rfdouro.demomongo.model.Comentario;

@Repository
public interface ComentarioRepository extends MongoRepository<Comentario, String>{
 
}
