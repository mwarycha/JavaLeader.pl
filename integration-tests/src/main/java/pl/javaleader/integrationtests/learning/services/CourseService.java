package pl.javaleader.integrationtests.learning.services;

import pl.javaleader.integrationtests.learning.model.Course;
import pl.javaleader.integrationtests.learning.repositories.CourseRepository;

import org.springframework.stereotype.Component;

@Component
public class CourseService {

    private CourseRepository repository;

    public CourseService() {
    }

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public int saveCourse(Course course) {
        Course savedCourse = repository.save(course);
        return savedCourse.getId();
    }

    public Course getCourseByCourseId(Integer courseId) {
        return repository.findById(courseId).orElse(new Course());
    }
}