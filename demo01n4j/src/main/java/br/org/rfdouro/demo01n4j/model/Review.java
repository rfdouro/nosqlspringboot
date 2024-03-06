package br.org.rfdouro.demo01n4j.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import lombok.Data;
import lombok.NonNull;

@Data
@Node
public class Review {
 @Id
 //@GeneratedValue
 private String neoId;
 @NonNull
 private String review_id;

 private String book_id, review_text, date_added, date_updated, started_at, read_at;
 private Integer rating, n_comments, n_votes;
}