package pl.javaleader.makeiteasy;

import com.natpryce.makeiteasy.Maker;
import pl.javaleader.makeiteasy.instantiator.InstantiatorEmployee;
import pl.javaleader.makeiteasy.model.Employee;

import org.junit.jupiter.api.Test;

import static com.natpryce.makeiteasy.MakeItEasy.*;

public class EmployeeTest {

    @Test
    public void employeeTest() {

        Maker<Employee> jamesMaker = an(InstantiatorEmployee.Employee,
                with("James", InstantiatorEmployee.name),
                with("Spring", InstantiatorEmployee.surname),
                with(5000.00, InstantiatorEmployee.salary)
        );

        Employee james = make(jamesMaker);
        System.out.println(james);

        Maker<Employee> jamesWithSalary3000Maker = jamesMaker.but(
                with(InstantiatorEmployee.salary, 3000.00)
        );

        Employee jamesWithSalary3000 = make(jamesWithSalary3000Maker);
        System.out.println(jamesWithSalary3000);

    }

}
