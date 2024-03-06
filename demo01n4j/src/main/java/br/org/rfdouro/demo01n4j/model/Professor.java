package br.org.rfdouro.demo01n4j.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;

import lombok.Data;
import lombok.NonNull;

@Data
@Node("Professor")
public class Professor {
 @Id
 @GeneratedValue
 private String id;
 @NonNull
 private String nome;
 @Relationship(type = "Ministra", direction = Direction.OUTGOING)
	private Set<Disciplina> disciplinas = new HashSet<>();
}
