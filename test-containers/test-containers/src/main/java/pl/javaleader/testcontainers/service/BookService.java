package pl.javaleader.testcontainers.service;

import pl.javaleader.testcontainers.model.Book;
import pl.javaleader.testcontainers.repositories.BookRepository;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    public final BookRepository repository;

    public Book saveBook(Book book) {
        return this.repository.save(book);
    }

    public List<Book> getBooks() {
        return this.repository.findAll();
    }
}
