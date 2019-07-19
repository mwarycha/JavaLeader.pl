package pl.javaleader.springcachehazelcast;

import pl.javaleader.springcachehazelcast.service.EmployeeService;
import com.hazelcast.core.*;
import model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

		SpringApplication.run(SpringCacheHazelcastApplication.class, args);

		String logFormat = "%s call took %d millis with result: %s";
		ApplicationContext context =
				SpringApplication.run(SpringCacheHazelcastApplication.class, args);
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
		System.out.println("call to service first time");
		List<Employee> employeeList1 = employeeService.getAllEmployees();
		for (Employee employee : employeeList1) {
			System.out.println(employee.toString());
		}
		long end_time_1 = HelperMeasureTime.getNanoTime();

		long duration = end_time_1 - start_time_1;

		logger.info(format(logFormat, "BEFORE CACHING", TimeUnit.NANOSECONDS.toMillis(duration), employeeList1));

		// ************************************************

		long start_time_2 = HelperMeasureTime.getNanoTime();

		System.out.println("call to service second time with hazelcast");
		List<Employee> employeeList2 = employeeService.getAllEmployees();
		for (Employee employee : employeeList2) {
			System.out.println(employee.toString());
		}
		long end_time_2 = HelperMeasureTime.getNanoTime();

		long duration2 = end_time_2 - start_time_2;

		logger.info(format(logFormat, "AFTER CACHING", TimeUnit.NANOSECONDS.toMillis(duration2), employeeList2));

		// ************************************************

		//employeeService.clearCache();
		long start_time_3 = HelperMeasureTime.getNanoTime();

		Employee employeeTewmp = new Employee();
		employeeTewmp.setEmpId("new-emp");
		employeeTewmp.setEmpName("new-employee");
		employeeService.insertEmployee(employeeTewmp);

		System.out.println("call to service second time with hazelcast");
		List<Employee> employeeList3 = employeeService.getAllEmployees();
		for (Employee employee : employeeList3) {
			System.out.println(employee.toString());
		}
		long end_time_3 = HelperMeasureTime.getNanoTime();

		long duration3 = end_time_3 - start_time_3;

		logger.info(format(logFormat, "AFTER CACHING", TimeUnit.NANOSECONDS.toMillis(duration3), employeeList3));

		// ************************************************
		// * fill & read map
		// ************************************************

		HazelcastInstance hzInstance = Hazelcast.newHazelcastInstance();

		Map<Long, String> map = hzInstance.getMap("data");
		map.clear();

		IdGenerator idGenerator = hzInstance.getIdGenerator("newid");
		for (int i = 0; i < 10; i++) {
			map.put(idGenerator.newId(), "message" + 1);
		}

		long start_time_4 = HelperMeasureTime.getNanoTime();
		System.out.println(map.keySet() + " " + map.values());
		long end_time_4 = HelperMeasureTime.getNanoTime();

		long duration4 = end_time_4 - start_time_4;

		logger.info(format(logFormat, "BEFORE CACHING", TimeUnit.NANOSECONDS.toMillis(duration4), map.toString()));

		long start_time_5 = HelperMeasureTime.getNanoTime();
		System.out.println(map.keySet() + " " + map.values());
		long end_time_5 = HelperMeasureTime.getNanoTime();

		long duration5 = end_time_5 - start_time_5;

		logger.info(format(logFormat, "AFTER CACHING", TimeUnit.NANOSECONDS.toMillis(duration5), map.toString()));

		map.put(idGenerator.newId(), "new data to map first");
		map.put(idGenerator.newId(), "new data to map second");

		long start_time_6 = HelperMeasureTime.getNanoTime();
		System.out.println(map.keySet() + " " + map.values());
		long end_time_6 = HelperMeasureTime.getNanoTime();

		long duration6 = end_time_6 - start_time_6;

		logger.info(format(logFormat, "AFTER CACHING", TimeUnit.NANOSECONDS.toMillis(duration6), map.toString()));

	}

}

