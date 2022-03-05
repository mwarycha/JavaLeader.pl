package pl.javaleader.discriminatorcolumn.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("monitor")
@Getter
@Setter
public class Monitor extends Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int x;
    private int y;
}
