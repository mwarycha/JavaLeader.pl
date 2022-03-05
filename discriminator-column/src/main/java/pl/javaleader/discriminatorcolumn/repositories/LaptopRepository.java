package pl.javaleader.discriminatorcolumn.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.javaleader.discriminatorcolumn.model.Laptop;

import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends CrudRepository<Laptop, Long> {
}
