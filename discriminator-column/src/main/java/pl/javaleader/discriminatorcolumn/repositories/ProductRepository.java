package pl.javaleader.discriminatorcolumn.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.javaleader.discriminatorcolumn.model.Product;

import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
