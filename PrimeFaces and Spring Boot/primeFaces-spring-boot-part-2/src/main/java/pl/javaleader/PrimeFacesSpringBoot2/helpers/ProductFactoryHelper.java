package pl.javaleader.PrimeFacesSpringBoot2.helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.javaleader.PrimeFacesSpringBoot2.model.Product;
import pl.javaleader.PrimeFacesSpringBoot2.service.ProductServiceApi;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class ProductFactoryHelper {

    static ProductServiceApi productServiceApiStatic;
    static long productId;

    @Autowired
    ProductServiceApi productServiceApi;

    @PostConstruct
    public void init() {
        productServiceApiStatic = productServiceApi;
        productId               = getLastProductIdFromInitListProducts() + 1;
    }

    // factory method
    public static Product createProduct() {
        Product product = new Product();
        product.setId(productId++);
        return product;
    }

    private static Long getLastProductIdFromInitListProducts() {
        List<Product> productList = productServiceApiStatic.getAllProducts();
        return productList.get(productList.size() - 1).getId();
    }
}
