package pl.javaleader.PrimeFacesSpringBoot.model;

import java.math.BigDecimal;

public class Product {

    private Long id;
    private String name;
    private BigDecimal price;

    public Product() {
    }

    public Product(Long id, String name, BigDecimal price) {
        this.id    = id;
        this.name  = name;
        this.price = price;
    }

    public Product(String name, BigDecimal price) {
        this.name  = name;
        this.price = price;
    }

    // getters & setters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setId(Long id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setPrice(BigDecimal price) { this.price = price; }
}