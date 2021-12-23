package pl.javaleader.putmapstruct.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="Cart")
public class CartEntity {

    @Id
    @GeneratedValue
    Integer id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="cart_id", nullable=false)
    public Set<ItemEntity> itemEntities = new HashSet<>();
}