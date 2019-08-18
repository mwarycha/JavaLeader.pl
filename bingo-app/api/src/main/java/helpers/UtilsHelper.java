package helpers;

public class UtilsHelper {

    private UtilsHelper() {

    }

    public static int[][] copyOf(int[][] originalArray) {
        int[][] newArray = new int[originalArray.length][originalArray[0].length];
        for (int x = 0; x < originalArray.length; x++) {
            for (int y = 0; y < originalArray[0].length; y++) {
                newArray[x][y]=originalArray[x][y];
            }
        }
        return newArray;
    }
}
