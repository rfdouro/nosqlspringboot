package br.org.rfdouro.demo01n4j.repos;

import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import br.org.rfdouro.demo01n4j.model.Review;
import reactor.core.publisher.Flux;

public interface ReviewRepository extends ReactiveCrudRepository<Review, String> {
 Flux<Review> findFirst1000By();

 @Query("MATCH (r:Review)-[rel:WRITTEN_FOR]->(b:Book {book_id: $book_id}) RETURN r;")
 Flux<Review> findReviewsByBook(String book_id);
}