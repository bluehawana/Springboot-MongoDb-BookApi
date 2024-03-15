package se.dsve.bookapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.dsve.bookapi.model.Book;
import se.dsve.bookapi.repository.BookRepository;

import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createBook(Book book) {
        // TODO: Write your code here
        return bookRepository.save(book);
    }

    public Optional<Book> getBookById(String id) {
        // TODO: Write your code here
        return bookRepository.findById(id);
    }

    public Iterable<Book> getAllBooks() {
        // TODO: Write your code here
        return bookRepository.findAll();
    }

    public Book updateBook(Book book) {
        // TODO: Write your code here
        if (bookRepository.existsById(book.getId())) {
            return bookRepository.save(book);
        }else {
            return bookRepository.save(book);
        }
    }

    public void deleteBook(String id) {
        // TODO: Write your code here
        bookRepository.deleteById(id);
    }
}
