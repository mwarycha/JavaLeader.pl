package pl.javaleader.integrationtests;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import pl.javaleader.integrationtests.learning.model.Course;
import org.springframework.boot.test.web.client.TestRestTemplate;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.skyscreamer.jsonassert.JSONAssert;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CourseControllerTests {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers           = new HttpHeaders();

    @Test
    public void testCreateStudent() throws Exception {
        HttpEntity<Course> entity       = new HttpEntity<Course>(new Course("Tom"), headers);
        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/courses"), HttpMethod.POST, entity, String.class);
        assertTrue(response.getHeaders().get(HttpHeaders.LOCATION).get(0).contains("/courses"));
    }

    @Test
    public void testRetrieveStudent() throws Exception {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/courses/1"), HttpMethod.GET, entity, String.class);
        JSONAssert.assertEquals(createSampleJsonData(), response.getBody(), false);
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

    private String createSampleJsonData() {
        return "{\"id\":1,\"name\":\"Tom\"}";
    }

}