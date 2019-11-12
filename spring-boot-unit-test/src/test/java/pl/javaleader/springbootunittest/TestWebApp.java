package pl.javaleader.springbootunittest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.web.client.TestRestTemplate;
import java.net.URL;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;
import org.junit.Before;
import org.junit.Test;

public class TestWebApp extends SpringBootUnitTestApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate template;

	private URL base;

	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/");
	}

	@Test
	public void getPersonContent() throws Exception {
		System.out.println(this.base);
		ResponseEntity<String> response = template.getForEntity(base.toString() + "person", String.class);

		HashMap<String,Object> result = new ObjectMapper().readValue(response.getBody(), HashMap.class);

		Assert.assertEquals(result.get("username"), "James");
		Assert.assertEquals(result.get("surname"), "Spring");
		Assert.assertEquals(result.get("salary"), 1000);

	}


}