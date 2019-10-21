package pl.javaleader;

import io.vavr.Function5;
import io.vavr.Lazy;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.collection.List;
import io.vavr.collection.Seq;
import io.vavr.control.Option;
import io.vavr.control.Try;
import java.util.Arrays;
import java.util.Collections;

import io.vavr.control.Validation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import static io.vavr.API.*;
import static io.vavr.Predicates.isIn;

@Getter
@Setter
@AllArgsConstructor
class User {
    private String email;
    private int age;
}

class UserValidator {

    String EMAIL_ERR = "Invalid email ";
    String AGE_ERR   = "Age must be grater than 18";

    public Validation<Seq<String>, User> validateUser(String email, int age) {
        return Validation.combine(validateEmail(email), validateAge(age)).ap(User::new);
    }

    private Validation<String, String> validateEmail(String name) {
        String invalidChars = name.replaceAll("^(.+)@(.+)$", "");
        return invalidChars.isEmpty() ? Validation.valid(name) : Validation.invalid(EMAIL_ERR + invalidChars);
    }

    private Validation<String, Integer> validateAge(int age) {
        return age < 18 ? Validation.invalid(AGE_ERR) : Validation.valid(age);
    }
}

public class FunctionalProgramming {

    public static void nullWithoutVavr() {
        Object object = null;
        if (object == null) {
            object = "obj";
        }
    }

    public static void nullWithVavr() {
        Option<Object> obj = Option.of(null);
        System.out.println(obj);
    }

    public static void nullWithVavrDefaultValue() {
        Object object = null;
        Option<Object> objectOption = Option.of(object);
        System.out.println( objectOption.getOrElse("javaleader.pl"));
    }

    public static void tuple() {
        Tuple2<String, String> java8 = Tuple.of("pl", "Javaleader");
        System.out.println(java8._1);
        System.out.printf(java8._2);
    }

    public static void tryIsFailue() {
        Try<Integer> result = Try.of(() -> 1 / 0);
        System.out.println(result.isFailure());
    }

    public static void tryWithDefaultValue() {
        Try<Integer> result = Try.of(() -> 1 / 0);
        System.out.println(result.getOrElse(0));
    }

    private static int sumOf5Integers(int a, int b, int c, int d, int e) {
        return a + b + c + d + e;
    }

    public static void functionInterfaceWith5Arguments() {
        Function5<Integer, Integer, Integer, Integer, Integer, Integer> integersSum = FunctionalProgramming::sumOf5Integers;
        Integer sum = integersSum.apply(1,2,3,4,5);
        System.out.println(sum);
    }

    public static void immutableCollectionThrowsError() {
        java.util.List<String> javaleader = Arrays.asList("javaleader");
        java.util.List<String> list     = Collections.unmodifiableList(javaleader);
        list.add(".pl");
    }

    public static void imutableCollectionWithVavr() {
        List<Integer> intList1 = List.of(1, 2, 3);
        List<Integer> intList2 =  intList1.append(4);
        System.out.println(intList1 == intList2);
    }

    public static void testUserValidator() {
        UserValidator userValidator = new UserValidator();

        Validation<Seq<String>, User> valid   = userValidator.validateUser("kontakt@javaleader.pl", 30);
        Validation<Seq<String>, User> invalid = userValidator.validateUser("kontaktjavaleader.pl", 14);
        System.out.println(valid.toString());
        System.out.println(invalid.toString());

        invalid.getError().forEach(error -> System.out.println(error));

    }

    public static void showHelp() {
        System.out.println("help...");
    }

    public static void patternMatching() {

        int input = 3;
        String output = Match(input).of(
                Case($(1), "one"),
                Case($(2), "two"),
                Case($(3), "three"),
                Case($(), "?"));
        System.out.println(output);


        String arg = "-h";
        Match(arg).of(
                Case($(isIn("-h", "--help")), o -> run(FunctionalProgramming::showHelp)),
                Case($(), o -> run(() -> {
                    throw new IllegalArgumentException();
                }))
        );

    }

    public static void lazy() {

        Lazy<Double> lazy = Lazy.of(Math::random);
        System.out.println(lazy.isEvaluated());

        double val1 = lazy.get();
        System.out.println(lazy.isEvaluated());
        System.out.println(val1);

        double val2 = lazy.get();
        System.out.println(lazy.isEvaluated());
        System.out.println(val2);
    }

    public static void main(String[] args) {
        nullWithoutVavr();
        nullWithVavr();
        nullWithVavrDefaultValue();
        tuple();
        tryIsFailue();
        tryWithDefaultValue();
        functionInterfaceWith5Arguments();
        immutableCollectionThrowsError();
        imutableCollectionWithVavr();
        testUserValidator();
        patternMatching();
        lazy();
    }

}
