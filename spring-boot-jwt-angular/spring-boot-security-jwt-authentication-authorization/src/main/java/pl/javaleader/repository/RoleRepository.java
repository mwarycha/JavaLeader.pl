package pl.javaleader.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.javaleader.models.ERole;
import pl.javaleader.models.Role;

import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
