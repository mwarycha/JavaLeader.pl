package pl.javaleader.integrationtests;
;
import pl.javaleader.integrationtests.learning.model.Course;
import pl.javaleader.integrationtests.learning.repositories.CourseRepository;
import pl.javaleader.integrationtests.learning.services.CourseService;
import java.util.Optional;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CourseControllerMockTests {

    @MockBean
    private CourseRepository courseRepository;

    @InjectMocks
    CourseService courseService;

    @Test
    public void testRetrieveCourseWithMockRepository() throws Exception {
        Course course = new Course("Tom");
        course.setId(1);
        when(courseRepository.findById(2)).thenReturn(Optional.of(course));
        assertTrue(courseService.getCourseByCourseId(1).getName().contains("Tom"));
    }
}