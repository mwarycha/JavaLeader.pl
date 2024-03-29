package pl.javaleader.beanrestvalidation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import pl.javaleader.beanrestvalidation.model.Employee;
import pl.javaleader.beanrestvalidation.util.PrinterLog;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import pl.javaleader.beanrestvalidation.validation.EmployeeValidator;

import javax.validation.Valid;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeValidator employeeValidator;

    @InitBinder("employee")
    private void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(employeeValidator);
    }

    @Autowired
    PrinterLog printerLog;

    @PostMapping("/emp")
    public ResponseEntity<String> addEmployee(@Valid @RequestBody Employee employee) {
        System.out.println(employeeValidator.toString());
        return ResponseEntity.ok(printerLog.printSuccess("employee is valid"));
    }
}
