package pl.javaleader.beanrestvalidation.controller;

import org.springframework.http.ResponseEntity;
import pl.javaleader.beanrestvalidation.model.Employee;
import pl.javaleader.beanrestvalidation.util.PrinterLog;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.Valid;

@RestController
public class EmployeeController {

    @Autowired
    PrinterLog printerLog;

    @PostMapping("/emp")
    public ResponseEntity<String> addEmployee(@Valid @RequestBody Employee employee) {
        return ResponseEntity.ok(printerLog.printSuccess("employee is valid"));
    }
}
