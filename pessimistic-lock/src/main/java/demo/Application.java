package demo;

import model.Employee;
import repository.EmployeeCrud;
import repository.EmployeeCrudImpl;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Application {

	public static void main(String args[]) {

		EmployeeCrud employeeCrud = new EmployeeCrudImpl();

		try {
			ExecutorService es = Executors.newFixedThreadPool(3);

			Employee employee = new Employee();
			employee.setName("emp");
			employeeCrud.saveEmployee(employee);
			es.execute(() -> {
				employeeCrud.updateEmployee();
			});
			es.execute(() -> {
				employeeCrud.readEmployee();
			});
			es.shutdown();
			es.awaitTermination(1, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}