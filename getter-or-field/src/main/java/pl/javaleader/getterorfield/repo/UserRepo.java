package pl.javaleader.getterorfield.repo;

import org.springframework.data.repository.CrudRepository;
import pl.javaleader.getterorfield.model.User;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
}
