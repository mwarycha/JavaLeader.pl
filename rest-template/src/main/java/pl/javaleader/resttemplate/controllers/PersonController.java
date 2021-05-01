package pl.javaleader.resttemplate.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.javaleader.resttemplate.exceptions.ResourceNotFoundException;
import pl.javaleader.resttemplate.model.Person;
import pl.javaleader.resttemplate.repositories.PersonRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/persons")
    public Person createNewPerson(@Valid @RequestBody Person person) {
        return personRepository.save(person);
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<Person> getEmployeeById(@PathVariable(value = "id") Long personId)
            throws ResourceNotFoundException {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found for id : " + personId));
        return ResponseEntity.ok().body(person);
    }

    @GetMapping("/persons")
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @PutMapping("/persons/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable(value = "id") Long personId, @Valid @RequestBody Person personData) throws ResourceNotFoundException {
        Person person = findPersonById(personId);
        person.setName(personData.getName());
        person.setSurname(personData.getSurname());
        person.setAge(personData.getAge());
        return ResponseEntity.ok(personRepository.save(person));
    }


    @DeleteMapping("/persons/{id}")
    public Map<String, Boolean> deletePerson(@PathVariable(value = "id") Long personId)
            throws ResourceNotFoundException {
        Person person = findPersonById(personId);
        personRepository.delete(person);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    private Person findPersonById(Long personId) throws ResourceNotFoundException {
        return personRepository.findById(personId).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + personId));
    }
}
