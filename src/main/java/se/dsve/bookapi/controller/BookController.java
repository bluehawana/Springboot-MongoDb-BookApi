package se.dsve.bookapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import se.dsve.bookapi.model.Book;
import se.dsve.bookapi.service.BookService;
import se.dsve.bookapi.dto.BookDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookDTO> createBook(@RequestBody Book book) {
        // TODO: Write your code here, return status 200 if successful
        return null;
    }


    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        // TODO: Write your code here, return status 200 if successful
        return null;
    }



    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable String id, @RequestBody Book bookDetails) {
        // TODO: Write your code here, return status 200 if successful
        return null;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable String id) {
        // TODO: Write your code here, return status 200 if successful
        return null;
    }

}
