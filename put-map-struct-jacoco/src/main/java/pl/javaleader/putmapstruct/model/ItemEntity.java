package pl.javaleader.putmapstruct.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="ITEM")
@Getter
@Setter
public class ItemEntity {

    @Id
    @GeneratedValue
    Integer id;

    String name;

    String code;

    public ItemEntity() {}

    public ItemEntity(String name, String code) {
        this.name = name;
        this.code = code;
    }
}