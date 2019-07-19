package com.ericsson.springcachehazelcast.service.impl;

import java.util.List;
import com.ericsson.springcachehazelcast.dao.EmployeeDao;
import com.ericsson.springcachehazelcast.service.EmployeeService;
import model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
@CacheConfig(cacheNames = "employees")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public void insertEmployee(Employee employee) {
        employeeDao.insertEmployee(employee);
    }

    @Override
    public void insertEmployees(List<Employee> employees) {
        employeeDao.insertEmployees(employees);
    }

    @Override
    @Cacheable("getAllEmployeesCache")
    public List<Employee> getAllEmployees() {
        System.out.println("Inside the service layer");
        return employeeDao.getAllEmployees();

    }

    @CacheEvict(value="getAllEmployeesCache",allEntries=true)
    public void clearCache(){}

    @Override
    public void getEmployeeById(String empId) {
        Employee employee = employeeDao.getEmployeeById(empId);
        System.out.println(employee);
    }
}