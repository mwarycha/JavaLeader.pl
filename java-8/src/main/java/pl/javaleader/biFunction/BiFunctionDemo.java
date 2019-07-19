package pl.javaleader.biFunction;

import java.util.function.BiFunction;
import java.util.function.Function;

public class BiFunctionDemo {

    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> addition = (x, y) -> {
            return x + y;
        };

        Function<Integer, Integer> subtraction1 = x -> x - 10;
        Function<Integer, Integer> subtraction2 = x -> x - 10;

        System.out.println(addition.andThen(subtraction1).apply(2,2));
        System.out.println(addition.andThen(subtraction1).andThen(subtraction2).apply(2,2));

    }
}
