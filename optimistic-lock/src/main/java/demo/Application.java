package demo;

import model.Employee;
import repository.EmployeeCrud;
import repository.EmployeeCrudImpl;
import java.util.List;

public class Application {

	public static void main(String args[]) {

		EmployeeCrud employeeCrud = new EmployeeCrudImpl();

		List<Employee> employees = employeeCrud.findAllEmployee();
		if (!employees.isEmpty()) {
			Employee employee = employees.get(0);
			employee.setName("James - update");
			employeeCrud.updateEmployee(employee);
			// Here Optimistic lock exception
			employeeCrud.updateEmployee(employee);
		} else {
			Employee employee = new Employee();
			employee.setName("emp");
			employeeCrud.saveEmployee(employee);
		}
	}
}