package pl.javaleader.SpEL.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "employee")
public class Employee {

  @Id
  @GeneratedValue
  private Long id;

  private String name;
  private String surname;
  private int salary;
  private Role role;

  public Employee() {
  }

  public Employee(Role role, String name, String surname, int salary) {
    this.role = role;
    this.name    = name;
    this.surname = surname;
    this.salary  = salary;
  }

  @Override
  public String toString() {
    return "Employee{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", surname='" + surname + '\'' +
            ", salary=" + salary +
            ", role=" + role +
            '}';
  }
}