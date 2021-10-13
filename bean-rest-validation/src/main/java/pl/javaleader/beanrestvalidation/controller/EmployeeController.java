package pl.javaleader.beanrestvalidation.controller;

import org.springframework.http.ResponseEntity;
import pl.javaleader.beanrestvalidation.model.Employee;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
public class EmployeeController {

    @PostMapping("/emp")
    public ResponseEntity<String> addEmployee(@Valid @RequestBody Employee employee) {
        return ResponseEntity.ok("employee is valid");
    }
}
