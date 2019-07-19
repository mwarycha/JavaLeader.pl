package pl.javaleader.springcachehazelcast.service;

import model.Employee;
import java.util.List;

public interface EmployeeService {
    void insertEmployee(Employee emp);
    void insertEmployees(List<Employee> employees);
    List<Employee> getAllEmployees();
    void getEmployeeById(String empid);
    void clearCache();
}