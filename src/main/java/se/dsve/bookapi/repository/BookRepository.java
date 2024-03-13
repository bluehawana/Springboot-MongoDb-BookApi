package se.dsve.bookapi.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import se.dsve.bookapi.model.Book;


public interface BookRepository extends MongoRepository<Book, String> {
    // Här kan du lägga till fler metoder om du behöver anpassade databasoperationer
}