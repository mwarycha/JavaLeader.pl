package pl.javaleader.biConsumer;

import java.util.function.BiConsumer;

public class BiConsumerDemo {
    public static void main(String[] args) {

        BiConsumer<Integer, Integer> addition = (x, y) -> {
            System.out.println(x + y);
        };

        BiConsumer<Integer, Integer> subtraction = (x, y) -> {
            System.out.println(x - y);
        };

        addition.andThen(subtraction).accept(2, 2);
    }
}
