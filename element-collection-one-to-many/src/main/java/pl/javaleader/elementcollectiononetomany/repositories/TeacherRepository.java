package pl.javaleader.elementcollectiononetomany.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.javaleader.elementcollectiononetomany.model.Teacher;

import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Integer> {
}
