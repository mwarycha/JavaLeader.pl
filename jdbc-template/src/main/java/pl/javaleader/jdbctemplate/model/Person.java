package pl.javaleader.jdbctemplate.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class Person {
    private long id;
    private String name;
    private String surname;

    public Person() {
    }
}
