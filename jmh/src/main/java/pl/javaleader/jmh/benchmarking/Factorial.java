package pl.javaleader.jmh.benchmarking;

public class Factorial {

    public static int getFactorialFor(int number) {
        int factorial = 1;
        for (int i = 2; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static int getFactorialRec(int number) {
            if (number == 0) {
            return 1;
        } else {
            return number * getFactorialRec(number-1);
        }
    }
}
