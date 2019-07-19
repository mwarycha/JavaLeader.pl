package pl.javaleader.restapi.controller;

import java.util.List;
import pl.javaleader.restapi.model.User;
import pl.javaleader.restapi.service.UserService;
import pl.javaleader.restapi.util.CustomErrorType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class RestApiController {

	@Autowired
	UserService userService;

	// -------------------Retrieve All Users---------------------------------------------
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers() {
		List<User> users = userService.findAllUsers();
		if (users.isEmpty()) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(users, HttpStatus.OK);
	}

	// -------------------Retrieve Single User------------------------------------------
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getUser(@PathVariable("id") long id) {
		User user = userService.findById(id);
		if (user == null) {
			return new ResponseEntity(new CustomErrorType("User with id " + id + " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(user, HttpStatus.OK);
	}

	// -------------------Create a User-------------------------------------------
	// {"name":"Alex","age":51,"salary":10000}
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {

		if (userService.isUserExist(user)) {
			return new ResponseEntity(new CustomErrorType("Unable to create. A User with name " + user.getName() + " already exist."),HttpStatus.CONFLICT);
		}

		userService.saveUser(user);

		// new user would be created and will be accessible at the location mentioned in Location header.
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a User ------------------------------------------------
	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody User user) {

		User currentUser = userService.findById(id);

		if (currentUser == null) {
			return new ResponseEntity(new CustomErrorType("Unable to upate. User with id " + id + " not found."), HttpStatus.NOT_FOUND);
		}

		currentUser.setName(user.getName());
		currentUser.setAge(user.getAge());
		currentUser.setSalary(user.getSalary());

		userService.updateUser(currentUser);
		return new ResponseEntity(currentUser, HttpStatus.OK);
	}

	// ------------------- Delete a User-----------------------------------------
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
		User user = userService.findById(id);
		if (user == null) {
			return new ResponseEntity(new CustomErrorType("Unable to delete. User with id " + id + " not found."), HttpStatus.NOT_FOUND);
		}
		userService.deleteUserById(id);
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}

	// ------------------- Delete All Users-----------------------------
	@RequestMapping(value = "/user", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteAllUsers() {
		userService.deleteAllUsers();
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}
}