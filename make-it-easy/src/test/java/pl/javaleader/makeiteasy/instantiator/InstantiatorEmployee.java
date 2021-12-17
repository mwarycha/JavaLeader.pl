package pl.javaleader.makeiteasy.instantiator;

import com.natpryce.makeiteasy.Instantiator;
import com.natpryce.makeiteasy.Property;
import com.natpryce.makeiteasy.PropertyLookup;
import pl.javaleader.makeiteasy.model.Employee;

import static com.natpryce.makeiteasy.Property.newProperty;

public class InstantiatorEmployee {

    public static final Property<Employee,String> name    = newProperty();
    public static final Property<Employee,String> surname = newProperty();
    public static final Property<Employee,Double> salary  = newProperty();

    public static final Instantiator<Employee> Employee = new Instantiator<Employee>() {
        @Override public Employee instantiate(PropertyLookup<Employee> lookup) {
            Employee employee = new Employee(
                    lookup.valueOf(name, "Java"),
                    lookup.valueOf(surname, "Leader"),
                    lookup.valueOf(salary, 1000.00));
            return employee;
        }
    };

}
