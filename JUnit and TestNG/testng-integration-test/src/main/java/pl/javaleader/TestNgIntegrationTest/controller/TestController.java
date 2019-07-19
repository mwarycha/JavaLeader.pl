package pl.javaleader.TestNgIntegrationTest.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import pl.javaleader.TestNgIntegrationTest.model.Employee;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public Employee printEmployee() {

        Employee emp = new Employee();
        emp.setName("emp1");
        emp.setDesignation("manager");
        emp.setEmpId("1");
        emp.setSalary(3000);

        return emp;
    }
}