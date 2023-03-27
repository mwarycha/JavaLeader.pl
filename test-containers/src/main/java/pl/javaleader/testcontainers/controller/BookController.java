package pl.javaleader.testcontainers.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.javaleader.testcontainers.model.Book;
import pl.javaleader.testcontainers.service.BookService;
import java.util.List;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create/book")
    public Book createNewBook(@Valid @RequestBody Book book) {
        return this.service.saveBook(book);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/fetch/books")
    public List<Book> getAllBooks() {
        return this.service.getAllBooks();
    }
}
