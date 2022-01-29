package pl.javaleader.elementcollectiononetomany.model.oneToMany;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "subject_entity")
@Data
@NoArgsConstructor
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    @ManyToOne
    @JoinColumn(name="subject_id", nullable=false)
    Teacher teacher;
}
