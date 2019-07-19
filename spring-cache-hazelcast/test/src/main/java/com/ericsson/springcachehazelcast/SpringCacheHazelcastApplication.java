package com.ericsson.springcachehazelcast;

import com.ericsson.springcachehazelcast.service.EmployeeService;
import model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static java.lang.String.format;
import static java.lang.System.nanoTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

class HelperMeasureTime {
	public static long getNanoTime() {
		return nanoTime();
	}
}

@SpringBootApplication
@EnableCaching
public class SpringCacheHazelcastApplication {

	@Autowired
	EmployeeService employeeService;

	private static final Logger logger = LoggerFactory.getLogger(SpringCacheHazelcastApplication.class);

	public static void main(String[] args) {

		String logFormat = "%s call took %d millis with result: %s";
		ApplicationContext context = SpringApplication.run(SpringCacheHazelcastApplication.class, args);
		EmployeeService employeeService = context.getBean(EmployeeService.class);

		employeeService.clearCache();

		Employee emp= new Employee();
		emp.setEmpId("emp");
		emp.setEmpName("emp");

		Employee emp1= new Employee();
		emp1.setEmpId("emp1");
		emp1.setEmpName("emp1");

		Employee emp2= new Employee();
		emp2.setEmpId("emp2");
		emp2.setEmpName("emp2");

		employeeService.insertEmployee(emp);

		List<Employee> employees = new ArrayList<>();
		employees.add(emp1);
		employees.add(emp2);
		employeeService.insertEmployees(employees);

		// ************************************************

		long start_time_1 = HelperMeasureTime.getNanoTime();
		System.out.println("Inside the main class making call to service first time");
		List<Employee> employeeList1 = employeeService.getAllEmployees();
		for (Employee employee : employeeList1) {
			System.out.println(employee.toString());
		}
		long end_time_1 = HelperMeasureTime.getNanoTime();

		logger.info(format(logFormat, "BEFORE CACHING", TimeUnit.NANOSECONDS.toMillis(end_time_1 - start_time_1), employeeList1));

		// ************************************************

		long start_time_2 = HelperMeasureTime.getNanoTime();

		System.out.println("Inside the main class making call to service second time where it will use hazelcast");
		List<Employee> employeeList2 = employeeService.getAllEmployees();
		for (Employee employee : employeeList2) {
			System.out.println(employee.toString());
		}
		long end_time_2 = HelperMeasureTime.getNanoTime();

		logger.info(format(logFormat, "AFTER CACHING", TimeUnit.NANOSECONDS.toMillis(end_time_2 - start_time_2), employeeList2));

		// ************************************************

		employeeService.clearCache();
		long start_time_3 = HelperMeasureTime.getNanoTime();

		Employee employeeTewmp = new Employee();
		employeeTewmp.setEmpId("new-emp");
		employeeTewmp.setEmpName("new-employee");
		employeeService.insertEmployee(employeeTewmp);

		System.out.println("Inside the main class making call to service second time where it will use hazelcast");
		List<Employee> employeeList3 = employeeService.getAllEmployees();
		for (Employee employee : employeeList3) {
			System.out.println(employee.toString());
		}
		long end_time_3 = HelperMeasureTime.getNanoTime();

		logger.info(format(logFormat, "AFTER CACHING", TimeUnit.NANOSECONDS.toMillis(end_time_3 - start_time_3), employeeList3));
	}
}

