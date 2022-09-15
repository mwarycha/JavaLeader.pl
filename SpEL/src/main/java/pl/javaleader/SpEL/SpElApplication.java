package pl.javaleader.SpEL;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import pl.javaleader.SpEL.model.Employee;
import pl.javaleader.SpEL.model.Role;
import pl.javaleader.SpEL.repositories.EmployeeRepository;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class SpElApplication implements CommandLineRunner {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired EnviromentInfo enviromentInfo;

	@Override
	public void run(String... args) throws Exception {

		employeeRepository.save(new Employee(Role.MANAGER,"Tom", "Spring", 2000));
		employeeRepository.save(new Employee(Role.CEO,"Davids", "Spring", 3000));

		Iterable<Employee> all = employeeRepository.findAll();
		all.forEach(System.out::println);

		Iterable<Employee> allCriteriaEmployee = employeeRepository.findEmployeeByCriteria(Role.MANAGER,null, null, 2000);
		allCriteriaEmployee.forEach(System.out::println);

		System.out.println(enviromentInfo.JAVA_HOME);

	}

	public static void main(String[] args) {
		SpringApplication.run(SpElApplication.class, args);
	}

}
