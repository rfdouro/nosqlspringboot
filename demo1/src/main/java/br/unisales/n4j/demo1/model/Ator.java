package br.unisales.n4j.demo1.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@Node("Ator")
public class Ator {
 @Id
 @GeneratedValue
 private String id;
 @NonNull
 private String nome;
 @JsonIgnore
 @Relationship(type = "ATUA_EM", direction = Direction.OUTGOING)
 private Set<Filme> filmes = new HashSet<>();
}
