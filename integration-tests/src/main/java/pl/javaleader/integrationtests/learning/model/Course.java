package pl.javaleader.integrationtests.learning.model;

import javax.persistence.GenerationType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    int id;

    String name;

    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
