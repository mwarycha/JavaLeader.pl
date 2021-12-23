package pl.javaleader.putmapstruct.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.javaleader.putmapstruct.model.ItemEntity;

public interface ItemRepository extends CrudRepository<ItemEntity, Integer> {
    ItemEntity getByCode(String code);
}
