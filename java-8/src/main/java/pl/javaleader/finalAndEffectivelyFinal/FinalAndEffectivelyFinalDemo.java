package pl.javaleader.finalAndEffectivelyFinal;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class FinalAndEffectivelyFinalDemo {

    private int start = 0;

    public static void main(String[] args) {

        int[] integers = new int[] { 2 };

        Runnable runnable = () -> System.out.println(IntStream
                .of(4, 5, 6)
                .map(val -> val + integers[0])
                .sum());

        new Thread(runnable).start();

        // change time to 5000 => result is 21
        // change time to 0    => result is 15
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        integers[0] = 0;
    }

    Supplier<Integer> incrementer() {
        return () -> start++;
    }

}
