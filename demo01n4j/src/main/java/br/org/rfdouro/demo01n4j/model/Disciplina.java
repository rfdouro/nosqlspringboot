package br.org.rfdouro.demo01n4j.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import lombok.Data;
import lombok.NonNull;

@Data
@Node("Disciplina")
public class Disciplina {
 @Id
 @GeneratedValue
 private String id;
 @NonNull
 private String nome;
}
