package pl.javaleader.cors.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.javaleader.cors.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{}