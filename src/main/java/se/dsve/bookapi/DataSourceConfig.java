package se.dsve.bookapi;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

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
}
