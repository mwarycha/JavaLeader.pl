package pl.javaleader.resttemplate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import pl.javaleader.resttemplate.model.Person;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class RestTemplateApplication  implements CommandLineRunner {

	@Autowired
	private RestTemplate restTemplate;

	private static final String GET_PERSON_URL    = "http://localhost:8080/api/persons";
	private static final String GET_PERSON_ID_URL = "http://localhost:8080/api/persons/{id}";
	private static final String CREATE_PERSON_URL = "http://localhost:8080/api/persons";
	private static final String UPDATE_PERSON_URL = "http://localhost:8080/api/persons/{id}";
	private static final String DELETE_PERSON_URL = "http://localhost:8080/api/persons/{id}";

	public static void main(String[] args) {
		SpringApplication.run(RestTemplateApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		createNewPerson();
		getPersonById();
		getAllPersons();
		updatePerson();
		getAllPersons();
		deleteEmployee();
		getAllPersons();
	}

	private void createNewPerson() {
		Person person = new Person("Java", "Leader", 30);
		RestTemplate restTemplate = new RestTemplate();
		Person result = restTemplate.postForObject(CREATE_PERSON_URL, person, Person.class);
		System.out.println(result);
	}

	private void getPersonById() {
		Map< String, String > params = new HashMap< String, String >();
		params.put("id", "1");
		Person result = restTemplate.getForObject(GET_PERSON_ID_URL, Person.class, params);
		System.out.println(result);
	}

	private void getAllPersons() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> httpEntity = new HttpEntity ("parameters", headers);
		ResponseEntity< String > result = restTemplate.exchange(GET_PERSON_URL, HttpMethod.GET, httpEntity, String.class);
		System.out.println(result);
	}

	private void updatePerson() {
		Map < String, String > params = new HashMap < String, String > ();
		params.put("id", "1");
		Person updatePerson = new Person("Leader", "Java", 30);
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(UPDATE_PERSON_URL, updatePerson, params);
	}

	private void deleteEmployee() {
		Map < String, String > params = new HashMap();
		params.put("id", "1");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(DELETE_PERSON_URL, params);
	}

}
