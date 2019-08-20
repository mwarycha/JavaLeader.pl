package helpers;

import java.util.Random;

public class RandomHelper {

    private static Random RANDOM = new Random();

    private RandomHelper() {
    }

    public static int generateRandomNumberFromRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        return RANDOM.nextInt((max - min) + 1) + min;
    }
}
