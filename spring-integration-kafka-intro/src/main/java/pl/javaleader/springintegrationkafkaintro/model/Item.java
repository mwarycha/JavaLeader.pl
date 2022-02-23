package pl.javaleader.springintegrationkafkaintro.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Item {
    private String name;
    public Item(String name) {
        this.name = name;
    }
}
