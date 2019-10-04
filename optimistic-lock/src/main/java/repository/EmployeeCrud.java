package repository;

import model.Employee;
import java.util.List;

public interface EmployeeCrud {
	List<Employee> findAllEmployee();
	Employee saveEmployee(Employee employeeBE);
	Employee updateEmployee(Employee employeeBE);
}