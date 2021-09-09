package pl.javaleader.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Address {
    String street;
    String city;
    String state;
    String zipCode;
}
