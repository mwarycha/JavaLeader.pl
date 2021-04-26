package pl.javaleader.jdbctemplate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import pl.javaleader.jdbctemplate.model.Person;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class JdbcTemplateApplication implements CommandLineRunner {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(JdbcTemplateApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		jdbcTemplate.execute("CREATE TABLE persons(" +
				"id SERIAL, name VARCHAR(255), surname VARCHAR(255))");

		List<Object[]> divideNames = Arrays.asList("Alice Spring", "James semaJ", "Alice Jok").stream()
				.map(name -> name.split(" "))
				.collect(Collectors.toList());

		divideNames.forEach(item -> System.out.println(item[0] + " " + item[1]));

		jdbcTemplate.batchUpdate("INSERT INTO persons(name, surname) VALUES (?,?)", divideNames);

		jdbcTemplate.query(
				"SELECT id, name, surname FROM persons WHERE name = ?", new Object[] { "Alice" },
				(rs, rowNum) -> new Person(rs.getLong("id"), rs.getString("name"), rs.getString("surname"))
		).forEach(customer -> System.out.println(customer));

		Person alice = jdbcTemplate.queryForObject(
				"SELECT id, name, surname FROM persons WHERE id = ?", new Object[] { "1" },
				(rs, rowNum) -> new Person(rs.getLong("id"), rs.getString("name"), rs.getString("surname"))
		);

		System.out.println(alice);

		Person james = (Person) jdbcTemplate.queryForObject(
				"SELECT id, name, surname FROM persons WHERE id = ?", new Object[] { "2" },
				new BeanPropertyRowMapper(Person.class));

		System.out.println(james);

		String name =  jdbcTemplate.queryForObject(
				"SELECT name FROM persons WHERE id = ?", new Object[] { "2" }, String.class);

		System.out.println(name);

	}
}