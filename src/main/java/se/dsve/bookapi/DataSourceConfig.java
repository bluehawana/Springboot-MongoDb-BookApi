package se.dsve.bookapi;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import se.dsve.bookapi.model.Book;
import se.dsve.bookapi.repository.BookRepository;

import java.util.Arrays;
import java.util.List;

@Configuration
public class DataSourceConfig {
    private final Dotenv dotenv;

    public DataSourceConfig() {
        dotenv = Dotenv.load();
    }

    @Bean
    public MongoClient mongoClient() {
        String uri = dotenv.get("MONGO_DB_URI");
        return MongoClients.create(uri);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), dotenv.get("DB_NAME"));
    }

    @Bean
    public BookRepository seedData(BookRepository bookRepository) {
        List<Book> books = Arrays.asList(
                new Book("1", "The Hobbit", "J.R.R. Tolkien", "Fantasy"),
                new Book("2", "The Fellowship of the Ring", "J.R.R. Tolkien", "Fantasy"),
                new Book("3", "The Two Towers", "J.R.R. Tolkien", "Fantasy"),
                new Book("4", "The Return of the King", "J.R.R. Tolkien", "Fantasy")
        );

        bookRepository.saveAll(books);
        return bookRepository;
    }
}


