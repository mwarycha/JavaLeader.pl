package pl.javaleader.putmapstruct.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.javaleader.putmapstruct.model.CartEntity;

public interface CartRepository extends CrudRepository<CartEntity, Integer> {
}
