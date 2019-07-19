package pl.javaleader.PrimeFacesSpringBoot.helpers;

import pl.javaleader.PrimeFacesSpringBoot.model.Product;
import pl.javaleader.PrimeFacesSpringBoot.service.ProductServiceApi;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

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
