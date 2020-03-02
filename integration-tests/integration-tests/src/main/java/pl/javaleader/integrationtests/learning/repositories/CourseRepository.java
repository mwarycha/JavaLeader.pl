package pl.javaleader.integrationtests.learning.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.javaleader.integrationtests.learning.model.Course;

import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {
}