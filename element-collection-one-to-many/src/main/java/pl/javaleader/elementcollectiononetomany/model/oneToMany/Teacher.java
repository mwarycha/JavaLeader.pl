package pl.javaleader.elementcollectiononetomany.model.oneToMany;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "teacher_entity")
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

    @OneToMany(mappedBy = "teacher")
    Set<Subject> subjects = new HashSet<>();
}
