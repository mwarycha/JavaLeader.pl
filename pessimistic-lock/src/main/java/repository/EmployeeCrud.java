package repository;

import model.Employee;

public interface EmployeeCrud {
	Employee saveEmployee(Employee employeeBE);
	void updateEmployee();
	void readEmployee();
}