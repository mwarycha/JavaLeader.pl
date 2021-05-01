package pl.javaleader.resttemplate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javaleader.resttemplate.model.Person;

import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}