package pl.javaleader.elementcollectiononetomany.controller;

import pl.javaleader.elementcollectiononetomany.model.Subject;
import pl.javaleader.elementcollectiononetomany.repositories.TeacherRepository;
import pl.javaleader.elementcollectiononetomany.service.AppService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @Autowired
    AppService appService;

    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping("/app")
    public ResponseEntity<String> getAllSubjects() {

        appService.createAndSaveSampleTeacherWithSubject("JAVA", "TEACHER_1");

        Set<Subject> subjects = new HashSet<>();

        teacherRepository.findById(1).ifPresent(teacher -> {
            subjects.addAll(teacher.getSubjects());
        });

        return new ResponseEntity(subjects.toString(), HttpStatus.OK);

    }

}
