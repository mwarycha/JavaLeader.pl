package pl.javaleader.apachesolrautocompletesearch;

import org.springframework.boot.SpringApplication;
import pl.javaleader.apachesolrautocompletesearch.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApacheSolrAutocompleteSearchApplication {

	@Autowired
	CommentService commentService;

	public static void main(String[] args) {
		SpringApplication.run(ApacheSolrAutocompleteSearchApplication.class, args);
	}

}
