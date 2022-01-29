package pl.javaleader.elementcollectiononetomany.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    public Teacher(String name) {
        this.name = name;
    }

    @ElementCollection
    @CollectionTable(
            name = "subject",joinColumns = @JoinColumn(name="id")
    )
    Set<Subject> subjects = new HashSet<>();
}
