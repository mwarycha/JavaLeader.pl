package pl.javaleader.oauth2sso.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.javaleader.oauth2sso.model.EmailUserRepository;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends CrudRepository<EmailUserRepository, String> {
    List<EmailUserRepository> findByEmail(String email);
}
