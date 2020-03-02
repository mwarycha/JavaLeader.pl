package pl.javaleader.integrationtests.learning.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import pl.javaleader.integrationtests.learning.model.Course;
import pl.javaleader.integrationtests.learning.services.CourseService;
import java.net.URI;

@RestController
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/courses")
    public ResponseEntity<Void> createCourse(@RequestBody Course course) {
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(courseService.saveCourse(course))
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/courses/{courseId}")
    public Course getCourseById(@PathVariable Integer courseId) {
        return courseService.getCourseByCourseId(courseId);
    }

}