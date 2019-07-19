package pl.javaleader.springcloudfeignclient.services;

import pl.javaleader.springcloudfeignclient.model.Product;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "product-service"/*, url = "http://localhost:8081"*/)
public interface ProductServiceClient {

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    List<Product> getAllProducts();

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    Product getProduct(@PathVariable("id") int productId);

}
