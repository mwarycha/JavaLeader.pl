package pl.javaleader.testcontainers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javaleader.testcontainers.model.Book;

import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {}
