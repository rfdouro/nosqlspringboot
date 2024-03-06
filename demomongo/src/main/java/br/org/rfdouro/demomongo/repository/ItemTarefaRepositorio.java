package br.org.rfdouro.demomongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.org.rfdouro.demomongo.model.ItemTarefa;

@Repository
public interface ItemTarefaRepositorio extends MongoRepository<ItemTarefa, String> {
    
 /*@Query("{nome:'?0'}")
 ItemTarefa findByNome(String nome);
 
 @Query(value="{categoria:'?0'}", fields="{'nome' : 1, 'repeticoes' : 1}")
 List<ItemTarefa> findAll(String category);
 
 public long count();*/

}
