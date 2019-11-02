package pl.javaleader.oauth2sso.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.javaleader.oauth2sso.model.Contactdata;

public interface ContactRepository extends CrudRepository<Contactdata, String> {
}
