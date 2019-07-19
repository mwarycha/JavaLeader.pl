package pl.javaleader.PrimeFacesSpringBoot2.service;

import pl.javaleader.PrimeFacesSpringBoot2.model.Product;
import java.util.List;

public interface ProductServiceApi {
    void save(Product product);
    List<Product> getAllProducts();
}
