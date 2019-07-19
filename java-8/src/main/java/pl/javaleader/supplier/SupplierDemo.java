package pl.javaleader.supplier;

import pl.javaleader.utils.Person;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierDemo {

    final static List<Person> persons = Arrays.asList(
            new Person("Max"    , 18),
            new Person("Peter"  , 37),
            new Person("Pamela" , 24),
            new Person("David"  , 33)
    );

    public static void main(String[] args) {

        Supplier<Double> randomValue = () -> Math.random();
        System.out.println(randomValue.get());

        persons.stream().forEach((arg) -> {
            printAgesSupplier(() -> arg.getAge());
        });
    }

    public static void printAgesSupplier(Supplier supplier) {
        System.out.println(supplier.get());
    }
}
