package pl.javaleader.PrimeFacesSpringBoot.controllers;

import pl.javaleader.PrimeFacesSpringBoot.model.Product;
import pl.javaleader.PrimeFacesSpringBoot.service.ProductServiceApi;
import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope     ( value          = "session")
@Component ( value          = "productList")
@ELBeanName( value          = "productList")
@Join(       path = "/", to = "/product-list.jsf")
public class ProductListController {

    private List<Product> products;

    @Autowired
    ProductServiceApi productServiceApi;

    // These annotations are needed to load the collection of products before rendering the interface.
    // We could also load this collection in the getProducts, but this would make the process of rendering slow,
    // as this method will be called a lot of times in the JSF lifecycle
    @Deferred
    @RequestAction
    @IgnorePostback
    public void loadData() {
        products = productServiceApi.getAllProducts();
    }

    public List<Product> getProducts() {
        return products;
    }

}