package pl.javaleader.reduce;

import pl.javaleader.utils.Person;

import java.util.Arrays;
import java.util.List;

public class ReduceDemo {

    public static void main(String[] args) {

        final String SPACE = " ";

        final List<Person> persons = Arrays.asList(
                new Person("Max", 18),
                new Person("Peter", 23),
                new Person("Pamela", 24),
                new Person("David", 12)
        );

        final Integer sumAges = persons
                .stream()
                .mapToInt(Person::getAge)
                .reduce(
                        10,
                        (sum, age) -> sum + age
                );

        System.out.println(sumAges);

        // the same as above but in other way
        persons
                .stream()
                .mapToInt(Person::getAge)
                .reduce(Integer::sum)
                .ifPresent(x -> System.out.println(x)); //  .ifPresent(System.out::print);


        // not optimized because of concat string in loop
        String concatNames = persons
                .stream()
                .map(Person::getName)
                .reduce("",
                        (s1, s2) -> s1 + SPACE + s2
                );

        System.out.println(concatNames);

        // optimized, better solution
        StringBuilder concatNamesOptimezed = persons
                .stream()
                .map(Person::getName)
                .map(name -> SPACE + name)
                .collect(StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append
                );

        System.out.println(concatNamesOptimezed);

        int[] array    = {1,2,3,4,5};
        int startValue = 0;
        int sum        = Arrays.stream(array).reduce(startValue, (x,y) -> x+y);

        System.out.println(sum);
        sum = Arrays.stream(array).reduce(startValue, Integer::sum);
        System.out.println(sum);
        sum = Arrays.stream(array).reduce(startValue, StatisticsUtility::addIntData);
        System.out.println(sum);

    }
}

class StatisticsUtility {
    public static int addIntData(int num1, int num2) {
        return num1 + num2;
    }
}
