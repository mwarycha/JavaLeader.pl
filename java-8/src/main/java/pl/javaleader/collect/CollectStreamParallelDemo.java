package pl.javaleader.collect;

import pl.javaleader.utils.Person;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CollectStreamParallelDemo {

    public static void main(String[] args) {

        final List<Person> persons = Arrays.asList(
                new Person("Max",    18),
                new Person("Peter",  23),
                new Person("Pamela", 24),
                new Person("David",  12)
        );

        final List<Person> newParallelList = persons
                .parallelStream()
                .collect(
                        () ->{
                            System.out.println("create list");
                            return new LinkedList<>();
                        },
                        (result, element) -> {
                            final String threadName = Thread.currentThread().getName();
                            System.out.println(
                                    "[" + threadName + "] accumulator: " + result + " + " + element
                            );
                            result.add(element);
                        },
                        // combiner is only used in parallel Streams
                        (subResult1, subResult2) -> {
                            final String threadName = Thread.currentThread().getName();
                            System.out.println(
                                    "[" + threadName + "] combine: " + subResult1 + " + " + subResult2
                            );
                            subResult1.addAll(subResult2);
                        }
                );

        System.out.println(newParallelList);
    }
}
