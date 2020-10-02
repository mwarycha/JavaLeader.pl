package pl.javaleader.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.javaleader.models.User;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
}
