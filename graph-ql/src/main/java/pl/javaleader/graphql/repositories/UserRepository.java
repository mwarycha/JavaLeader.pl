package pl.javaleader.graphql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.javaleader.graphql.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}