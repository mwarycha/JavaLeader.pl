package helpers;

import java.util.Random;

public class RandomHelper {

    private static Random random = new Random();

    public static int generateRandoNumberFromRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        return random.nextInt((max - min) + 1) + min;
    }
}
