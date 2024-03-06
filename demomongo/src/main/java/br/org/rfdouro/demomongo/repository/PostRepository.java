package br.org.rfdouro.demomongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.org.rfdouro.demomongo.model.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
 
}
