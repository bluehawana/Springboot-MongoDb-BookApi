package se.dsve.bookapi.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document // This tells Spring to make a collection out of this class
public class Book {
    private String id;
    private String title;
    private String author;
    private String genre;


    // Standard getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
