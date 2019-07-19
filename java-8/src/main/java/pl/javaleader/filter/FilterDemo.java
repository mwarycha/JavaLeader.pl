package pl.javaleader.filter;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import pl.javaleader.utils.Person;

import java.util.*;

import java.util.stream.Collectors;

public class FilterDemo {

    final static List<Person> persons = Arrays.asList(
            new Person("Max"    , 18),
            new Person("Peter"  , 37),
            new Person("Pamela" , 24),
            new Person("David"  , 33)
    );

    public static void main(String[] args) {
        List<Person> filteredList = new ArrayList<>();
        for(Person person : persons) {
            if (person.getAge() > 18) {
                filteredList.add(person);
            }
        }
        System.out.println(filteredList);

        Collections.sort(filteredList, new Comparator<Person>() {
            @Override public int compare(Person o1, Person o2) {
                return Double.compare(o1.getAge(), o2.getAge());
            }
        });

        System.out.println(filteredList);

        List<Person> filteredSortListInJava8 = filteredList.stream()
                .filter(person -> person.getAge() > 18)
                .sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList());

        filteredSortListInJava8.forEach(System.out::println);

        List<Person> filteredSortListInJava8WithPredicate = filteredList.stream()
                .filter(person -> person.getAge() > 18)
                .sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList());

        filteredSortListInJava8WithPredicate.forEach(System.out::println);

        Predicate <Person> predicateFilteredPerson = new Predicate<Person>() {
            @Override
            public boolean apply(Person person) {
                return person.getAge() > 18;
            }
        };

        System.out.println(Iterables.filter(persons, predicateFilteredPerson));

    }

}
