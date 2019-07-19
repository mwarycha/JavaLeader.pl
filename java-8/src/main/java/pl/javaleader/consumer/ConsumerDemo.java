package pl.javaleader.consumer;

import pl.javaleader.utils.Person;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {

    final static List<Person> persons = Arrays.asList(
            new Person("Max"    , 18),
            new Person("Peter"  , 37),
            new Person("Pamela" , 24),
            new Person("David"  , 33)
    );

    public static void main(String[] args) {
        Consumer<Person> consumer = ConsumerDemo::printAgeConsumer;
        consumer.accept(persons.get(0));
        consumer.accept(persons.get(1));
        consumer.accept(persons.get(2));
        consumer.accept(persons.get(3));
    }

    public static void printAgeConsumer(Person person) {
        System.out.println(person.getAge());
    }
}
