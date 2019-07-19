package pl.javaleader.binaryOperator;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class BinaryOperatorDemo {

    static class MyCustomCOmparatorMin implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1-o2;
        }
    }

    static class MyCustomCOmparatorMax implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    }

    public static void main(String[] args) {

        BinaryOperator<Integer> addition = (x,y) -> x + y;
        System.out.println( addition.apply(2,2));


        BinaryOperator<Integer> biByMin = BinaryOperator.minBy(new MyCustomCOmparatorMin());
        System.out.println(biByMin.apply(5, 7));

        BinaryOperator<Integer> biByMax = BinaryOperator.minBy(new MyCustomCOmparatorMax());
        System.out.println(biByMax.apply(5, 7));

    }

}
