package pl.javaleader.discriminatorcolumn.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "productType")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
}
