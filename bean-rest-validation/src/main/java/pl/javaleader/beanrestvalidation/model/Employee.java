package pl.javaleader.beanrestvalidation.model;

import pl.javaleader.beanrestvalidation.validation.EmployeeRoleValid;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Employee {

    @Id
    private int id;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    private String salary;

    @EmployeeRoleValid
    private String role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
