package helpers;

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.List;

public class WinnerPatternHelper {

    public static List<Pair<Integer, Integer>> getVerticalIndexesPattern() {
        List<Pair<Integer, Integer>> pairs = new ArrayList();
        pairs.add(new Pair(0,2));
        pairs.add(new Pair(1,2));
        pairs.add(new Pair(2,2));
        pairs.add(new Pair(3,2));
        pairs.add(new Pair(4,2));
        return pairs;
    }

    public static List<Pair<Integer, Integer>> getHorizontalIndexesPattern() {
        List<Pair<Integer, Integer>> pairs = new ArrayList();
        pairs.add(new Pair(2,0));
        pairs.add(new Pair(2,1));
        pairs.add(new Pair(2,2));
        pairs.add(new Pair(2,3));
        pairs.add(new Pair(2,4));
        return pairs;
    }

}
