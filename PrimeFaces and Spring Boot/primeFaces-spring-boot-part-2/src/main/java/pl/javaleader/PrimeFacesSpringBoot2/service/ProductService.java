package pl.javaleader.PrimeFacesSpringBoot2.service;

import org.springframework.stereotype.Service;
import pl.javaleader.PrimeFacesSpringBoot2.model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements  ProductServiceApi {

    static List<Product> products = new ArrayList();

    static {
        Product product1 = new Product(1L, "p1", new BigDecimal(200));
        Product product2 = new Product(2L, "p2", new BigDecimal(300));
        Product product3 = new Product(3L, "p3", new BigDecimal(400));
        Product product4 = new Product(4L, "p4", new BigDecimal(500));
        Product product5 = new Product(5L, "p5", new BigDecimal(600));

        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);

    }

    public List<Product> getAllProducts() {
        return products;
    }

    public void save(Product product) {
        products.add(product);
    }
}
