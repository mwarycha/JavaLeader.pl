package pl.javaleader.elementcollectiononetomany.service;

import pl.javaleader.elementcollectiononetomany.model.Subject;
import pl.javaleader.elementcollectiononetomany.model.Teacher;
import pl.javaleader.elementcollectiononetomany.repositories.TeacherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppService {

    @Autowired
    TeacherRepository teacherRepository;

    public void createAndSaveSampleTeacherWithSubject(String name, String teacher_name){
        Subject subject = new Subject(name);
        Teacher teacher = new Teacher(teacher_name);
        teacher.getSubjects().add(subject);
        teacherRepository.save(teacher);
    }

}
