package pl.javaleader.jmh.benchmarking;

import static java.lang.Thread.sleep;

public class Factorial {

    public static int getFactorialFor(int number) {
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int getFactorialRec(int number) {
            if (number == 0) {
            return 1;
        } else {
            return number * getFactorialRec(number-1);
        }
    }
}
