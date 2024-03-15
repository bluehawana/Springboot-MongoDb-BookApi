package se.dsve.bookapi.controller;

import com.mongodb.internal.VisibleForTesting;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import se.dsve.bookapi.model.Book;
import se.dsve.bookapi.service.BookService;
import se.dsve.bookapi.dto.BookDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
        // TODO: Write your code here, return status 200 if successfu
        Book createdBook = bookService.createBook(book);
        BookDTO bookDTO = new BookDTO(createdBook);
        return ResponseEntity.ok(bookDTO);
    }


    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        // TODO: Write your code here, return status 200 if successful
        List<Book> books = (List<Book>) bookService.getAllBooks();
        List<BookDTO> bookDTOs = books.stream()
                .map(BookDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(bookDTOs);
    }



    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable String id, @RequestBody Book bookDetails) {
        // TODO: Write your code here, return status 200 if successful
        if(bookService.getBookById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new BookDTO(bookService.updateBook(bookDetails)));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable String id) {
        // TODO: Write your code here, return status 200 if successful
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }

    @Test
    public void test() {
        Book book = new Book("1", "The Hobbit", "J.R.R. Tolkien", "Fantasy");
        BookDTO bookDTO = new BookDTO(book);
        assert bookDTO.getId().equals("1");
        assert bookDTO.getTitle().equals("The Hobbit");
        assert bookDTO.getAuthor().equals("J.R.R. Tolkien");
        assert bookDTO.getGenre().equals("Fantasy");
    }

    @Test
    public void testUpdateBook() {
        Book book1 = new Book("1", "The Hobbit1", "J.R.R. Tolkien", "Fantasy");
        Book book2 = new Book("1", "The Hobbit2", "J.R.R. Tolkien", "Fantasy");
        Book book3 = new Book("1", "The 3 ", "J.R.R. Tolkien", "Fantasy");
        Book book4 = new Book("1", "The 4", "J.R.R. Tolkien", "Fantasy");
        Book book5 = new Book("1", "The 5", "J.R.R. Tolkien", "Fantasy");
        Book book6 = new Book("1", "The 6", "J.R.R. Tolkien", "Fantasy");
    }

}
