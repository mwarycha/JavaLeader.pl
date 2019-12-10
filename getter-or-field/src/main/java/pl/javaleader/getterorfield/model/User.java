package pl.javaleader.getterorfield.model;

import javax.persistence.*;

@Entity
@Access(AccessType.FIELD)
public class User {

    @Id
    @GeneratedValue
    public Long id;

    private String name;

    @Column(name = "user_surname")
    private String surname;

    public User() {
    }

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Column(name = "user_name")
    @Access(AccessType.PROPERTY)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
