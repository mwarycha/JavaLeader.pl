package helpers;

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.List;

public class WinnerPatternHelper {

    private WinnerPatternHelper() {
    }

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

    public static boolean checkWinner(int[][] bingoCard, List<Pair<Integer, Integer>> listOfWinnerIndexes) {
        List<Pair<Integer,Integer>> pairList = listOfWinnerIndexes;
        int winner = 0;
        for(Pair<Integer,Integer> pair : pairList) {
            if (bingoCard[pair.getKey()][pair.getValue()] == 0) {
                winner +=1;
            }
        }
        return winner == 5 ? true : false;
    }

}
