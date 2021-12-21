package pl.javaleader.putmapstruct.dto;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cart {
    public Set<Item> items;
}
