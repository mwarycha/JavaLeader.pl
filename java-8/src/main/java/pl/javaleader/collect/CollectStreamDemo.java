package pl.javaleader.collect;

import pl.javaleader.utils.Person;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CollectStreamDemo {

    public static void main(String[] args) {

        final List<Person> persons = Arrays.asList(
                new Person("Max",    18),
                new Person("Peter",  23),
                new Person("Pamela", 24),
                new Person("David",  12));

        final List<Person> newPersonsList = persons
                .stream()
                .collect(
                        LinkedList::new,
                        (result, element) -> {
                            System.out.println(
                                    "accumulator: " + result + " => " + element
                            );
                            result.add(element);
                        },
                        // combiner is only used in parallel streams,
                        (p1, p2) -> {
                            System.out.println(
                                    "combiner: " + p1 + "," + p2
                            );
                        }
                );

        System.out.println(newPersonsList);
    }
}
