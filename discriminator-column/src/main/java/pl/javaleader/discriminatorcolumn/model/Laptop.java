package pl.javaleader.discriminatorcolumn.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("laptop")
@Getter
@Setter
public class Laptop extends Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int ramSize;
}
