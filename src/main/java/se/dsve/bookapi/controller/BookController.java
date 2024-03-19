package se.dsve.bookapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import se.dsve.bookapi.model.Book;
import se.dsve.bookapi.service.BookService;
import se.dsve.bookapi.dto.BookDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
        if (bookService.getBookById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        else
        {bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }}

}
