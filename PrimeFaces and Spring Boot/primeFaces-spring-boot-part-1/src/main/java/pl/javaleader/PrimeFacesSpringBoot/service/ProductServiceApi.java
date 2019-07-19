package pl.javaleader.PrimeFacesSpringBoot.service;

import pl.javaleader.PrimeFacesSpringBoot.model.Product;
import java.util.List;

public interface ProductServiceApi {
    void save(Product product);
    List<Product> getAllProducts();
}
