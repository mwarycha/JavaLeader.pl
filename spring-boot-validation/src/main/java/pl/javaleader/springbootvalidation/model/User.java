package pl.javaleader.springbootvalidation.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User {

    @Size(min =3, max = 7)
    private String name;

    @Min(18)
    private int age;

    public User() {
    }

    public User(@Size(min = 3, max = 7) String name, @NotEmpty(message = "field age is empty!") int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
