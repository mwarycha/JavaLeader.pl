package pl.javaleader.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Person {
    String name;
    String surname;
    Sex sex;
    Address address;
}
