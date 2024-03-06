package br.unisales.n4j.demo1.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@Node("Filme")
public class Filme {
 @Id
 @GeneratedValue
 private String id;
 @NonNull
 private String nome;
 private Integer dtlanc;
}
